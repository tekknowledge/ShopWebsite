/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import java.util.Scanner;
import Repository.CustomerRepository;
import Models.Customer;
import Utility.*;

/**
 *
 * @author DERRICK
 */
public class LoginController {
    public Customer Run() {
        
        Customer customer = null;
        
        while (customer == null) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Your Username:");
            String username = input.nextLine();
            System.out.println("Enter your password:");
            String pwd = input.nextLine();
            CustomerRepository repo = new CustomerRepository();

            try {
                customer = repo.Login(username, pwd);
            } catch (CustomerNotFoundException ex){
                System.out.println("Invalid credentials. Try again.");
                customer = null;
            }
        }
        System.out.println("Login was successful");
        return customer;
    }
}
