/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;
import Models.Inventory;
import Models.InventorySelectionViewModel;
import Utility.Iterator;


/**
 *
 * @author DERRICK
 */
public class RenderAllInventoryStrategy extends ProductRenderingStrategy {

    private Inventory inventory;
    
    public RenderAllInventoryStrategy(Inventory inventory){
        this.inventory = inventory;
    }
    
    @Override
    public InventorySelectionViewModel Implement() {
        super.Implement();
        Iterator itr = inventory.getAllItemsIterator();
        return super.makeProductArray(itr);

    }
    
}
