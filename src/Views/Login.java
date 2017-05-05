/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;
import Command.CommandInvoker;
import Command.CommandInputResponse;
import Strategy.GatherLoginCredentialStrategy;
import Models.LoginCredentials;

/**
 *
 * @author dwithe2
 */
public class Login implements IView<LoginCredentials> {
    private LoginCredentials myData;
    
    public void Present(){
        CommandInvoker inv = new CommandInvoker(new GatherLoginCredentialStrategy());
        CommandInputResponse userNameResponse = new CommandInputResponse("Enter Your Username:");
        CommandInputResponse pwdResponse = new CommandInputResponse("Enter Your Password:");
        inv.AddCommand(userNameResponse);
        inv.AddCommand(pwdResponse);       
        inv.Invoke();
        myData = (LoginCredentials)inv.GetDataFromExecutedCommands();
        
    }
    
    public LoginCredentials GetData(){
        return myData;
    }
    
    
}
