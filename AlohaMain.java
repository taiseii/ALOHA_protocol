/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author jh0iku
 */
public class AlohaMain {

    public static void main(String[] args) {
        AlohaSim2 als = new AlohaSim2();
        int run;
        run = 10;
        //double Exp[][];
        double[][] Exp = new double [10][10];
        
       // Exp = {{{{100,200,300}, {120,200} ,{200,250}}};

        /*
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 50; j++) {
                Exp[i][j] = 0;
            }
        }

        for (double f = 0.0; f < 1.0; f += 0.1) {
            for (double v = 0.0; f < 5.0; v += 0.1) {
                Exp[(int) f * 10][(int) v * 10] = 0;
            }
        }
        */
        for (int f=0; f<5; f++) {
            for (int v=0; v<5; v++) {

                for (int i = 0; i < run; i++) {
                    // f,v,T
                    double ff=((double)(f))/10;
                    double vv=((double)(v))/10;
                    als.init(ff,vv, 100);
                }
                
                //System.out.println((int) f * 10 + "X" +(int) v * 10);
                

                //Exp[f][v] = als.reuslts(run);
            }
        }
        
       //System.out.println(Arrays.deepToString(Exp)); 
        
        
        
    }
}
