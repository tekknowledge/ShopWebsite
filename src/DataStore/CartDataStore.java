/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;

import Models.Cart;

/**
 *
 * @author DERRICK
 */
public class CartDataStore {
    private static Cart cart = null;
    public static Cart getCart(){
        cart = cart == null ? new Cart(): cart;
        return cart;
    }
}
