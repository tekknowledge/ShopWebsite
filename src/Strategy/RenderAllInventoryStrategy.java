/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;
import Models.Inventory;
import Models.InventorySelectionViewModel;
import Models.Product;
import Utility.Iterator;
import javax.swing.JOptionPane;
import java.util.ArrayList;


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
        /*ArrayList<String> items = new ArrayList<String>();
        while (itr.hasNext()){
            items.add(((Product)itr.next()).toString()); //System.out.println(((Product)itr.next()).toString());
        }
        JOptionPane.showInputDialog(null, "Choose an item to purchase", 
                "Inventory", JOptionPane.INFORMATION_MESSAGE, null,
                items.toArray(), items.get(0)
                );*/
    }
    
}
