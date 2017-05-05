/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import Utility.Iterator;
import java.util.ArrayList;

/**
 *
 * @author DERRICK
 */
class ModelIterator<T> implements Iterator<T> {
        private int _currentIndex = 0;
        private ArrayList<T> items;
        
        public ModelIterator(ArrayList<T> items){
            this.items = items;
        }
        
        @Override
        public boolean hasNext() {
            int tmpIndex = _currentIndex;
            return tmpIndex <= items.size() - 1;
        }

        @Override
        public T next() {
            T returnValue = null;
            if (hasNext()){
                returnValue = items.get(_currentIndex);
                _currentIndex++;
            }
            return returnValue;
        }
        
}
