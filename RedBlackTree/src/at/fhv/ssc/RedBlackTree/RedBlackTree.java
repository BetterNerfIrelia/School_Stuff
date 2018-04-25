package at.fhv.ssc.RedBlackTree;

import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTree<T extends Comparable> {

    private Node _root;
    private Node _nil;

    /**
     * RBTree<T>
     * insert: Wert einfügen.
     * getRBHeight: RB-Höhe ausgehend von der Root. (nur schwarze, immer gleich einfach linke Pfad runter)
     * debugPrint: Baum inkl. Meta-Info ausgeben.
     * <p>
     * REGELN:  Root ist immer schwarz.
     * Die NIL-Nodes sind immmer schwarz.
     * Node rot => Kinder schwarz.
     * Jeder Pfad hat gleiche Anzahl schwarze Knoten.
     */

    public RedBlackTree() {
        _nil = new Node(null);
        _nil.setBlack(true);
    }

    public void insert(T value) {

        if (_root == null) {
            _root = new Node<T>(value);
            _root.setBlack(true);
            _root.setLeft(_nil);
            _root.setRight(_nil);
        } else {
            boolean left = false;
            boolean end = false;
            Node<T> position = _root;

            while (!end) {
                if (value.compareTo(position.getValue()) >= 0) {   //left
                    if (position.getLeft() != _nil) {
                        position = position.getLeft();
                    } else {
                        end = true;
                        left = true;
                    }
                } else {                                           //right
                    if (position.getRight() != _nil) {
                        position = position.getRight();
                    } else {
                        end = true;
                        left = false;
                    }
                }
            }
            if (left == true) {
                Node<T> leftnode = new Node<T>(value);             //insert left, neue immer rot
                position.setLeft(leftnode);
                leftnode.setLeft(_nil);
                leftnode.setRight(_nil);
                leftnode.setParent(position);
                applyRules(leftnode);

            } else {
                Node<T> rightnode = new Node<T>(value);           //insert right, neue immer rot
                position.setRight(rightnode);
                rightnode.setLeft(_nil);
                rightnode.setRight(_nil);
                rightnode.setParent(position);
                applyRules(rightnode);
            }
        }
    }

    public int getRBHeight() {
        int count = 0;
        if (_root == null) {
            return 0;
        }
        Node<T> temp;
        temp = _root;
        while (temp != _nil) {
            if (temp.isBlack()) {
                count++;
            }
            temp = temp.getLeft();
        }
        return count;
    }


    private void applyRules(Node<T> node) {
        while (node.getParent().isBlack() == false) {
            Node<T> uncle = _nil;
            if (node.getParent() == node.getParent().getParent().getLeft()) {
                uncle = node.getParent().getParent().getRight();

                if (uncle != _nil && !uncle.isBlack()) {
                    node.getParent().setBlack(true);
                    uncle.setBlack(true);
                    node.getParent().getParent().setBlack(false);
                    node = node.getParent().getParent();
                    continue;
                }
                if (node == node.getParent().getRight()) {
                                                                                        //double rotation
                    node = node.getParent();
                    rotateLeft(node);
                }
                node.getParent().setBlack(true);
                node.getParent().getParent().setBlack(false);
                                                                                        //single rotation
                rotateRight(node.getParent().getParent());
            } else {
                uncle = node.getParent().getParent().getLeft();
                if (uncle != _nil && !uncle.isBlack()) {
                    node.getParent().setBlack(true);
                    uncle.setBlack(true);
                    node.getParent().getParent().setBlack(false);
                    node = node.getParent().getParent();
                    continue;
                }
                if (node == node.getParent().getLeft()) {
                                                                                        //double rotation
                    node = node.getParent();
                    rotateRight(node);
                }
                node.getParent().setBlack(true);
                node.getParent().getParent().setBlack(false);
                                                                                        //single rotation
                rotateLeft(node.getParent().getParent());
            }
        }
        _root.setBlack(true);
    }


    void rotateLeft(Node node) {
        if (node.getParent() != _nil) {
            if (node == node.getParent().getLeft()) {
                node.getParent().setLeft(node.getRight());
            } else {
                node.getParent().setRight(node.getRight());
            }
            node.getRight().setParent(node.getParent());
            node.setParent(node.getRight());
            if (node.getRight().getLeft() != _nil) {
                node.getRight().getLeft().setParent(node);
            }
            node.setRight(node.getRight().getLeft());
            node.getParent().setLeft(node);
        } else {//Need to rotate root
            Node right = _root.getRight();
            _root.setRight(right.getLeft());
            right.getLeft().setParent(_root);
            _root.setParent(right);
            right.setLeft(_root);
            right.setParent(_nil);
            _root = right;
        }
    }


    public void rotateRight(Node node) {
        if (node.getParent() != _nil) {
            if (node == node.getParent().getLeft()) {
                node.getParent().setLeft(node.getLeft());
            } else {
                node.getParent().setRight(node.getLeft());
            }

            node.getLeft().setParent(node.getParent());
            node.setParent(node.getLeft());
            if (node.getLeft().getRight() != _nil) {
                node.getLeft().getRight().setParent(node);
            }
            node.setLeft(node.getLeft().getRight());
            node.getParent().setRight(node);
        } else {//Need to rotate root
            Node left = _root.getLeft();
            _root.setLeft(_root.getLeft().getRight());
            left.getRight().setParent(_root);
            _root.setParent(left);
            left.setRight(_root);
            left.setParent(_nil);
            _root = left;
        }
    }

    public boolean isEmpty() {
        return _root == null;
    }

    public void debugPrint() {

        if (isEmpty()) {
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(_root);
        StringBuilder str = new StringBuilder();


        while (!queue.isEmpty()) {
            Node n = queue.poll();
            str.append(n.getValue());
            if (n.getLeft() != null)
                queue.add(n.getLeft());
            if (n.getRight() != null)
                queue.add(n.getRight());
            System.out.println(n);
        }
    }
}

















