package at.fhv.tree;

public class Main {

    public static void main (String [] args){

        //----------------------------------------Creating Trees--------------------------------------------------------------//

        BinaryTree baum = new BinaryTree();                             //Binary Tree
        baum.createTree(baum.readInput("C:\\Users\\sebastian\\Desktop\\Übungen\\Tree\\test1.txt"), false);

        BinaryTree suchbaum = new BinaryTree();                         //Binary-Search Tree
        suchbaum.createTree(baum.readInput("C:\\Users\\sebastian\\Desktop\\Übungen\\Tree\\test1.txt"), true);

        //----------------------------------------Traverses-------------------------------------------------------------------//

        baum.output(Order.PREORDER);                                    //PreOrder-Traverse
        System.out.print("Preorder: ");
        baum.print();

        baum.output(Order.POSTORDER);                                   //PostOrder-Traverse
        System.out.print("Postorder: ");
        baum.print();

        baum.output(Order.INORDER);                                     //Inorder-Traverse
        System.out.print("Inorder: ");
        baum.print();

        baum.output(Order.LEVELBYLEVEL);                                //LevelByLevel-Traverse
        System.out.print("LevelByLevel: ");
        baum.print();

        baum.createSearchTree(baum.getRoot());                          //Chances Tree to SearchTree

        suchbaum.output(Order.LEVELBYLEVEL);                            //LevelByLevel-Traverse
        System.out.print("LevelByLevel: ");
        suchbaum.print();
        //-----------------------------------------Height/Leaves-------------------------------------------------------------//

        System.out.println("Height: " + baum.height(baum.getRoot()));    //Height

        System.out.println("Leaves: " + baum.leaves());                  //Leave-Count

        //-----------------------------------------Decode--------------------------------------------------------------------//

        DecodeTree codebaum = new DecodeTree();
        System.out.println("Decoded Text: " + codebaum.decode("1011010011", codebaum));

        //-------------------------------------------------------------------------------------------------------------------//


    }





}
