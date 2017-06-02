/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_ga;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haibkhn
 */
public class TSP_GA {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        int x,y,city;
        
        FileInputStream fis = null;
        BufferedReader reader = null;
 
        try {
            fis = new FileInputStream("E:/st70.tsp.txt");
            reader = new BufferedReader(new InputStreamReader(fis));

            String line = reader.readLine();
            while(line != null){
                if(file.isNumber(line)){
                    System.out.println(line);
                    String item[]  = line.split(" ");
                    //city = Integer.parseInt(item[0].toString());
                    x = Integer.parseInt(item[1].toString());
                    y = Integer.parseInt(item[2].toString());
                    Thanhpho c = new Thanhpho(x,y);
                    QuanlyHanhtrinh.addThanhpho(c);
                }
                line = reader.readLine();
            }
 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TSP_GA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TSP_GA.class.getName()).log(Level.SEVERE, null, ex);
 
        } finally {
            try {
                reader.close();
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(TSP_GA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Quanthe qt = new Quanthe(100, true);
        System.out.println("Chi phi hien tai :" + qt.getFitbest().Chiphi());
        // tien hoa qua 1000 the he
        for(int i=0; i < 100; i++){
            qt = GA.Tienhoa(qt);
            if((i>0) && (i % 10 == 0))
                System.out.println("Chi phi 10 lan lap thu " + (i/10) + ":" +qt.getHanhTrinh(0).Chiphi());
        }
        System.out.println("Chi phi cuoi cung :" + qt.getHanhTrinh(0).Chiphi());
        //System.out.println("Hanh trinh:");
        //System.out.println(qt.getHanhTrinh(0).in());
        System.out.println("Toa do hanh trinh:");
        System.out.println(qt.getHanhTrinh(0));
    }
    
}
