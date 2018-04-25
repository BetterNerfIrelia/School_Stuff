package at.fhv.ssc.sortingalorithms;

public class Main {

    public static void main(String [] args){

    SortingAlgorithms testSort = new SortingAlgorithms();

        //----INPUT ARRAY---------------------------------------------------------------

        int[] testArray = {150,137,150,179,210,165,149,136,148,162,152,153,137,138,154,128,159,129,156,161,168,128,187,169,127,156,139,157,169,149};

        System.out.println(" //----INPUT----");
        for(int i=0; i<testArray.length; i++){
            System.out.print(testArray[i]);
        }
        System.out.println("\n");

        //----INSERTION SORT---------------------------------------------------------------

        int[] insertionArray = testSort.insertionSort(testArray);
        System.out.println(" //----INSERTION SORT----");
        System.out.print("InsertionSort: ");

        for(int i=0; i<insertionArray.length; i++){
        System.out.print(insertionArray[i]);
        }
        System.out.print("\n");
        System.out.println("ForCount: " + testSort.getInsertionforcount());
        System.out.println("WhileCount: " + testSort.getInsertionwhilecount());
        System.out.print("\n" + " //----SELECTION SORT----" + "\n");


        //----SELECTION SORT---------------------------------------------------------------

        int[] selectionArray = testSort.selectionSort(testArray);
        System.out.print("SelectionSort: ");

        for(int i=0; i<selectionArray.length; i++){
            System.out.print(selectionArray[i]);
        }
        System.out.print("\n");
        System.out.println("For1Count: " + testSort.getSelectionfor1count());
        System.out.println("For2Count: " + testSort.getSelectionfor2count());
        System.out.println("IfCount: " + testSort.getSelectionifcount());

    }
}
