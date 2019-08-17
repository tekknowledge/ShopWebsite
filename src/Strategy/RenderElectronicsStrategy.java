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
public class RenderElectronicsStrategy extends ProductRenderingStrategy {

    private Inventory inventory;
    
    public RenderElectronicsStrategy(Inventory inventory){
        this.inventory = inventory;
    }
    @Override
    public InventorySelectionViewModel Implement() {
        super.Implement();
        Iterator itr = inventory.getElectronicsIterator();
        return super.makeProductArray(itr);
    }
    
}
