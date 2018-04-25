package at.fhv.ssc.compromiser;

/**
 * Created by sebastian on 10.10.2017.
 */
public class Main {

    public static void main(String [] args){

    Compromiser comp = new Compromiser();
    System.out.println(comp.compromise("2222"));
    System.out.println(comp.decompromise("AA§3§BCC"));

    }
}
