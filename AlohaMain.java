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
        AlohaSim aloha = new AlohaSim();
        int run;
        run = 10;
        
        aloha.init(0.2, 10, 0.6, run);

        double[][] Exp = new double [10][10];
        
      
        int counter =0;
        for (int f=0; f<5; f++) {
            for (int v=0; v<5; v++) {

                for (int i = 0; i < run; i++) {
                    // f,v,T
                    System.out.println(counter);
                    counter ++;
                    
                }
                
                //System.out.println((int) f * 10 + "X" +(int) v * 10);
                

                //Exp[f][v] = als.reuslts(run);
            }
        }
        
       //System.out.println(Arrays.deepToString(Exp)); 
        
        
        
    }
}
