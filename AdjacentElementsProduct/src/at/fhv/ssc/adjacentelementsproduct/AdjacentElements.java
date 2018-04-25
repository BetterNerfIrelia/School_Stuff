package at.fhv.ssc.adjacentelementsproduct;

/**
 * Created by sebastian on 28.04.2017.
 */
public class AdjacentElements {

    public AdjacentElements() {
    }

    int adjacentElementsProduct(int[] inputArray) {  //inputArray = [3, 6, -2, -5, 7, 3]

        int max = inputArray[0] * inputArray[1];
        int i = 0;
        int j = 1;

        while (i < inputArray.length - 1) {
            if (inputArray[i] * inputArray[j] > max) {
                max = inputArray[i] * inputArray[j];
            }
            i++;
            j++;
        }
        return max;

    }
}


