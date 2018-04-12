package at.fhv.ssc.hashtable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hashtable<K, V> implements Map<K, V> {


    private class MapEntry<K, V> implements Map.Entry<K, V> {

        private V _value;
        private K _key;
        private boolean _valid;

        public MapEntry(V value, K key, boolean valid) {

            _value = value;
            _key = key;
            _valid = valid;
        }


        public MapEntry(V value, K key) {

            _value = value;
            _key = key;
            _valid = true;
        }

        /**
         * returns the key of this entry.
         */
        @Override
        public K getKey() {
            return _key;
        }

        /**
         * returns the value of this entry.
         */
        @Override
        public V getValue() {
            return _value;
        }

        /**
         * sets the value of this entry to this value.
         */
        @Override
        public V setValue(V value) {
            V temp = _value;
            _value = value;
            return temp;
        }

        /**
         * sets the key of this entry to this key.
         */
        public void setKey(K key) {
            _key = key;
        }

        /**
         * returns true if this entry is valid.
         */
        public boolean isValid() {
            return _valid;
        }

        /**
         * sets the bool valid for this entry.
         */
        public void setValid(boolean valid) {
            _valid = valid;
        }
    }


    private MapEntry[] _array;
    private int _length;
    private int _entryCounter;
    private Strategy _strategy;

    public Hashtable(int length, Strategy strategy) {

        _length = length;
        _strategy = strategy;
        _array = new MapEntry[_length];
        _entryCounter = 0;

    }

    /**
     * returns the number of k-v mappings.
     */
    @Override
    public int size() {
        return _entryCounter;
    }

    /**
     * returns true if the map contains no k-v mappings.
     */
    @Override
    public boolean isEmpty() { //
        if (_entryCounter == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * returns true if the map contains a mapping for this key.
     */
    @Override
    public boolean containsKey(Object key) {

        int hashkey = key.hashCode() % _length;
        int firsthashkey = hashkey;


        int i = 0;
        while (i < _length) {

            if (_array[hashkey] == null) {
                return false;
            }

            if (_array[hashkey].isValid() && _array[hashkey].getKey() == key) { //equals
                return true;
            } else {
                i++;
                hashkey = nextHash(firsthashkey, i);
            }
        }
        return false;
    }

    /**
     * returns true if the map contains one or more keys for this value.
     */
    @Override
    public boolean containsValue(Object value) {

        int i = 0;
        while (i < _length) {

            if (_array[i] == null) {
                i++;
            } else if (_array[i].isValid() && _array[i].getValue() == value) {
                return true;
            } else {
                i++;
            }
        }
        return false;
    }

    /**
     * returns the value of this key, or null if the map doesnt contains a mapping for this key.
     */
    @Override
    public V get(Object key) {

        int hashkey = key.hashCode() % _length;
        int firsthashkey = hashkey;

        int i = 0;
        while (i < _length) {

            if (_array[hashkey] == null) {
                return null;
            }

            if (_array[hashkey].isValid() && _array[hashkey].getKey() == key) {
                return (V) _array[hashkey].getValue();
            } else {
                i++;
                hashkey = nextHash(firsthashkey, i);
            }
        }
        return null;
    }

    /**
     * decides, which strategy to use, due to the strategy-ENUM.
     */
    public int nextHash(int firsthashkey, int i) {
        if (_strategy == Strategy.LINEAR) {
            return firsthashkey + i;
        } else if (_strategy == Strategy.QUADRATIC) {
            return firsthashkey + i * i;
        } else {
            return firsthashkey + i * (firsthashkey % 3 + 1);
        }
    }

    /**
     * rehashes all mappings (if the map gets too big)
     */
    public void reHash() {


        MapEntry[] temp = new MapEntry[_length];
        Set test = entrySet();
        _array = temp;

        for (Object o : test) {
            Entry<K, V> e = (Entry<K, V>) o;
            put(e.getKey(), e.getValue());
        }
    }


    /**
     * associates this value with this key in the map.
     */
    @Override
    public V put(K key, V value) {

        if (_entryCounter >= _length * 0.75f) {
            _length = _length * 2;
            reHash();
        }

        int hashkey = key.hashCode() % _length;
        int firsthashkey = hashkey;

        int i = 0;

        while (i < _length) {

            if (_array[hashkey] == null) {
                _array[hashkey] = new MapEntry(value, key);
                return null;
            } else {

                if (!_array[hashkey].isValid()) {
                    _array[hashkey] = new MapEntry(value, key);
                    return null;
                } else {

                    if (_array[hashkey].getKey() == key) {
                        V temp = (V) _array[hashkey].getValue();
                        _array[hashkey].setValue(value);
                        return temp;

                    } else {
                        i++;
                        hashkey = nextHash(firsthashkey, i);
                    }
                }
            }
        }
        _entryCounter++;
        return null;
    }

    /**
     * removes the mapping for this key from the map if present.
     */
    @Override
    public V remove(Object key) {


        if (containsKey(key) == false) {
            return null;
        } else {

            int hashkey = key.hashCode() % _length;

            int i = hashkey;
            while (i < _array.length) {
                if (_array[i].getKey() == key) {
                    V temp = (V) _array[i].getValue();
                    _array[i].setValid(false);
                    _entryCounter--;
                    return temp;

                }
            }
            return null;
        }
    }

    /**
     * copies all mappings from this map to the map.
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

        Set test = m.entrySet();
        MapEntry[] temp = new MapEntry[m.size()];
        _array = temp;


        for (Object o : test) {
            Entry<K, V> e = (Entry<K, V>) o;
            put(e.getKey(), e.getValue());
        }


    }

    /**
     * removes all mappings from the map.
     */
    @Override
    public void clear() {
        _array = new MapEntry[_length];
    }

    /**
     * returns a Set-view of the keys in the map.
     */
    @Override
    public Set<K> keySet() {

        Set test = new HashSet(_array.length);

        for (MapEntry e : _array) {
            if (e != null && e.isValid())
                test.add(e.getKey());
        }

        return test;
    }

    /**
     * returns a Collection-view of the values in the map.
     */
    @Override
    public Collection<V> values() {
        Set test = new HashSet(_array.length);

        for (MapEntry e : _array)
            if (e != null && e.isValid())
                test.add(e.getValue());

        return test;
    }

    /**
     * returns a Set-view of the mappings in the map.
     */
    @Override
    public Set<Entry<K, V>> entrySet() {
        Set test = new HashSet(_array.length);

        for (MapEntry e : _array)
            if (e != null && e.isValid())
                test.add(e);

        return test;
    }


}
