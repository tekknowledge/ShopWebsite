/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;
import Models.Cart;
import javax.swing.JOptionPane;
import Utility.Iterator;
import Models.ProductChoice;
import Utility.StringUtility;
/**
 *
 * @author DERRICK
 */
public class ShowCart implements IView<Cart> {

    private Cart cart;
    
    public ShowCart(Cart cart){
        this.cart = cart;
    }
    
    @Override
    public void Present() {
        Iterator<ProductChoice> products = cart.getIterator();
        String message = "";
        while (products.hasNext()){
            message += products.next().getProduct().toString() + StringUtility.NEW_LINE;
        }
        if ( JOptionPane.showConfirmDialog(null, "buy StringUtility.NEW_LINE" + message) == JOptionPane.YES_OPTION){
            System.out.println("hello");
        } else {
            System.out.println("Need to implement emptying cart");
        }
        
    }

    @Override
    public Cart GetData() {
        return cart;
    }
    
}
