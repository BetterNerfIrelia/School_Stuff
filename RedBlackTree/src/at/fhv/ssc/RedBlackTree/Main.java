package at.fhv.ssc.RedBlackTree;

public class Main {
    public static void main(String[] args) {

        //-------Testing----------------------------------------------------------------------------------------------//

        RedBlackTree test = new RedBlackTree();
        test.insert(4);
        test.insert(5);

        System.out.println("RBHeight: " + test.getRBHeight() + "\n");

        test.debugPrint();

        //------------------------------------------------------------------------------------------------------------//

        RedBlackTree test1 = new RedBlackTree();

        test1.insert(20);
        test1.insert(18);


        System.out.println("RBHeight: " + test1.getRBHeight() + "\n");

        test1.debugPrint();

        //------------------------------------------------------------------------------------------------------------//


    }
}
