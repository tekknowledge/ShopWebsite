/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import Models.Cart;

/**
 *
 * @author DERRICK
 */
public class Order {
    private String customerid;
    private String id;
    private Product[] products;
    private Cart cart;
    
    public Order(Cart cart){
      
    }
    
    public String getCustomerId(){
        return "";
    }
    
}
