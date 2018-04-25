package at.fhv.ssc.boundqueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by sebastian on 25.08.2017.
 */
    public class Boundqueue implements Iterable<Integer>{

    @Override
    public Iterator iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Integer> {

        private int _quantityIt;
        private int _startIt;

        public QueueIterator() {
            _quantityIt = _quantity;
            _startIt = _start;
        }

        @Override
        public boolean hasNext() {
            if (_quantityIt > 0) {
                return true;
            }
            else {return false;}
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                _quantityIt--;
                _startIt++;
                if (_startIt == _length) {
                    _startIt = 1;
                }
                return _queue[(_startIt - 1)];
            }
        }

    }

    private int _start;
    private int _end;
    private int _length;
    private int _quantity;
    private int[] _queue;

    public Boundqueue(int length) {
        _length = length;

        int[] queue = new int[_length];
        _queue = queue;
    }

    public int getStart() {
        return _start;
    }

    public int getEnd() {
        return _end;
    }

    public int getLength() {
        return _length;
    }

    public int getQuantity() {
        return _quantity;
    }

    public void AddInt(int zahl) throws Exception {

        if(_end == (_length)){
            _end = 0;
        }
        if (isEmpty(_end) == false) {
                throw new Exception("Queue is full");
        }
        _queue[_end] = zahl;
        _end++;
        _quantity++;
    }

    public void DeleteInt() throws Exception {

        if (isEmpty() == true) {
            throw new Exception("Queue is empty");
        }

        if(_start == (_length)){
            _start = 0;
            System.out.println("Deleted Item: " + _queue[_start]);
            _queue[_start] = 0;
            _quantity--;

        }
        else {
            System.out.println("Deleted Item: " + _queue[_start]);
            _queue[_start] = 0;
            _start++;
            _quantity--;
        }
    }

    public void printQueue() throws Exception {
        if (isEmpty() == true) {
            throw new Exception("Queue is empty");
        }
        for(int i =0; i < _quantity; i++) {
            System.out.println(_queue[i]);
        }
    }

    public void setQueue(int[] queue) {
        _queue = queue;
    }

    public boolean isEmpty() {
        if (_quantity == 0) {
            return true;
        }
        else {return false;}
    }

    public boolean isEmpty(int index) {
        if (_queue[index] == 0) {
            return true;
        }
        else{return false;}

    }



}

