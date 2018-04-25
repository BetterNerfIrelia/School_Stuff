package at.fhv.ssc.boundqueue;
import java.util.Iterator;


/**
 * Created by sebastian on 25.08.2017.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        Boundqueue boundqueue = new Boundqueue(5);


        //System.out.println(boundqueue.GetStart());
        //System.out.println(boundqueue.GetEnd());
        //System.out.println(boundqueue.GetLength());

       // boundqueue.AddInt(1);
        boundqueue.AddInt(2);
        boundqueue.AddInt(3);
       // boundqueue.AddInt(4);

        System.out.println(boundqueue.getQuantity());

        Iterator it = boundqueue.iterator();
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.next());
    }

    }

