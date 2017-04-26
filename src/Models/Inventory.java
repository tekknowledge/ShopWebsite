/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.util.ArrayList;
import Utility.Iterator;
/**
 *
 * @author DERRICK
 */
public class Inventory {
    private ArrayList<Product> products;
    
    private class CategoryIterator implements Iterator {
        private ProductCategory category;
        private int _currentIndex = 0;
        
        public CategoryIterator(ProductCategory category){
            this.category = category;
        }
        
        @Override
        public boolean hasNext() {
            int tmpIndex = _currentIndex;
            while (tmpIndex < products.size() && !products.get(tmpIndex).getCategory().equals(category)) {
                tmpIndex++;
            }
            _currentIndex = tmpIndex;
            return tmpIndex != products.size();
        }

        @Override
        public Object next() {
            Product returnValue = null;
            if (hasNext()){
                returnValue = products.get(_currentIndex);
                _currentIndex++;
            }
            return returnValue;
        }
        
    }
    
    private class InventoryIterator implements Iterator {

        private int _currentIndex = 0;
        
        @Override
        public boolean hasNext() {
            int tmpIndex = _currentIndex;
            return tmpIndex <= products.size() - 1;
        }

        @Override
        public Object next() {
            Product returnValue = null;
            if (hasNext()){
                returnValue = products.get(_currentIndex);
            _currentIndex++;
     }
     return returnValue;
        }
        
    }
    public Inventory(ArrayList<Product> products){
        this.products = products;
    }
    
    public Iterator getAllItemsIterator() {
        return new 
    }
    public Iterator getElectronicsIterator(){
        return new CategoryIterator(ProductCategory.ELECTRONICS);
    }
    
    public Iterator getApparelIterator(){
        return new CategoryIterator(ProductCategory.APPAREL);
    }
    
    public Iterator getSportingGoodsIterator(){
        return new CategoryIterator(ProductCategory.SPORTING_GOODS);
    }
    
    public Iterator getBooksIterator(){
        return new CategoryIterator(ProductCategory.BOOKS);
    }
}
