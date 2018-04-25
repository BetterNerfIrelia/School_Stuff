package at.fhv.ssc.integer_int;


public class IntegerInt {

    Integer i;
    int j;

    public static void main(String[] args){

        IntegerInt test = new IntegerInt();


        System.out.println(test.i);
        System.out.println(test.j);

        test.j=test.i;

        System.out.println(test.i);
        System.out.println(test.j);

    }



}





    private void insert(Node node) {
        Node temp = root;
        if (root == nil) {
            root = node;
            node.color = BLACK;
            node.parent = nil;
        } else {
            node.color = RED;
            while (true) {
                if (node.key < temp.key) {
                    if (temp.left == nil) {
                        temp.left = node;
                        node.parent = temp;
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else if (node.key >= temp.key) {
                    if (temp.right == nil) {
                        temp.right = node;
                        node.parent = temp;
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
            fixTree(node);
        }
    }
