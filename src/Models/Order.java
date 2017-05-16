/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import Models.Cart;
import Utility.Iterator;
import Strategy.IStrategy;
import Strategy.MarylandTax;
import Models.Tax;
import Models.Customer;
import Repository.CustomerRepository;
import Utility.CustomerNotFoundException;
import java.util.Dictionary;
import java.util.Hashtable;
import Strategy.ComputeShippingStrategy;
import Strategy.PrimeMemberShippingStrategy;
import Strategy.NonPrimeMemberShippingStrategy;
import Strategy.DelewareTax;
import Strategy.TaxComputationStrategy;
import Utility.StringUtility;

/**
 *
 * @author DERRICK
 */
public class Order {
    private Customer customer;
    private String id;
    private Cart cart;
    
    private double subTotal;
    private double total;
    
    private Dictionary<Boolean, ComputeShippingStrategy> shippingStrategy = new Hashtable<Boolean, ComputeShippingStrategy>();
    private Dictionary<String, TaxComputationStrategy> taxStrategy = new Hashtable<String, TaxComputationStrategy>();
    
    public Order(Cart cart) throws CustomerNotFoundException {
      this.cart = cart;
      CustomerRepository r = new CustomerRepository();
      this.customer = r.GetById(cart.getCustomerId());
      System.out.println("cid=");
      System.out.println(cart.getCustomerId());
        shippingStrategy.put(true, new PrimeMemberShippingStrategy());
        shippingStrategy.put(false, new NonPrimeMemberShippingStrategy());

    }
    
    public double getSubTotal(){
      Iterator<ProductChoice> itr = cart.getIterator();
      
      while (itr.hasNext()){
        ProductChoice itemToBuy = itr.next();
        subTotal += itemToBuy.getProduct().getPrice() * itemToBuy.getQuantity();
      }
      
      return subTotal;
    }
    
    public double getTotal(){
      return total;
    }
    @Override
    public String toString(){
      Iterator<ProductChoice> itr = cart.getIterator();
      
      String str = "-----------------------------------------------------------------------------------\n";
      while (itr.hasNext()){
        str += itr.next().toString();
        str += StringUtility.NEW_LINE;
      }   
      
      str += (StringUtility.AddPadding(Double.toString(getSubTotal()), StringUtility.STRING_FORMAT_FIXED_LENGTH * 3)) + StringUtility.NEW_LINE;
      taxStrategy.put("Maryland", new MarylandTax(getTotal()));
      taxStrategy.put("Deleware", new DelewareTax(getTotal()));
      IStrategy<Tax> computeTax = taxStrategy.get(customer.getState());
      IStrategy<Double> computeShipping = shippingStrategy.get(customer.getIsPrimeMember());
      Tax tax = computeTax.Implement();
      //tax.setSubTotal(subTotal);
      Double shipping = computeShipping.Implement();
      total = (Math.round((subTotal * (tax.getTax())) * 100.0)  / 100.0) + shipping;
      str += tax.toString();
      str += StringUtility.AddPadding("Shipping", StringUtility.STRING_FORMAT_FIXED_LENGTH)
        + StringUtility.AddPadding(Double.toString(shipping), StringUtility.STRING_FORMAT_FIXED_LENGTH) + StringUtility.NEW_LINE;
      str += StringUtility.AddPadding("Total", StringUtility.STRING_FORMAT_FIXED_LENGTH) + StringUtility.AddPadding(Double.toString(total), StringUtility.STRING_FORMAT_FIXED_LENGTH) + StringUtility.NEW_LINE;  
      str += "-----------------------------------------------------------------------------------\n";
      return str;
    }
    
    public String getCustomerId(){
        return "";
    }
    
}
