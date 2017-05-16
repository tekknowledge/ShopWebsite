/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopwebsite;
import Controllers.*;
import Models.*;
import Command.GetHomeCommand;
import Command.ICommand;
/**
 *
 * @author DERRICK
 */
public class ShopWebsite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Ask user to log in
        LoginController controller = new LoginController();
        Customer customer = controller.Render();
        
        // Display product list
        ICommand<Controller> cmd = new GetHomeCommand(customer);
        Controller productsController = cmd.execute();
        ((ProductsController)productsController).Render();
        
        // Display cart
        CartController cartController = new CartController(customer.getId());
        Cart cart = cartController.Render();
        
        // Display order
        OrderController orderController = new OrderController(customer, cart);
        Order order = orderController.Render();
        

    }
    
}
