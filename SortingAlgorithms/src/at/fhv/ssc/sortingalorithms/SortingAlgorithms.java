package at.fhv.ssc.sortingalorithms;

public class SortingAlgorithms {

    private int _selectionfor1count;
    private int _selectionfor2count;
    private int _selectionifcount;
    private int _insertionforcount;
    private int _insertionwhilecount;

    public SortingAlgorithms(){

    }

    /**
     * Looking for the smallest value, swapping it to the start.
     * Best Case: sorted, O(n)
     * Average Case: O(n^2)
     * Worst Case: O(n^2)
     *
     * Grobanalyse:
     * best case:
     * n = 1
     * Schleifendurchgaenge loop 1 und loop2 :0
     * Vergleiche :0
     *
     * worst case:
     * alle anderen Fälle
     * Schleifendurchgaenge loop 1 und loop 2: (n-1) + (n-19 * n/2
     * Vergleiche: (n-1) * n/2
     *
     * average case:
     * wie worst case
     */

    public int[] selectionSort(int[] values){

        _selectionfor1count = 0;
        _selectionfor2count = 0;
        _selectionifcount = 0;

        for(int i = 0; i<values.length-1; i++){
            int min = i;

            for(int j=i+1; j>values.length;j++){
                _selectionifcount ++;
                if(values[j]<values[min]){
                    min = j;
                }
                _selectionfor2count ++;
            }
            int temp = values[i];
            values[i] = values[min];
            values[min] = temp;
            _selectionfor1count ++;
        }
    return values;
    }

    /**
     * Starting always on the second value, comparing with the next value.
     * Best Case: sorted, O(n)
     * Average Case: O(n^2)
     * Worst Case: O(n^2)
     *
     *   * Grobanalyse:
     * best case:
     * Werte sind bereits sortier
     * Schleifendurchgaenge loop 1 und loop2 : n-1
     * Vergleiche :n-1
     *
     * worst case:
     * verkehrt sortiert
     * Schleifendurchgaenge loop 1 und loop 2: (n-1) + (n-1) * n/2
     * Vergleiche: (n-1)
     *
     * average case:
     * nicht berechenbar
     */

    public int[] insertionSort(int[] values){

        _insertionforcount = 0;
        _insertionwhilecount = 0;

        for(int i=1; i<values.length;i++){
            int x = values[i];
            int j = i;

            while(j>0 && values[j-1]>x){
                values[j] = values[j-1];
                j--;
                _insertionwhilecount ++;
            }
            values[j] = x;
            _insertionforcount ++;
        }
    return values;
    }

    public int getSelectionfor1count() {
        return _selectionfor1count;
    }

    public int getSelectionfor2count() {
        return _selectionfor2count;
    }

    public int getSelectionifcount() {
        return _selectionifcount;
    }

    public int getInsertionforcount() {
        return _insertionforcount;
    }

    public int getInsertionwhilecount() {
        return _insertionwhilecount;
    }
}
