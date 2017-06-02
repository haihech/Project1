/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_ga;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author haibkhn
 */
public class HanhTrinh {
    private ArrayList hanhtrinh = new ArrayList<>();
    private double fitness = 0; //ham danh gia
    private int d = 0; //khoang cach(chi phi)
    
    public HanhTrinh(){
        for(int i=0;i<QuanlyHanhtrinh.ktThanhpho();i++)
            hanhtrinh.add(null);
    }
    
    public HanhTrinh(ArrayList hanhtrinh){
        this.hanhtrinh=hanhtrinh;
    }
    
    public void setThanhpho(int vitri, Thanhpho c){
        hanhtrinh.set(vitri, c);
        fitness=0;
        d=0;
    }
    //Tao 1 hanh trinh ngau nhien
    public void taoHanhtrinh(){
        for(int i = 0; i < QuanlyHanhtrinh.ktThanhpho(); i++)
            setThanhpho(i,QuanlyHanhtrinh.getThanhpho(i));
        //Sap xep hanh trinh 1 cach ngau nhien
        Collections.shuffle(hanhtrinh);
    }
    public Thanhpho getThanhpho(int Vitri){
        return (Thanhpho) hanhtrinh.get(Vitri);
    }
    
    public double getFitness(){
        if(fitness == 0)
            fitness = 1/(double)Chiphi();
        return fitness;
    }
    //chi phi hanh trinh
    public int Chiphi(){
        double chiphi = 0;
        for(int j = 0; j < ktHanhtrinh(); j++){
            Thanhpho c1 = getThanhpho(j);
            Thanhpho c2;
            if(j+1 < ktHanhtrinh())
                c2 = getThanhpho(j+1);
            else c2 = getThanhpho(0);
            chiphi = chiphi + c1.Khoangcach(c2);
        }
            d = (int) chiphi;
        return d;
    }
    public int ktHanhtrinh(){
        return hanhtrinh.size();
    }
    // Kiem tra xem hanh trinh co chua 1 thanh pho nao do
    public boolean kiemtra(Thanhpho city){
        return hanhtrinh.contains(city);
    }
    
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < ktHanhtrinh(); i++) {
            s += getThanhpho(i)+",";
        }
        return s;
    }
    /*
    public String in(){
        String s = "";
        for(int i = 0; i < ktHanhtrinh(); i++){
            s += getThanhpho(i).z+" ";
        }
        return s;
    }*/
}
