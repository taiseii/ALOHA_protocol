/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import statistics.Distribution;
import statistics.PoissonDistribution;
import statistics.BinomialDistribution;
/**
 *
 * @author jh0iku
 */
public class AlohaSim {
    
    ArrayList<Double> Yt = new ArrayList<>();
    ArrayList<Integer> At = new ArrayList<>();
    
    Random rng = new Random();
     
    double f;
    int T;
    int run;
    double v;
    
     void init(){
        f = 0.5;
        T = 20;
        run = 1000;
        Yt.clear();
        Yt.add(0.0);
        Yt.set(0,0.0);
        v = 0.4;
        simulation();
        
    }
    
    AlohaSim(){
        
    }
    
     
    void simulation(){
        for(int i=1; i != T; i++){
          Distribution aYt = new PoissonDistribution(v,rng);
          Yt.add(aYt.nextRandom());
            
            
        }
        
        
    }
    
    
    
    
    
}
