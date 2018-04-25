package at.fhv.ssc.comparator;
import java.util.Comparator;


public class Person {

    /**
     * Hier wurden die beiden Personen-Namen-Comparatoren implementiert.
     * Einmal Ascending und einmal Descending.
     */

    public static class NameComparatorASC implements Comparator<Person> {
        @Override
        public int compare(Person t1, Person t2) {
            return t1._name.compareTo(t2._name);
        }
    }

    public static class NameComparatorDESC implements Comparator<Person> {
        @Override
        public int compare(Person t1, Person t2) {
            return t2._name.compareTo(t1._name);
        }
    }

    private String _name;

    public Person(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }


    @Override
    public String toString() {
        return _name;
    }

}
