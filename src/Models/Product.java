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
    private ProductCategory category;
    
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
    
    @Override
    public String toString(){
        // Todo: make this real string.
        String seperator = "-----------------------";
        return this.name + "\t" + ("$" + Double.toString(this.price)) + "\t"
                + this.category.name() + "\t" + (this.onHand < 20 ? "***Low Stock***" : "")
                + "\n" + seperator;
    }
}
