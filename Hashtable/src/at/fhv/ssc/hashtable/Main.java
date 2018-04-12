package at.fhv.ssc.hashtable;

import static at.fhv.ssc.hashtable.Strategy.LINEAR;
import static at.fhv.ssc.hashtable.Strategy.DOUBLE;
import static at.fhv.ssc.hashtable.Strategy.QUADRATIC;

public class Main {

    public static void main(String [] args){

        Hashtable table = new Hashtable(5, LINEAR);
        table.put(1, 'A');
        table.put(6, 'B');
        table.put(6, 'C');
        System.out.println(table.get(1));
        System.out.println(table.get(6));
        System.out.println(table.get(3));


    }

}
