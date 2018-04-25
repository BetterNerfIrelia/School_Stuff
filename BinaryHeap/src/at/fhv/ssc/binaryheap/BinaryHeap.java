package at.fhv.ssc.binaryheap;

import java.util.Comparator;
import java.util.EmptyStackException;

public class BinaryHeap implements Comparator<Integer> {

    private boolean _isEmpty;
    private Node _root;
    private Node _lastNode;
    private Node _temp;

    public BinaryHeap(Node node) {
        _root = node;
    }

    public Node search(Node node) {

        if (node == _lastNode) {
            _temp = _root;
        } else {
            _temp = node;
        }

        while (_temp.hasLeft() || _temp.hasRight()) {
            if (_temp.getLeft() == _lastNode) {
                _temp = _temp.getLeft();
            } else {
                search(_temp.getLeft());
            }
            if (_temp.getRight() == _lastNode) {
                _temp = _temp.getRight();
            } else {
                search(_temp.getRight());
            }
        }
        return _temp;
    }

    private void changeRank(Node node) {
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            return;
        }
        changeRank(node.getLeft());
        changeRank(node.getRight());
        node.calcRank();
    }

    public void enqueue(int value) {
        Node node = new Node(value);
        insert(_root, node);
    }

    public int dequeue() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        int result = _root.getValue();

        if (_root.isLeaf()) {
            _root = null;
        } else if (_root.getRight() == null) {
            _root = _root.getLeft();
        } else {
            Node max;
            Node min;
            if (_root.getLeft().getValue() >= _root.getRight().getValue()) {
                max = _root.getLeft();
                min = _root.getRight();
            } else {
                max = _root.getRight();
                min = _root.getLeft();
            }
            _root = max;
            insert(_root, min);

        }
        return result;
    }

    private void insert(Node position, Node newNode) {
        if (isEmpty()) {
            _root = newNode;
            return;
        }
        if (newNode.getValue() >= position.getValue()) {
            newNode.setRight(_root);
            _root = newNode;
            changeRank(_root);
            sort(_root);
            return;
        }
        while ((position.getRight() != null) &&
                ((position.getRight().getValue() >= newNode.getValue()))) {
            position = position.getRight();
        }
        if (position.getRight() == null) {
            position.setRight(newNode);
        } else {
            Node oldRight = position.getRight();
            position.setRight(newNode);
            insert(newNode, oldRight);
        }
        changeRank(_root);
        sort(_root);
    }

    public void sort(Node parent) {

        if (parent == null || parent.isLeaf()) {
            return;
        }
        sort(parent.getLeft());
        sort(parent.getRight());

        int leftRank = (parent.getLeft() == null ? 0 : parent.getLeft().getRank());
        int rightRank = (parent.getRight() == null ? 0 : parent.getRight().getRank());

        if (leftRank < rightRank) {
            Node temp = parent.getLeft();
            parent.setLeft(parent.getRight());
            parent.setRight(temp);
            changeRank(temp);
        }
    }

    @Override
    public int compare(Integer a, Integer b) {
        if (a > b) {
            return 1;
        }
        if (a == b) {
            return 0;
        }
        return -1;
    }

    public boolean isEmpty() {
        return _isEmpty;
    }

    public void setEmpty(boolean empty) {
        _isEmpty = empty;
    }

    public Node getRoot() {
        return _root;
    }

    public void setRoot(Node root) {
        _root = root;
    }

}