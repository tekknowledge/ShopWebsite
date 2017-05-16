/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DataStore.CartDataStore;
import Models.Cart;

/**
 *
 * @author DERRICK
 */
public class CartRepository  {
    public CartRepository(){}
    
    public Cart get(String customerId){
        return CartDataStore.getCart(customerId);
    }
}
