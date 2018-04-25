package at.fhv.ssc.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    /**
     * Eine neue Arraylist wird erstellt und mit Werten gefüllt,
     * danach wird sie einem EvenIterator übergeben.
     */

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator<Integer> eveniter = new EvenIterator(list);

        while(eveniter.hasNext()) {
            System.out.println(eveniter.next());
        }



    }

}
