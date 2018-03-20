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
public class AlohaSim2 {

    protected double[] Yt, At, Nt, Nt_t, Zt;
    //int [] Nt;
    Random rng = new Random();
    Distribution aYt, bNt;
    
    double sT=0;
    double sT2=0;
    
    double f;
    int T;
    int run;
    double v;

    void init(double f,double v,int T) {
        
        
        this.f = f;
        this.T = T;
        this.v = v;
        
        //Yt.add(0.0);
        //Yt.set(0,0.0);
       
        aYt = new PoissonDistribution(v, rng);

        simulation();

    }
    
    public double getResult(){
        
        return sT;
    }
    

    void simulation() {
        this.Yt = new double[T];
        this.At = new double[T];
        this.Nt = new double[T];
        this.Zt = new double[T];
        for (int i = 0; i != T; i++) {
            Yt[i] = 0;
            At[i] = 0;
            Nt[i] = 0;
            Zt[i] = 0;
        }
        for (int i = 0; i != T; i++) {
            if (i == 0) {
                Nt[i] = 0;
            } else {
                Nt[i] = Nt[i - 1];
                Yt[i] = aYt.nextRandom();
                Yt[i] = Math.round(Yt[i]);
                int Ntint = (int) Nt[i];
                bNt = new BinomialDistribution(Ntint, f, rng);
                At[i] = Yt[i] + bNt.nextRandom();

                if (At[i] == 1 && Yt[i] < 1.0 && Nt[i] != 0) {
                    Nt[i] = Nt[i] - 1;
                    Zt[i] = 1;
                } else if (At[i] == 1 && Yt[i] == 1) {
                    Zt[i] = 1;
                } else if (At[i] == 0) {
                    Zt[i] = 0;
                } else {
                    Nt[i] = Nt[i] + Yt[i];
                    Zt[i] = 3;
                }
            }
        }
        /*
        System.out.println("Nr.Yt:" + Arrays.toString(Yt));
        System.out.println("At:   " + Arrays.toString(At));
        System.out.println("Zt:   " + Arrays.toString(Zt));
        //System.out.println("Nt_t: "+Arrays.toString(Nt_t));
        System.out.println("Nt:   " + Arrays.toString(Nt));
*/
        
        
        
        
        sT = sT + Nt[Nt.length-1 ];
        
        
        
    }
    
    public double reuslts(int rn){
        //System.out.println("sT:"+sT + " E:"+(sT/rn));
        
        return sT/rn;
    }

}
