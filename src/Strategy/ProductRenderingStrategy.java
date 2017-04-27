/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;
import Models.Product;
import java.util.ArrayList;
import Utility.Iterator;
import Models.InventorySelectionViewModel;

/**
 *
 * @author DERRICK
 */
public abstract class ProductRenderingStrategy implements IStrategy<InventorySelectionViewModel> {
    @Override
    public InventorySelectionViewModel Implement(){
        System.out.println("Choose a product to add to your cart.");
        return new InventorySelectionViewModel();
    }
    
    protected InventorySelectionViewModel makeProductArray(Iterator itr){
        ArrayList<Product> items = new ArrayList<Product>();
        while (itr.hasNext()){
            items.add(((Product)itr.next())); //System.out.println(((Product)itr.next()).toString());
        }      
        return new InventorySelectionViewModel(items.toArray(new Product[items.size()]), "Inventory", "Choose a product");
    }
}
