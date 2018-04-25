import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sebastian on 29.03.2017.
 */
public class Product {

    ArrayList<String> list = new ArrayList<String>();
    String xy = "oho";
    Object xobj = new Object();
    HashMap<String, String> map = new HashMap<>();

    /**
     * Constructor
     *
     * @param list
     */
    public Product(ArrayList<String> list) {
        this.list = list;
    }

    public Product() {
    }


    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {


        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
            sb.append(" ||| ");
        }

        return "Product{" +
                "list=" + sb.toString() +
                ", xy='" + xy + '\'' +
                ", xobj=" + xobj +
                ", map=" + map +
                '}';
    }
}
