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
public class Main {

    public static void main(String[] args) {
        List<ArrayList<Double>> fv = new ArrayList<>();
        
        ArrayList<Double> af = new ArrayList<>();
        ArrayList<Double> av = new ArrayList<>();
        
        
        AlohaSim haw = new AlohaSim();
        
        
        
        int run = 1000;
        //init( f,T,v,run)
        
        
        
        for (double ff = 0.0; ff<1.0; ff+=0.1){
            for(double vv = 0.0; vv<10.0; vv+=0.1 ){
                
                for (int i = 0; i < run; i++) {
                    haw.init(ff, 20, vv,run);
                }
                //haw.q1();
                
            }
        }
        
        
    }

}
