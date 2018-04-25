package at.fhv.ssc.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Die Klasse EvenIterator implementiert das Interface Iterator für Integer.
 * Sie soll nur gerade Integer-Werte für LinkedLists und ArrayLists ausgeben.
 * Als Attribute besitzt es einen nextValue und einen Iterator.
 * Im Konstruktor wird ein Iterable übergeben, welches dann iteriert wird.
 */
public class EvenIterator implements Iterator<Integer> {

    private Integer _nextValue;
    private Iterator<Integer> _iterator;

    public EvenIterator(Iterable<Integer> iterable) {
        _iterator = iterable.iterator();
        setNextValue();
    }

    /**
     * Die Methode setNextValue sucht zuerst den ersten und dann jeweils den
     * nächsten geraden Interger-Wert für die Even Iteration.
     */

    private void setNextValue() {
        Integer value = null;
        boolean evenValueFound = false;
        while ( (_iterator.hasNext()) && (!evenValueFound) ) {
            Integer temp = _iterator.next();
            if (temp % 2 == 0) {
                value = temp;
                evenValueFound = true;
            }
        }
        _nextValue = value;
    }

    /**
     * Override von hasNext, gibt aus ob noch ein weiterer Wert in der Liste ist.
     */

    @Override
    public boolean hasNext() {
        return !(_nextValue == null);
    }

    /**
     * Override von next, gibt den nächsten Wert aus (von setNextValue)
     * oder gibt eine NoSuchElementException.
     */

    @Override
    public Integer next() throws NoSuchElementException {
        if (_nextValue == null) {
            throw new NoSuchElementException();
        } else {
            Integer value = _nextValue;
            setNextValue();
            return value;

        }
    }

}
