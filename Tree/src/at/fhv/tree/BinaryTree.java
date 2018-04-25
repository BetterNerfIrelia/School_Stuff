package at.fhv.tree;


import java.io.File;
import java.util.*;

/**
 * Aufgabe 1
 * Darstellungsformen von Binären Bäumen
 * [X,4,7,1,3,9,0,2,3,6,8,] test1.txt
 * [X,4,7,10,3,9,0,2,3,6,8,] test2.txt
 * <p>
 * Sequenzille Darstellung > Verkettete Darstellung
 * Textfile > StringBuilder > Nodes
 */

/**
 * Aufgabe 2
 * Binärere Baum/ Binärer Suchbaum
 * Einfügen eines Wertes
 * Ausgabe des Baumes: PreOrder, InOrder, PostOrder, Level-By-Level
 * Blätter zählen
 * Höhe bestimmen
 * Umwandlung: Binärer Baum > Binärer Suchbaum
 */

/**
 * Aufgabe 3
 * Dekodierung
 * Kodierungsbaum erstellen
 * 1 = left child, 0 = right child
 * 1011010011 > SENT
 * E, T, N, S, I  Hartkodiert
 */

public class BinaryTree implements Tree {

    /**
     * Inner class InOrder offers 4 different options for traversing.
     * PreOrder, PostOrder, InOder, LevelByLevel.
     */

    private class InOrder implements TraverseOrder {

        @Override
        public void traverse(Node node) {

            if (node == null) {
                return;
            }

            traverse(node.getLeft());

            _temp.append(node.getValue());

            traverse(node.getRight());
        }
    }

    private class PostOrder implements TraverseOrder {

        @Override
        public void traverse(Node node) {

            if (node == null) {
                return;
            }

            traverse(node.getLeft());

            traverse(node.getRight());

            _temp.append(node.getValue());
        }
    }

    private class PreOrder implements TraverseOrder {

        @Override
        public void traverse(Node node) {

            if (node == null) {
                return;
            }

            _temp.append(node.getValue());

            traverse(node.getLeft());

            traverse(node.getRight());
        }
    }

    private class LevelByLevel implements TraverseOrder {

        @Override
        public void traverse(Node node) {

            if (node == null) {
                return;
            }

            Queue<Node> queue = new LinkedList<Node>();
            queue.add(_root);

            while (!queue.isEmpty()) {
                node = queue.poll();
                _temp.append(node.getValue());
                if (node.getLeft() != null)
                    queue.add(node.getLeft());
                if (node.getRight() != null)
                    queue.add(node.getRight());
            }
        }
    }

    private Node _root;
    private StringBuilder _temp;
    private boolean _searchtree;
    private ArrayList<Node> _nodes;


    public BinaryTree() {


    }

    /**
     * Gets a Txt-File and reads the input into a StringBuilder as preparation the make a binary-tree.
     */

    public StringBuilder readInput(String source) {

        StringBuilder str = new StringBuilder();

        try {
            String path = source;
            File file = new File(path);
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                str.append(in.nextLine());
                str.append(" ");
            }
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return str;

    }

    /**
     * Inserts the value (int) into a tree.
     */

    public void insertValue(int value) {


        if (!_searchtree) {

            Random r = new Random();
            int random = 0;
            boolean left = false;
            boolean end = false;
            Node position = _root;

            while (!end) {
                random = r.nextInt(2);
                if (random > 0) {                                  //left
                    if (position.hasLeft() == true) {
                        position = position.getLeft();
                    } else {
                        end = true;
                        left = true;
                    }
                } else {                                           //right
                    if (position.hasRight() == true) {
                        position = position.getRight();
                    } else {
                        end = true;
                        left = false;
                    }
                }
            }
            if (left == true) {                                     //insert left
                position.setLeft(new Node(value));

            } else {                                                //insert right
                position.setRight(new Node(value));
            }
        } else {

            if (_root == null) {
                _root = new Node(value);
            } else {
                boolean left = false;
                boolean end = false;
                Node position = _root;

                while (!end) {
                    if (value >= position.getValue()) {                                  //left
                        if (position.hasLeft() == true) {
                            position = position.getLeft();
                        } else {
                            end = true;
                            left = true;
                        }
                    } else {                                           //right
                        if (position.hasRight() == true) {
                            position = position.getRight();
                        } else {
                            end = true;
                            left = false;
                        }
                    }
                }
                if (left == true) {                                     //insert left
                    position.setLeft(new Node(value));

                } else {                                                //insert right
                    position.setRight(new Node(value));
                }
            }
        }
    }

    /**
     * Inserts the value (Node) into a tree.
     */

    public void insertValue(Node node) {

        if (_root == null) {
            _root = node;
        } else {
            boolean left = false;
            boolean end = false;
            Node position = _root;

            while (!end) {
                if (node.getValue() >= position.getValue()) {      //left
                    if (position.hasLeft() == true) {
                        position = position.getLeft();
                    } else {
                        end = true;
                        left = true;
                    }
                } else {                                           //right
                    if (position.hasRight() == true) {
                        position = position.getRight();
                    } else {
                        end = true;
                        left = false;
                    }
                }
            }
            if (left == true) {                                     //insert left
                position.setLeft(node);

            } else {                                                //insert right
                position.setRight(node);
            }
        }
    }

    /**
     * Create a tree with the read input.
     */

    public void createTree(StringBuilder str, boolean searchtree) {

        _searchtree = searchtree;
        if (!_searchtree) {

            String stri = str.toString();
            String[] parts = stri.split(" ");
            Node[] tree = new Node[parts.length + 1];

            for (int i = 1; i < tree.length; i++) {
                if (i == 1) {
                    tree[i] = new Node(Integer.valueOf(parts[i - 1]));
                    _root = tree[1];

                }
                if ((i * 2 + 1 <= tree.length)) {
                    tree[2 * i] = new Node(Integer.valueOf(parts[2 * i - 1]));
                    tree[i].setLeft(tree[2 * i]);

                    if ((i * 2 + 2 <= tree.length)) {
                        tree[2 * i + 1] = new Node(Integer.valueOf(parts[2 * i]));
                        tree[i].setRight(tree[2 * i + 1]);
                    }
                }
            }
        } else {
            String stri = str.toString();
            String[] parts = stri.split(" ");

            for (int i = 1; i < parts.length + 1; i++) {
                insertValue(Integer.valueOf(parts[i - 1]));
            }
        }
    }

    /**
     * Outputs the tree in a chosen kind of traversing.
     */


    public void output(Order order) {

        _temp = new StringBuilder();
        TraverseOrder traverse = null;
        switch (order) {
            case PREORDER:
                traverse = new PreOrder();
                break;
            case INORDER:
                traverse = new InOrder();
                break;
            case POSTORDER:
                traverse = new PostOrder();
                break;
            case LEVELBYLEVEL:
                traverse = new LevelByLevel();
                break;
        }
        traverse.traverse(_root);
    }

    /**
     * Prints the current tree.
     */

    public void print() {

        System.out.println(_temp);

    }

    /**
     * Calculates the height of the tree.
     */

    public int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    /**
     * Calculates the number of trees.
     */

    public int leaves() {
        return getTemp().length();
    }

    /**
     * Creates a new SearchTree.
     */

    public void createSearchTree(Node node) {
        _nodes = new ArrayList<>();
        makeSearchTree(node);
        _root = null;
        _searchtree = true;

        for (Node n : _nodes) {
            insertValue(n);
        }
    }

    /**
     * Helping Method to Create a new SearchTree.
     */

    public void makeSearchTree(Node node) {

        if (node == null) {
            return;
        }

        _nodes.add(node);

        makeSearchTree(node.getLeft());

        makeSearchTree(node.getRight());

        node.setLeft(null);
        node.setRight(null);
    }

    public Node getRoot() {
        return _root;
    }

    public void setRoot(Node root) {
        _root = root;
    }

    public StringBuilder getTemp() {
        return _temp;
    }

    public void setTemp(StringBuilder temp) {
        _temp = temp;
    }

    public boolean isSearchtree() {
        return _searchtree;
    }

    public void setSearchtree(boolean searchtree) {
        _searchtree = searchtree;
    }
}
