package at.fhv.ssc.comparator;

import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;

/**
 * Die Priorityqueue besteht hat als Attribute eine (Linked)Liste und einen Comparator.
 *
 */
public class PriorityQ<T> {

    private List<T> _queue;
    private Comparator<T> _comparator;

    public PriorityQ(Comparator<T> comp) {
        _queue = new LinkedList<>();
        _comparator = comp;
    }

    /**
     * Die Methode enqueue fügt den queue einen Wert hinzu.
     */

    public void enqueue(T value) {
        _queue.add(value);
    }

    /**
     * Die Methode dequeue gibt das höchste Element aus.
     */

    public T dequeue() {
        T highestElement = _queue.get(0);
        for (T element : _queue) {
            if(_comparator.compare(highestElement, element) > 0) {
                highestElement = element;
            }
        }
        _queue.remove(highestElement);
        return highestElement;
    }

    public boolean isEmpty() {
        return _queue.isEmpty();
    }


}
