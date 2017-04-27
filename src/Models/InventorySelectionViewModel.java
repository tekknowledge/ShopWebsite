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
public class InventorySelectionViewModel {
    private Product[] products;
    private String pageTitle;
    private String prompt;
    
    public InventorySelectionViewModel(){
        products = new Product[]{};
        pageTitle = "";
        prompt = "";
    }
    
    public InventorySelectionViewModel(Product[] products, String pageTitle, String prompt){
        this.products = products;
        this.pageTitle = pageTitle;
        this.prompt = prompt;
    }
    
    public Product[] getProducts(){
        return products;
    }
    
    public String getPageTitle(){
        return pageTitle;
    }
    
    public String getPrompt(){
        return prompt;
    }
}
