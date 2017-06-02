/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_ga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author haibkhn
 */
public final class Quanthe {
    private final ArrayList quanthe;
    public Quanthe(int ktqthe, boolean k) {
        quanthe = new ArrayList<>();
        if(k){
            for (int i = 0; i < ktqthe; i++){
                HanhTrinh t = new HanhTrinh();
                t.taoHanhtrinh();
                LuuHanhTrinh(i, t);
            }
        }
    }

    
    public void LuuHanhTrinh(int j, HanhTrinh ht){
        quanthe.add(j, ht);
    }
    public HanhTrinh getHanhTrinh(int Vitri){
        return (HanhTrinh) quanthe.get(Vitri);
    }
    public int ktQuanthe() {
        return quanthe.size();
    }
    // Hanh trinh tot nhat trong quan the
    
    public HanhTrinh getFitbest() {
        HanhTrinh max = (HanhTrinh) getHanhTrinh(0);
        for (int i = 1; i < ktQuanthe(); i++) {
            if (max.getFitness() <= getHanhTrinh(i).getFitness()) {
                max = getHanhTrinh(i);
            }
        }
        return max;
    }
    public void Sapxep(){
        Collections.sort(quanthe, new Comparator<HanhTrinh>(){

            @Override
            public int compare(HanhTrinh o1, HanhTrinh o2) {
                if(o1.getFitness() < o2.getFitness()){
                    return 1;
                }
                else if(o1.getFitness() == o2.getFitness()){
                    return 0;
                }
                else {
                    return -1;
                }
            }
        });
    }
}
