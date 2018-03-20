/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jh0iku
 */

public class AlohaMain {
 
    
    
    public static void main (String[] args){
        AlohaSim2 als = new AlohaSim2();
        int run;
        run = 10000;
        //double Exp[][];
        double [][]Exp ;
        
        
        for(int i = 0 ; i < 10 ; i++){
            for(int j = 0 ; j<50; j++){
                Exp[i][j] = 0;
            }
        }
        
        for (double f = 0.0; f < 1.0; f += 0.1) {
        for (double v = 0.0; f < 5.0; v += 0.1) {
            Exp[(int)f*10][(int)v*10]=0;
        }
        }

        
        for (double f = 0.0; f < 1.0; f += 0.1) {
        for (double v = 0.0; f < 5.0; v += 0.1) {

            for (int i = 0; i < run; i++) {
                // f,v,T
               als.init(f, v, 100);
            }
         
         Exp[(int)f*10][(int)v*10]=als.reuslts(run);
        }
        }
    }
}

