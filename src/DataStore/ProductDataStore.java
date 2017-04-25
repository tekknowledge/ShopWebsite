/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;

import Models.Product;

/**
 *
 * @author DERRICK
 */
public class ProductDataStore {
    private static Product[] products = new Product[]{
        new Product ("Energizer Battery - 12 pk", 11.99, (short)100),
        new Product ("Duracell Battery - 12 pk", 11.99, (short)300 ),
        new Product ("Rayovac Battery - 12 pk", 9.99, (short)68)
    };
    
    public static Product[] getProducts(){
        return products;
    }    
}
