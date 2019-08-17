/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;
import java.util.ArrayList;
import Strategy.CommandInvokerDataStrategy;

/**
 *
 * @author DERRICK
 */
public class CommandInvoker<T> {
    private ArrayList<ICommand> commands;
    private CommandInvokerDataStrategy<T> strategy = null;
    
    public CommandInvoker(CommandInvokerDataStrategy<T> dataReturnStrategy){
        commands = new ArrayList<ICommand>();
        strategy = dataReturnStrategy;
    }
    
    public CommandInvoker(){
        commands = new ArrayList<ICommand>();
    }
    public void AddCommand(ICommand command){
        commands.add(command);
    }
    
    public void Invoke(){
        ArrayList<Object> objects = new ArrayList<Object>();
        for (ICommand cmd : commands){
            if (strategy != null)
                strategy.addData(cmd.execute());
        }
    }
    
    public T GetDataFromExecutedCommands(){
        return strategy.Implement();
    }
}
