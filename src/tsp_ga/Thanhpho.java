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
public class Thanhpho {
    int x;
    int y;
    //int z;
    // Xay dung thanh pho ngau nhien
    public Thanhpho(){
        this.x = (int) (Math.random()*3000);
        this.y = (int) (Math.random()*3000);
        //this.z = (int) (Math.random()*3000);
    }
    
    public Thanhpho(int x, int y) {
        this.x = x;
        this.y = y;
        //this.z = z;
    }
    

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    /*public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }*/
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    @Override
    public String toString(){
        return getX()+","+getY();
    }
    // khoang cach den thanh pho c
    public double Khoangcach(Thanhpho c){
        double a = Math.abs(getX() - c.getX());
        double b = Math.abs(getY() - c.getY());
        double d = Math.sqrt(a*a + b*b);
        return d;
    }
}
