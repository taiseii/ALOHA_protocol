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
    Distribution aYt, bNt;

    double f;
    int T;
    int run;
    double v;
    double x;

    void init() {
        f = 0.5;
        T = 20;
        run = 1000;
        //Yt.clear();
        //Yt.add(0.0);
        //Yt.set(0,0.0);
        v = 0.4;
        aYt = new PoissonDistribution(v, rng);
        simulation();
    }

    public double sumIt(ArrayList<Double> x) {
        double sumNT = 0;
        for (Double d : x) {
            sumNT += d;
        }
        return sumNT;
    }

    void simulation() {
        for (int i = 0; i != T; i++) {

            //int state = 0;
            int pos = 0;
            Yt.add(aYt.nextRandom());

            if (!(Nt_t.isEmpty())) {
                pos = (int) Math.round(Nt_t.get(Nt_t.size() - 1));
            }
            bNt = new BinomialDistribution(pos, f, rng);

            At.add(Yt.get(i) + bNt.nextRandom());
            
            if (At.get(i) == 1) {
                if (Yt.get(i) == 1) {
                    //Do nothing Nt_t = 0 or previous
                    
                    x = ( i != 0 ) ? Nt_t.get(i-1) : 0.0 ; 
                    Nt_t.add(x);
                    
                } else {
                    //Remove one from the queue
                    x = ( i != 0 ) ? Nt_t.get(i-1)-1 : 0.0 ; 
                    Nt_t.add(x);
                }

            } else if (At.get(i) == 0) {
                //Do nothing Nt_t = 0 or previous 
                x = ( i != 0 ) ? Nt_t.get(i-1) : 0.0 ; 
                Nt_t.add(x);
            } else {
                //Add Yt.get(i) + Nt_t @(i-1)th or 0
                x = ( i != 0 ) ? Nt_t.get(i-1)+Yt.get(i) : 0.0 ; 
                Nt_t.add(x);
                
            }
            
            

            
        
        }

        System.out.println("At:  " + Arrays.toString(At.toArray()) + ":" + At.size());
        System.out.println("Yt:  " + Arrays.toString(Yt.toArray()) + ":" + Yt.size());
        System.out.println("Zt:  " + Arrays.toString(Zt.toArray()) + ":" + Zt.size());
        System.out.println("Nt_t:" + Arrays.toString(Nt_t.toArray()) + ":" + Nt_t.size());
        System.out.println("Nt:  " + Arrays.toString(Nt.toArray()) + ":" + Nt.size());

    }

}
