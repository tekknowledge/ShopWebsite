/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DataStore.ProductDataStore;
import Models.Product;
import Repository.ProductRepository;

/**
 *
 * @author DERRICK
 */
public class ProductsController extends Controller {
    public ProductsController(boolean isPrimeMember){
        String msg = isPrimeMember ? "Welcome Prime Member" : "Welcome. Sign up for Prime?";
        System.out.println(msg);
    }
    
    public void render(){
        System.out.println("Choose a product to add to your cart.");
        ProductRepository repository = new ProductRepository();
        Product[] products = repository.getAllProducts();
        for (int i = 0; i < products.length; i++){
            System.out.println(products[i].toString());
        }
    }
}
