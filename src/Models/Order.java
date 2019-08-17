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
public class Order implements IOrder {
    private Customer customer;
    private String id;
    private Cart cart;
    
    private double subTotal;
    private double total;
    private Double shipping;
    private Tax tax;
    
    private Dictionary<Boolean, ComputeShippingStrategy> shippingStrategy = new Hashtable<Boolean, ComputeShippingStrategy>();
    private Dictionary<String, TaxComputationStrategy> taxStrategy = new Hashtable<String, TaxComputationStrategy>();
    
    public Order(Cart cart) throws CustomerNotFoundException {
      
      // Set the cart and customer
      this.cart = cart;
      CustomerRepository r = new CustomerRepository();
      this.customer = r.GetById(cart.getCustomerId());

      // Set up tax calculation strategies
      shippingStrategy.put(true, new PrimeMemberShippingStrategy());
      shippingStrategy.put(false, new NonPrimeMemberShippingStrategy());
      taxStrategy.put("Maryland", new MarylandTax());
      taxStrategy.put("Deleware", new DelewareTax());
      
      // Compute the total and subtotal
      computeTotals();

    }
    
    private void computeTotals() {
      // Subtotal: Sum of all items in the cart
      Iterator<ProductChoice> itr = cart.getIterator();
      
      while (itr.hasNext()){
        ProductChoice itemToBuy = itr.next();
        subTotal += itemToBuy.getProduct().getPrice() * itemToBuy.getQuantity();
      }
      
      // Get the correct tax and shipping strategies based on the customer
      IStrategy<Tax> computeTax = taxStrategy.get(customer.getState());
      IStrategy<Double> computeShipping = shippingStrategy.get(customer.getIsPrimeMember());
      
      // Compute the tax and shipping
      tax = computeTax.Implement();
      shipping = computeShipping.Implement();
      
      // Calculate the total
      total = (Math.round((subTotal * (tax.getTax())) * 100.0)  / 100.0) + shipping;
    }
    
    public double getSubTotal(){
      return subTotal;
    }
    
    public double getTotal(){
      return total;
    }
    
    public double getShipping(){
      return shipping;
    }
    
    public Tax getTax(){
      return tax;
    }
    
    public String print(){
      return toString();
    }
    
    @Override
    public String toString(){
      Iterator<ProductChoice> itr = cart.getIterator();
      
      String str = "-----------------------------------------------------------------------------------\n";
      
      // Print the items ordered
      while (itr.hasNext()){
        str += itr.next().toString();
        str += StringUtility.NEW_LINE;
      }   
      
      // Print the subtotal
      str += StringUtility.AddPadding("Subtotal", StringUtility.STRING_FORMAT_FIXED_LENGTH) + (StringUtility.AddPadding(Double.toString(getSubTotal()), StringUtility.STRING_FORMAT_FIXED_LENGTH * 2)) + StringUtility.NEW_LINE;
      
      // Print the tax
      str += tax.toString();
      
      // Print the shipping cost
      str += StringUtility.AddPadding("Shipping", StringUtility.STRING_FORMAT_FIXED_LENGTH)
        + StringUtility.AddPadding(Double.toString(shipping), StringUtility.STRING_FORMAT_FIXED_LENGTH) + StringUtility.NEW_LINE;
      
      // Print the total
      str += StringUtility.AddPadding("Total", StringUtility.STRING_FORMAT_FIXED_LENGTH) + StringUtility.AddPadding(Double.toString(total), StringUtility.STRING_FORMAT_FIXED_LENGTH) + StringUtility.NEW_LINE;  
      str += "-----------------------------------------------------------------------------------\n";
      return str;
    }
    
}
