/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_ga;

import java.util.ArrayList;

/**
 *
 * @author haibkhn
 */
class QuanlyHanhtrinh{
    private static ArrayList htrinh = new ArrayList<Thanhpho>();
    
    public static void addThanhpho(Thanhpho tp){
        htrinh.add(tp);
    }
    
    public static Thanhpho getThanhpho(int i){
        return (Thanhpho) htrinh.get(i);
    }
    public static int ktThanhpho(){
        return htrinh.size();
    }
}
