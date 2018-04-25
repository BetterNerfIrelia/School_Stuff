package at.fhv.ssc.arraybunch;

import sun.util.resources.cldr.aa.CurrencyNames_aa;

/**
 * Created by sebastian on 01.09.2017.
 */
public class ArrayBunch {

    private String[][] _arrays;
    private int _bunchsize;
    private int _quantity;
    private int _count;

    public ArrayBunch (String[][] arrays){
        _arrays = arrays;
        _quantity = _arrays.length;

       for(int i = 0; i < _quantity; i++){
        _bunchsize = (_bunchsize + (_arrays[i].length));
       }
    }

    public String get (int index){
        int bunchindex = bunchinize(index);
        return _arrays[_count][bunchindex];
    }

    public void set(int index, String value){
        int bunchindex = bunchinize(index);
        _arrays[_count][bunchindex] = value;

    }

    private int bunchinize (int index) {
        int count = 0;
        int bunchindex = index;

        if (index >= _arrays[0].length) {

            for(int i = 1; i<_quantity; i++) {
                if ((index - (_arrays[i-1].length)) >= 0 == true) {
                    index = index - _arrays[i-1].length;
                    count = count + 1;
                }
            }

            for(int i = 0; i<count; i++) {
                bunchindex = bunchindex - _arrays[i].length;

            }
        }
        else{bunchindex = index;
        }

        _count = count;
        return bunchindex;
    }

    public int size(){

        return _bunchsize;
    }


    public int getQuantity() {
        return _quantity;
    }
}

