/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import statistics.Distribution;
import statistics.UniformDistribution;
import statistics.BernoulliDistribution;
/**
 *
 * @author jh0iku
 */
public class Base {
    
    // this represent bases in cartesian coordinate system between 0 n 1
    ArrayList<Double> Dist = new ArrayList<>();
    ArrayList<Double> Bases = new ArrayList<>();
    Set<Double> UniqDist = new HashSet<>();
    ArrayList<Double> goodBase = new ArrayList<>();

    Random rng = new Random();
    Distribution uniF = new UniformDistribution(0,1,rng);
    Distribution bern = new BernoulliDistribution(0.2, rng);

    void createBase(int nb){
        for(int i=0; i< nb*2 ; i++){
            Bases.add(uniF.nextRandom());
        }
    }

    void checkLBase(){
       // System.out.println( Arrays.toString(Bases.toArray()) );
        //System.out.println( Arrays.toString(Dist.toArray()) );
    }

    void getPair(ArrayList<Double> arrX){
        for(int i=1; i<arrX.size(); i+=2){
            //System.out.println("X: "+arrX.get(i-1));
           // System.out.println("Y: "+arrX.get(i));
        }
    }

    void getRadious(ArrayList<Double> arrX){
        for(int i=1; i<arrX.size(); i+=2){
            double x = arrX.get(i-1);
            double y = arrX.get(i);
            for(int j=1; j<arrX.size(); j+=2){
                double xx = arrX.get(j-1);
                double yy = arrX.get(j);
                //System.out.println( Math.sqrt( Math.pow(x-xx, 2) + Math.pow(y-yy,2) ) );
                //Dist.add( Math.sqrt( Math.pow(x-xx, 2) + Math.pow(y-yy,2) ) );
                UniqDist.add( Math.sqrt( Math.pow(x-xx, 2) + Math.pow(y-yy,2) ) );
            }
        }
    }

    void outRadious(double R){
        for( Double xy : UniqDist){
            if(xy > R){
                goodBase.add(xy);
            }
        }

        //System.out.println( Arrays.toString(goodBase.toArray()) ) ;
    }

    void dothing( double R ){
        getPair(Bases);
        getRadious(Bases);
        //UniqDist.forEach(System.out::println);
        outRadious( R );
    }


    double getYt(){
        createBase(5);
        dothing(0.55);
        double Yt = 0;
        for (int j=0; j<goodBase.size(); j++){
            Yt=Yt+bern.nextRandom();
        }
        return Yt;
    }

    public static void main(String[] args){
        /*
        double radi = 0.55;
        newBase.createBase(5);
        newBase.dothing(radi);
        newBase.simulation();
        */
        Base newBase = new Base();
       
        System.out.println(  newBase.getYt()   );
      

        
    }
}
