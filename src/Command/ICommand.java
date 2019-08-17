/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

/**
 *
 * @author DERRICK
 * @param <T>
 */
public interface ICommand<T> {
    public T execute();
}
