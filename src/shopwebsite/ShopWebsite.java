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
        // TODO code application logic here
        LoginController controller = new LoginController();
        Customer customer = controller.Run();
        ICommand<Controller> cmd = new GetHomeCommand(customer);
        Controller productsController = cmd.execute();
    }
    
}
