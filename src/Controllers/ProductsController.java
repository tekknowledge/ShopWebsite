/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

/**
 *
 * @author DERRICK
 */
public class ProductsController extends Controller {
    public ProductsController(boolean isPrimeMember){
        String msg = isPrimeMember ? "Prime Member" : "Non-Prime Member";
        System.out.println(msg);
    }
}
