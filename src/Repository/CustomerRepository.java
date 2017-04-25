/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;
import Models.Customer;
import DataStore.CustomerDataStore;
import Utility.CustomerNotFoundException;

/**
 *
 * @author DERRICK
 */
public class CustomerRepository {
    public Customer Login(String userName, String password) throws CustomerNotFoundException {
        Customer[] allCustomers = CustomerDataStore.getCustomers();
        for (int i = 0; i < allCustomers.length; i++){
            Customer c = allCustomers[i];
            if (c.getUserName().equals(userName))
                return c;
        }       
        throw new CustomerNotFoundException();
    }
}
