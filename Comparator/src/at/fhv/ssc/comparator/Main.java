package at.fhv.ssc.comparator;
import java.util.Comparator;

/**
 * Created by sebastian on 10.05.2017.
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Es werden zwei neue Personen erstellt.
         * Danach wird einer der beiden NameComparatoren ausgewählt.
         * Anschliessend kommt dies in eine Priority-Queue.
         */

        Person anton = new Person("Anton");
        Person beate = new Person("Beate");

        Comparator<Person> compi = new Person.NameComparatorASC();
        PriorityQ<Person> queuei = new PriorityQ<Person>(compi);
        
        queuei.enqueue(anton);
        queuei.enqueue(beate);
        System.out.println(queuei.dequeue());


    }

    }

