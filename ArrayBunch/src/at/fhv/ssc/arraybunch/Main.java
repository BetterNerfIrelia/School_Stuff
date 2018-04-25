package at.fhv.ssc.arraybunch;

/**
 * Created by sebastian on 01.09.2017.
 */
public class Main {

    public static void main(String [] args){


        String arrays[][] = {{"a", "b", "c"},{"d", "e", "f", "g", "h"},{"i",}};
        ArrayBunch bunch = new ArrayBunch(arrays);

        /**
        String s1 = bunch.get(0); //s1 == "a";
        String s2 = bunch.get(3); //s2 == "d";
        int size = bunch.size(); //size == 8;
         */

        System.out.println(bunch.get(8));

        System.out.println("bunch size: " + bunch.size());
        System.out.println("bunch quantity: " + bunch.getQuantity());

    }
}
