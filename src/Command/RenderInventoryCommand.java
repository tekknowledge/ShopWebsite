/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;
import Models.Inventory;
import Strategy.ProductRenderingStrategy;
import java.util.Dictionary;
import java.util.Hashtable;
import Strategy.*;
import Utility.NullObject;
import Views.ChooseAProduct;
import Models.InventorySelectionViewModel;


/**
 *
 * @author DERRICK
 */
public class RenderInventoryCommand implements ICommand {

    private String choice;
    private Inventory inventory;
    private Dictionary<String, ProductRenderingStrategy> delegates;
    
    public RenderInventoryCommand(String choice, Inventory inventory){
        this.choice = choice;
        this.inventory = inventory;
        this.delegates = new Hashtable<String, ProductRenderingStrategy>();
        delegates.put("1", new RenderAllInventoryStrategy(this.inventory));
        delegates.put("2", new RenderElectronicsStrategy(this.inventory));
        delegates.put("3", new RenderApparelStrategy(this.inventory));
        delegates.put("4", new RenderSportingGoodsStrategy(this.inventory));
        delegates.put("5", new RenderBooksStrategy(this.inventory));
    }
    
    @Override
    public Object execute() {
        IStrategy renderProducts = null;
        try {
            renderProducts = delegates.get(choice);
            // Why do I have to cast this??
            InventorySelectionViewModel model = (InventorySelectionViewModel)renderProducts.Implement();
            return new ChooseAProduct(model);
        } catch (Exception ex){
            System.out.println("No inventory items exist for this selection!");
        }
        return new NullObject();
    }

    
}
