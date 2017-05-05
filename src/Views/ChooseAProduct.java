/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;
import Models.Product;
import Models.ProductChoice;
import javax.swing.JOptionPane;
import Utility.StringUtility;
import Models.InventorySelectionViewModel;

/**
 *
 * @author DERRICK
 */
public class ChooseAProduct implements IView<ProductChoice> {
    private InventorySelectionViewModel model;
    private ProductChoice productChoice;
    
    public ChooseAProduct(InventorySelectionViewModel model){
        this.model = model;
    }
    @Override
    public void Present(){
        Object product = JOptionPane.showInputDialog(null, model.getPrompt(), 
                model.getPageTitle(), JOptionPane.INFORMATION_MESSAGE, null,
                model.getProducts(), model.getProducts()[0]
                );    
        String qty = JOptionPane.showInputDialog(null, "Quantity?");
        productChoice = new ProductChoice((Product)product, (short)StringUtility.ConvertToInt(qty));
    }
    
    @Override
    public ProductChoice GetData(){
        return productChoice;
    }
}
