package at.fhv.scc.tictactoe;

public class Node {

    private int _value;
    private SingleField[][] _matrix;
    private Node _child1;
    private Node _child2;

    public Node(){

    }

    public int getValue() {
        return _value;
    }

    public void setValue(int value) {
        _value = value;
    }

    public SingleField[][] getMatrix() {
        return _matrix;
    }

    public void setMatrix(SingleField[][] matrix) {
        _matrix = matrix;
    }

    public Node getChild1() {
        return _child1;
    }

    public void setChild1(Node child1) {
        _child1 = child1;
    }

    public Node getGetChild2() {
        return _child2;
    }

    public void setChild2(Node child2) {
        _child2 = child2;
    }
}
