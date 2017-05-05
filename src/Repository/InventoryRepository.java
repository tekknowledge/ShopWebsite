/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;
import Models.Inventory;
import Models.Product;
import Models.ProductChoice;
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
    
    public boolean TryAcquire(ProductChoice choice){
        ProductRepository productRepository = new ProductRepository();
        Product product = productRepository.getProduct(choice.getProduct().getId());
        if (product.getOnHand() < choice.getQuantity())
            return false;
        product.setOnHand(choice.getQuantity());
        return true;
    }
}
