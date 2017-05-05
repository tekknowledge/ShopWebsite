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
import Command.CommandInvoker;
import Models.LoginCredentials;
import Command.CommandInputResponse;
import Models.LoginCredentials;
import Strategy.GatherLoginCredentialStrategy;
import Views.*;
/**
 *
 * @author DERRICK
 */
public class LoginController extends Controller {
    public Customer Render() {
        
        Customer customer = null;
        
        while (customer == null) {
            IView login = new Login();
            login.Present();
            LoginCredentials credentials = (LoginCredentials)login.GetData();
            
            /*
            CommandInvoker invoker = new CommandInvoker<LoginCredentials>(new GatherLoginCredentialStrategy());
            invoker.AddCommand(new CommandInputResponse("Enter Your Username:"));
            invoker.AddCommand(new CommandInputResponse("Enter Your Password:"));
            invoker.Invoke();
            LoginCredentials credentials = (LoginCredentials)invoker.GetDataFromExecutedCommands();
            */
            
            CustomerRepository repo = new CustomerRepository();

            try {
                customer = repo.Login(credentials.Username, credentials.Password);
            } catch (CustomerNotFoundException ex){
                System.out.println("Invalid credentials. Try again.");
                customer = null;
            }
        }
        System.out.println("Login was successful");
        return customer;
    }
}
