package at.fhv.ssc.RedBlackTree;

public class Node<T extends Comparable> {

    private Node _left;
    private Node _right;
    private Node _parent;
    private boolean _isBlack;
    private T _value;

    public Node(T value) {
        _value = value;
    }

    public String toString() {
        String left = _left == null ? "null" : "" + _left._value;
        String right = _right == null ? "null" : "" + _right._value;
        String parent = _parent == null ? "null" : "" + _parent._value;
        String value = _value == null ? "null" : "" + _value;
        return ("|-------------------------------------------------------------------|\n" + " value: " + value + " \t parent: " + parent + "\t left: " + left + " \t right: " + right + " \t");
    }


    public Node getLeft() {
        return _left;
    }

    public void setLeft(Node left) {
        _left = left;
    }

    public Node getRight() {
        return _right;
    }

    public void setRight(Node right) {
        _right = right;
    }

    public Node getParent() {
        return _parent;
    }

    public void setParent(Node parent) {
        _parent = parent;
    }

    public T getValue() {
        return _value;
    }

    public void setValue(T value) {
        _value = value;
    }

    public boolean isBlack() {
        return _isBlack;
    }

    public void setBlack(boolean black) {
        _isBlack = black;
    }
}