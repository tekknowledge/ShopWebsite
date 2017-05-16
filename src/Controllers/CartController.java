/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import Repository.CartRepository;
import Models.Cart;
import Models.ProductChoice;
import java.util.ArrayList;
import Views.ShowCart;
import Utility.NullObject;

/**
 *
 * @author DERRICK
 */
public class CartController extends Controller<Cart> {
  
  private String customerId;
  
  public CartController(String customerId) {
    this.customerId = customerId;
  }
    @Override
    public Cart Render(){
        // Get the user's cart.
        CartRepository cartRepository = new CartRepository();
        Cart cart = cartRepository.get(customerId);
        
        ShowCart view = new ShowCart(cart);
        view.Present();
        return view.GetData();
    }
}
