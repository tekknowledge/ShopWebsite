/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;
import Command.CommandInvoker;
import Command.CommandInputResponse;

/**
 *
 * @author dwithe2
 */
public class Login implements IView {
    public Object Present(){
        CommandInvoker inv = new CommandInvoker();
        CommandInputResponse userNameResponse = new CommandInputResponse("Enter Your Username:");
        CommandInputResponse pwdResponse = new CommandInputResponse("Enter Your Password:");
        inv.AddCommand(userNameResponse);
        inv.AddCommand(pwdResponse);
        
        inv.Invoke();
        return null;
    }
}
