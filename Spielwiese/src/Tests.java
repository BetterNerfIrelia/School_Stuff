import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by sebastian on 29.03.2017.
 */
public class Tests {

    @Test public void foreachVariants() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Product> _LoadedProducts = new ArrayList<>();
//Java 8 - Lambda expressions
        _LoadedProducts.forEach(p -> {
            sb.append(p.toString());
            sb.append(" ###");
        });

        //Java 5  - Classic Foreach
        for(Product p : _LoadedProducts) {
            sb.append(p.toString());
            sb.append(" ### ");
        }

        //Cstyle
        for(int i = 0; i< _LoadedProducts.size(); i++) {
            sb.append(_LoadedProducts.get(i).toString());
            sb.append(" ###");
        }

    }

    @Test
    public void someTest() {

        ArrayList<String> arlist = new ArrayList<>();
        String a = "bla";
        String b = "blabla";
        String c = "asdf";

        arlist.add(a);
        arlist.add(b);
        arlist.add(c);

        Product p = new Product(arlist);

        System.out.println(p.toString());

        Object obj = new Object();


        System.out.println(new Product().getClass().toString());

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(333);

        Object[] objarr= new Object[100];
        objarr[0] = new String("a");
        objarr[1] = list;//new ArrayList<Integer>(); // nullpointer exception
        objarr[2] = 3;
        for(int i = 3; i< 100; i++) {
            objarr[i] = "not Null :)";
        }


        try {
            for (int i = 0; i < objarr.length; i++) {
                System.out.println(objarr[i].toString());
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("wir sind im Catch-block");
        }

        System.out.println("ENDE");
    }

}




