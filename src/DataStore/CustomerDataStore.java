/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;
import Models.Customer;

/**
 *
 * @author DERRICK
 */
public class CustomerDataStore {
    private static Customer[] customers = new Customer[]{
        new Customer ("Derrick", "Witherspoon", "dwitherspoon", "p@ssword", true, "Maryland" ),
        new Customer ("Someone", "Else", "selse", "p@ssword", false, "Deleware" )
    };
    
    public static Customer[] getCustomers(){
        return customers;
    }
}
