/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;
import java.util.Scanner;
import Utility.NullObject;

/**
 *
 * @author dwithe2
 */
public class CommandInputResponse implements ICommand<String> {
    private Scanner scanner;
    private String prompt;
    
    public CommandInputResponse(String prompt){
        this.scanner = new Scanner(System.in);
        this.prompt = prompt;
    }
    
    public String execute(){
        System.out.println("Enter your username");
        return scanner.nextLine();
    }
}
