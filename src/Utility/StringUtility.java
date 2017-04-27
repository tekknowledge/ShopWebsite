/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

/**
 *
 * @author DERRICK
 */
public class StringUtility {
    public static String AddPadding(String str, int length){
        return String.format("%1$"+ length + "s", str);
    }
    
    public static int ConvertToInt(String str){
        int returnValue = 0;
        try {
            returnValue = Integer.parseInt(str);
        } catch (Exception ex) {
            // squash
        }
        return returnValue;
    }
}
