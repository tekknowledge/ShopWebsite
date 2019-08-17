/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;
import Models.LoginCredentials;
import java.util.ArrayList;

/**
 *
 * @author DERRICK
 */
public class GatherLoginCredentialStrategy extends CommandInvokerDataStrategy<LoginCredentials> {

    private LoginCredentials loginCredentials;
    private ArrayList<Object> rawData;
    
    public GatherLoginCredentialStrategy(){
        this.rawData = new ArrayList<Object>();
    }
    
    @Override
    public LoginCredentials Implement() {
        loginCredentials = new LoginCredentials();
        loginCredentials.Username = (String)rawData.get(0);
        loginCredentials.Password = (String)rawData.get(1);
        return loginCredentials;
    }
    
    @Override
    public void addData(Object o){
        this.rawData.add(o);
    }
}
