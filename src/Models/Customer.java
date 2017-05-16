/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author DERRICK
 */
public class Customer {
    
    public Customer(String firstName, String lastName, String userName, String password, boolean isPrimeMember, String state){
        this.id = java.util.UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.isPrimeMember = isPrimeMember;
        this.userName = userName;
        this.password = password;
        this.state = state;
    }
    
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String state;
    private String sessionId;
    
    //private Address address;
    private boolean isPrimeMember;
    private String id;
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setState(String state){
        this.state = state;
    }
    
    public void setIsPrimeMember(boolean isPrimeMember){
        this.isPrimeMember = isPrimeMember;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getState(){
      return state;
    }
    public boolean getIsPrimeMember(){
        return isPrimeMember;
    }
    
    public String getId(){
        return id;
    }
    
    public String getUserName() {
        return this.userName;
    }
}
