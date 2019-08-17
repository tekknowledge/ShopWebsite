/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import Utility.Iterator;
import Utility.StringUtility;
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
    
    @Override
    public String toString(){
        return StringUtility.AddPadding(this.getProduct().getName(), StringUtility.STRING_FORMAT_FIXED_LENGTH) + 
               StringUtility.AddPadding("$" + Double.toString(this.getProduct().getPrice()), StringUtility.STRING_FORMAT_FIXED_LENGTH)
          + StringUtility.AddPadding("x " + Integer.toString(this.getQuantity()), StringUtility.STRING_FORMAT_FIXED_LENGTH);
    }
   
}
