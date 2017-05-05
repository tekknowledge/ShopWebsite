/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import Utility.StringUtility;

/**
 *
 * @author DERRICK
 */
public class Product {
    private String id;
    private String name;
    private double price;
    private short onHand;
    private ProductCategory category;
    private static final int STRING_FORMAT_FIXED_LENGTH = 40;
    
    public Product(String name, double price, short onHand, ProductCategory category){
        this.id = java.util.UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.onHand = onHand;
        this.category = category;
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
    
    public ProductCategory getCategory(){
        return category;
    }
    
    public void setOnHand(short adjustment){
        this.onHand = (short)(this.onHand + adjustment);
    }
    @Override
    public String toString(){
        String seperator = "-----------------------";
        return StringUtility.AddPadding(this.id, STRING_FORMAT_FIXED_LENGTH) + 
               StringUtility.AddPadding(this.name, STRING_FORMAT_FIXED_LENGTH) + 
               StringUtility.AddPadding("$" + Double.toString(this.price), STRING_FORMAT_FIXED_LENGTH) +
               StringUtility.AddPadding(this.category.name(), STRING_FORMAT_FIXED_LENGTH) + 
               StringUtility.AddPadding((this.onHand < 20 ? "***Low Stock***" : ""), STRING_FORMAT_FIXED_LENGTH) +
               "\n" + seperator;
    }
}
