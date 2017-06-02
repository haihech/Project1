/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_ga;

import java.util.Vector;

/**
 *
 * @author haibkhn
 */
public class GA {
    
    private static final double tiledotbien = 0;
    
    public static Quanthe Tienhoa(Quanthe qt){
        Quanthe newQT = new Quanthe(qt.ktQuanthe(),false);
        Quanthe QT = new Quanthe(2*qt.ktQuanthe(),false);

        for(int k = 0 ; k < qt.ktQuanthe();k++ )
        {
            QT.LuuHanhTrinh(k, qt.getHanhTrinh(k));
        }
        for(int i = qt.ktQuanthe(); i < 2*qt.ktQuanthe(); i++){
            HanhTrinh cha1 = Select_Roulette(qt);
            HanhTrinh cha2 = Select_Roulette(qt);
            HanhTrinh con = LaighepOX2(cha1,cha2);
            QT.LuuHanhTrinh(i, con);
        }
        
        for(int i = qt.ktQuanthe();i < 2*qt.ktQuanthe();i++)
        {
            _2opt(QT.getHanhTrinh(i));
        }
        
        QT.Sapxep();
        for(int i = 0 ;i < qt.ktQuanthe();i++)
        {
            newQT.LuuHanhTrinh(i, QT.getHanhTrinh(i));
        }
        
       
        return newQT;
      
        
    }
    public static HanhTrinh Select_Roulette(Quanthe qt)
    {
        double sum_fitness = 0;
        for(int i = 0;i < qt.ktQuanthe();i++){
            sum_fitness += qt.getHanhTrinh(i).getFitness();
        }
        double[] f = new double[qt.ktQuanthe()];
        for(int i = 0;i < qt.ktQuanthe();i++){
            f[i] = qt.getHanhTrinh(i).getFitness()/sum_fitness;
        }
        double r = Math.random();
        int k;
        double g = 0;
        for(k = 0;k < f.length;k++)
        {
            g += f[k];
            if(g >= r) break;
        }
        return qt.getHanhTrinh(k);
    }
    
    public static void _2opt(HanhTrinh ht){
        for(int i = 0; i < ht.ktHanhtrinh()-3;i++){
            for(int j = i+2;j < ht.ktHanhtrinh()-1;j++){
                if( (ht.getThanhpho(i).Khoangcach(ht.getThanhpho(i+1)) + ht.getThanhpho(j).Khoangcach(ht.getThanhpho(j+1))) > (ht.getThanhpho(i).Khoangcach(ht.getThanhpho(j)) + ht.getThanhpho(i+1).Khoangcach(ht.getThanhpho(j+1))))
                {
                    int t=i+1, s=j;
                    while(t < s){
                        Thanhpho tmp = ht.getThanhpho(t);
                        Thanhpho tmp1 = ht.getThanhpho(s);
                        ht.setThanhpho(t, tmp1);
                        ht.setThanhpho(s, tmp);
                        t++;
                        s--;
                    }
                            
                }
            }
        }
        
    }
            
    //Lai ghep kieu OX2
    
    public static HanhTrinh LaighepOX2(HanhTrinh h1, HanhTrinh h2)
    {
        HanhTrinh con = new HanhTrinh();
        
        int start = (int) (Math.random()*h1.ktHanhtrinh());
        int end = (int) (Math.random()*h1.ktHanhtrinh());
        if(start > end){
            int ad = start;
            start =end;
            end = ad;
        }
        
        for(int i = 0; i < con.ktHanhtrinh(); i++){
            if(start < end && i > start && i < end)
                con.setThanhpho(i, h1.getThanhpho(i));
        }
        
        for (int i = 0; i < h2.ktHanhtrinh(); i++)
        {
            if(!con.kiemtra(h2.getThanhpho(i))){
                for(int k = 0; k < con.ktHanhtrinh(); k++){
                    if(con.getThanhpho(k) == null){
                        con.setThanhpho(k, h2.getThanhpho(i));
                        break;
                    }
                }
            }
        }
        
        return con;
    }
    /*public static HanhTrinh[] LaighepOX2(HanhTrinh h1, HanhTrinh h2)
    {
        HanhTrinh con1 = new HanhTrinh();
        HanhTrinh con2 = new HanhTrinh();
        HanhTrinh[] con = new HanhTrinh[2];
        

        int start = (int) (Math.random()*h1.ktHanhtrinh());
        int end = (int) (Math.random()*h1.ktHanhtrinh());
        if(start > end){
            int ad = start;
            start =end;
            end = ad;
        }
        for(int i = 0; i < con1.ktHanhtrinh(); i++){
            if(start < end && i > start && i < end)
                con1.setThanhpho(i, h1.getThanhpho(i));
        }
        
        for (int i = 0; i < h2.ktHanhtrinh(); i++)
        {
            if(!con1.kiemtra(h2.getThanhpho(i))){
                for(int k = 0; k < con1.ktHanhtrinh(); k++){
                    if(con1.getThanhpho(k) == null){
                        con1.setThanhpho(k, h2.getThanhpho(i));
                        break;
                    }
                }
            }
        }
        
        for(int i = 0; i < con2.ktHanhtrinh(); i++){
            if(start < end && i > start && i < end)
                con2.setThanhpho(i, h2.getThanhpho(i));
        }
            
            
        for (int i = 0; i < h1.ktHanhtrinh(); i++)
        {
            if(!con2.kiemtra(h1.getThanhpho(i))){
                for(int k = 0; k < con2.ktHanhtrinh(); k++){
                    if(con2.getThanhpho(k) == null){
                        con2.setThanhpho(k, h1.getThanhpho(i));
                        break;
                    }
                }
            }
        }
        
        con[0] = con1;
        con[1] = con2;
        return con;
    }*/
    //Lai ghep kieu OX1
    /*public static HanhTrinh[] LaighepOX1(HanhTrinh h1, HanhTrinh h2)
    {
        HanhTrinh con1 = new HanhTrinh();
        HanhTrinh x1 = new HanhTrinh();
        HanhTrinh con2 = new HanhTrinh();
        HanhTrinh x2 = new HanhTrinh();
        
        HanhTrinh[] con = new HanhTrinh[2];
        
        int start = (int) (Math.random()*h1.ktHanhtrinh());
        int end = (int) (Math.random()*h1.ktHanhtrinh());
        if( start > end)
        {
            int ad = start;
            start = end;
            end = ad;
        }
        
        for(int i = 0; i < con1.ktHanhtrinh(); i++){
            if(start < end && i > start && i < end)
                con1.setThanhpho(i, h1.getThanhpho(i));
            
        }
        int k = 0;
        for(int i = end; i < h2.ktHanhtrinh(); i++){
            x1.setThanhpho(k, h2.getThanhpho(i));
            k++;
        }
        for(int i = 0; i < end ; i++){
            x1.setThanhpho(k, h2.getThanhpho(i));
            k++;
        }
        
        for (int i = 0; i < x1.ktHanhtrinh(); i++)
        {
            if(!con1.kiemtra(x1.getThanhpho(i))){
                for(int j = end; j < con1.ktHanhtrinh(); j++){
                    if(con1.getThanhpho(j) == null){
                        con1.setThanhpho(j, x1.getThanhpho(i));
                        break;
                    }
                }
            }
        }
        
        for (int i = 0; i < x1.ktHanhtrinh(); i++)
        {
            if(!con1.kiemtra(x1.getThanhpho(i))){
                for(int j = 0; j <= start; j++){
                    if(con1.getThanhpho(j) == null){
                        con1.setThanhpho(j, x1.getThanhpho(i));
                        break;
                    }
                }
            }
        }
        
        for(int i = 0; i < con2.ktHanhtrinh(); i++){
            if(start < end && i > start && i < end)
                con2.setThanhpho(i, h2.getThanhpho(i));
            
        }
        int h = 0;
        for(int i = end; i < h1.ktHanhtrinh(); i++){
            x2.setThanhpho(h, h1.getThanhpho(i));
            h++;
        }
        for(int i = 0; i < end ; i++){
            x2.setThanhpho(h, h1.getThanhpho(i));
            h++;
        }
        
        for (int i = 0; i < x2.ktHanhtrinh(); i++)
        {
            if(!con2.kiemtra(x2.getThanhpho(i))){
                for(int j = end; j < x2.ktHanhtrinh(); j++){
                    if(con2.getThanhpho(j) == null){
                        con2.setThanhpho(j, x2.getThanhpho(i));
                        break;
                    }
                }
            }
        }
        
        for (int i = 0; i < x2.ktHanhtrinh(); i++)
        {
            if(!con2.kiemtra(x1.getThanhpho(i))){
                for(int j = 0; j <= start; j++){
                    if(con2.getThanhpho(j) == null){
                        con2.setThanhpho(j, x1.getThanhpho(i));
                        break;
                    }
                }
            }
        }
        con[0] = con1;
        con[1] = con2;
        return con;
    }*/
    
    // Dot bien thay doi ngau nhien vi tri 2 thanh pho

    /*public static void Dotbien(HanhTrinh ht) {
        for(int j = 0; j < ht.ktHanhtrinh(); j++){
            if(Math.random() <= tiledotbien){
                int k = (int) (Math.random()*ht.ktHanhtrinh());
                if(j!=k)
                {
                    Thanhpho c1 = ht.getThanhpho(j);
                    Thanhpho c2 = ht.getThanhpho(k);
                    ht.setThanhpho(k, c1);
                    ht.setThanhpho(j, c2);
                }
            }
        }
    }
    */
}
