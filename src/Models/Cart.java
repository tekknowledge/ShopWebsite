/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import Utility.Iterator;
import java.util.ArrayList;

/**
 *
 * @author DERRICK
 */
public class Cart {
    private String customerId;
    private String id;
    private ArrayList<ProductChoice> products;
    
    public Cart(String customerId){
        this.customerId = customerId;
        products = new ArrayList<ProductChoice>();
    }
    
    public String getCustomerId(){
        return customerId;
    }    
    
    public String getId(){
        return id;
    }
    
    public ArrayList<ProductChoice> getProducts(){
        return products;
    }
    
    public void addProduct(ProductChoice product){
        this.products.add(product);
    }
    
    public void setCustomerId(String customerId)  {
        this.customerId = customerId;
    }
    
    public Iterator<ProductChoice> getIterator(){
        return new ModelIterator<ProductChoice>(products);
    }
}
