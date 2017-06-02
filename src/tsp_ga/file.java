/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_ga;

/**
 *
 * @author haibkhn
 */
public class file {
    public static boolean isNumber(String str)
    {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                return false;
            }
            if (i + 1 == str.length()) {
                return true;
            }
        } 
        return true;
    }  
}
