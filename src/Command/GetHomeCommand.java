/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;
import Models.Customer;
import Controllers.Controller;
import Controllers.ProductsController;

/**
 *
 * @author DERRICK
 */
public class GetHomeCommand implements ICommand<Controller> {
    
    private Customer customer;
    
    public GetHomeCommand(Customer customer){
        this.customer = customer;
    }
    
    // Returns the correct controller (and eventually view) based on whether user is a prime member or not
    public Controller execute(){
        if (customer.getIsPrimeMember()){
            // Eventually return Products controller w/ shipping or some sort of incentive applied
            return new ProductsController(true);
        } else {
            return new ProductsController(false);
        }
    }
}
