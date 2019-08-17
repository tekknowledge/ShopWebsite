/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

/**
 *
 * @author DERRICK
 */
public abstract class CommandInvokerDataStrategy<T> implements IStrategy<T> {
    @Override
    public abstract T Implement();
    public abstract void addData(Object o);
}
