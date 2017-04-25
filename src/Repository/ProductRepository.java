/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DataStore.ProductDataStore;
import Models.Product;

/**
 *
 * @author DERRICK
 */
public class ProductRepository {
    public Product[] getAllProducts(){
        return ProductDataStore.getProducts();
    }
}
