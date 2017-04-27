/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;
import java.util.ArrayList;
/**
 *
 * @author DERRICK
 */
public class CommandInvoker {
    private ArrayList<ICommand> commands;
    
    public CommandInvoker(){
        commands = new ArrayList<ICommand>();
    }
    
    public void AddCommand(ICommand command){
        commands.add(command);
    }
    
    public Object Invoke(){
        for (ICommand cmd : commands){
            cmd.execute();
        }
        
        return null;
    }
}
