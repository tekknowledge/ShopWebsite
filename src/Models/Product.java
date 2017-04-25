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
public class Product {
    private String id;
    private String name;
    private double price;
    private short onHand;

    public Product(String name, double price, short onHand){
        this.id = java.util.UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.onHand = onHand;
    }
    
    public String getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public short getOnHand(){
        return onHand;
    }
    
    @Override
    public String toString(){
        // Todo: make this real string.
        String firstLine = this.name;
        String secondLine = "$" + Double.toString(this.price);
        String thirdLine = this.onHand < 20 ? "***Low Stock***" : "";
        String seperator = "-----------------------";
        System.out.println(firstLine);
        System.out.println(secondLine);
        System.out.println(thirdLine);
        System.out.println(seperator);
        return "";
    }
}
