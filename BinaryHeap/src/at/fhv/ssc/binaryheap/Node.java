package at.fhv.ssc.binaryheap;

public class Node {

    private int _rank;
    private int _value;
    private Node _left;
    private Node _right;

    public Node(int value) {
        _value = value;
        _rank = 1;
    }

    public boolean hasLeft() {
        if (_left != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasRight() {
        if (_right != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLeaf() {
        if (_left == null && _right == null) {
            return true;
        } else {
            return false;
        }
    }

    public void calcRank() {
        if (_left != null && _right != null) {
            _rank = Math.min(_left._rank, _right._rank) + 1;
        } else {
            _rank = 1;
        }
    }

    public int getRank() {
        return _rank;
    }

    public void setRank(int rank) {
        _rank = rank;
    }

    public int getValue() {
        return _value;
    }

    public void setValue(int value) {
        _value = value;
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

}