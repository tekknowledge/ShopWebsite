/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import Utility.Iterator;
/**
 *
 * @author DERRICK
 */
public class ProductChoice {
    private Product product;
    private short quantity;
    
    public ProductChoice(Product product, short quantity){
        this.product = product; this.quantity = quantity;
    }
    
    public Product getProduct(){
        return product;
    }
    
    public short getQuantity(){
        return quantity;
    }
   
}
