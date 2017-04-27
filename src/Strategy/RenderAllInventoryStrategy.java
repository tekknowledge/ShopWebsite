/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;
import Models.Inventory;
import Models.Product;
import Utility.Iterator;

/**
 *
 * @author DERRICK
 */
public class RenderAllInventoryStrategy implements IProductRenderingStrategy {

    private Inventory inventory;
    
    public RenderAllInventoryStrategy(Inventory inventory){
        this.inventory = inventory;
    }
    @Override
    public void Implement() {
        Iterator itr = inventory.getAllItemsIterator();
        while (itr.hasNext()){
            System.out.println(((Product)itr.next()).toString());
        }
    }
    
}
