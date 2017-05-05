/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Repository.ProductRepository;
import Repository.InventoryRepository;
import Models.Inventory;
import Models.ProductChoice;
import java.util.Scanner;
import Command.*;
import Views.*;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a category of products to display");
        System.out.println("1 - All Products \t 2 - Electronics \t 3 - Apparrel \t 4 - Sporting Goods \t 5 - Books");
        
        InventoryRepository repository = new InventoryRepository();
        Inventory inventory = repository.get();
        ICommand renderInventory = new RenderInventoryCommand(scanner.nextLine(), inventory);
        IView view = (IView)renderInventory.execute();
        view.Present();
        ProductChoice choice = (ProductChoice)view.GetData();
        System.out.println(choice.getProduct().toString());
        System.out.println(choice.getQuantity());
        ProductRepository productRepo = new ProductRepository();
        //System.out.println("old count = ");
        //System.out.println(productRepo.getProduct(choice.getProduct().getId()).getOnHand());
        productRepo.UpdateInventoryCount(choice.getProduct(), (choice.getQuantity() * -1));
        //System.out.println("new count = ");
        //System.out.println(productRepo.getProduct(choice.getProduct().getId()).getOnHand());
        
    
    }
}
