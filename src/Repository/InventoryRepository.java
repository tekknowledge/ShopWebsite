/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;
import Models.Inventory;
import Models.Product;
import java.util.*;
/**
 *
 * @author DERRICK
 */
public class InventoryRepository {
    public Inventory get(){
        ProductRepository productRepository = new ProductRepository();
        Product[] products = productRepository.getAllProducts();
        return new Inventory(new ArrayList<Product>(Arrays.asList(products)));
    }
}
