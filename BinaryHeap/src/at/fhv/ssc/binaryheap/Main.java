package at.fhv.ssc.binaryheap;

public class Main {

    public static void main(String[] args) {

        //-------Creation---------------------------------------------------------------------------------------------//

        Node node = new Node(10);
        BinaryHeap heap = new BinaryHeap(node);

        //-------Testing----------------------------------------------------------------------------------------------//

        System.out.println("value: " + heap.getRoot().getValue());
        System.out.println("rank: " + heap.getRoot().getRank());

        heap.enqueue(12);

        heap.enqueue(7);

        heap.enqueue(24);

        System.out.println( "isEmpty: " + heap.isEmpty());
        System.out.println("value: " + heap.getRoot().getLeft().getValue());
        System.out.println("rank: " + heap.getRoot().getLeft().getRank());

        //------------------------------------------------------------------------------------------------------------//

        System.out.println("value: " + heap.getRoot().getValue());
        System.out.println("rank: " + heap.getRoot().getRank());

        heap.enqueue(8);

        heap.enqueue(9);

        heap.enqueue(10);

        System.out.println( "isEmpty: " + heap.isEmpty());
        System.out.println("value: " + heap.getRoot().getLeft().getValue());
        System.out.println("rank: " + heap.getRoot().getLeft().getRank());

        //------------------------------------------------------------------------------------------------------------//


    }
}
