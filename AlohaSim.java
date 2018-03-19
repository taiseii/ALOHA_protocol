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
    ArrayList<Double> At = new ArrayList<>();
    ArrayList<Double> Nt = new ArrayList<>();
    ArrayList<Double> Nt_t = new ArrayList<>();
    ArrayList<String> Zt = new ArrayList<>();
    
    
    
    Random rng = new Random();
    Distribution aYt,bNt;
    
            
     
    double f;
    int T;
    int run;
    double v;
   
    
     void init(){
        f = 0.5;
        T = 20;
        run = 1000;
        Yt.clear();
        //Yt.add(0.0);
        //Yt.set(0,0.0);
        v = 0.4;
        aYt = new PoissonDistribution(v, rng);
        
        simulation();
        
        
    }
    
    AlohaSim(){
        
    }
    
    void simulation() {
        for (int i = 0; i != T; i++) {
            
            
            Yt.add(aYt.nextRandom());
            
            
           
            bNt = new BinomialDistribution(Nt.size(),f,rng);
            At.add( Yt.get(i) + bNt.nextRandom()  ) ;
            
            
            if( At.get(i) == 1 && Yt.get(i) < 1.0  && Nt.size() != 0){
                
                Nt.remove(Nt.size()-1);
                Zt.add("1");
                
             
            } else if (At.get(i) == 1 && Yt.get(i)==1){
                Zt.add("1.0");
            }
            else if( At.get(i) == 0){
                Zt.add("0.0");
            } else {
                Nt.add(Yt.get(i));
                Zt.add("*.:");
            }
            
            
            Nt_t.add( Nt.size()*1.0 );
            
            
            
            
        }
        
        System.out.println("At: "+Arrays.toString(Yt.toArray())+ ":"+At.size());
        System.out.println("Yt: "+Arrays.toString(Yt.toArray())+ ":"+Yt.size());
        System.out.println("Zt: "+Arrays.toString(Zt.toArray())+ ":"+Zt.size());
        System.out.println("Nt_t: "+Arrays.toString(Nt_t.toArray())+ ":"+Nt_t.size());
        System.out.println("Nt: "+Arrays.toString(Nt.toArray())+ ":"+Nt.size());
        
        
    }
    
    
    
    
    
}
