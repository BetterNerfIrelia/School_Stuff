package at.fhv.tree;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class Node implements TreeNode {

    private char _codechar;
    private int _value;
    private Node _left;
    private Node _right;

    public Node() {

    }

    public Node(int value) {
        _value = value;
    }

    public Node(char codechar) {
        _codechar = codechar;
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return null;
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public TreeNode getParent() {
        return null;
    }

    @Override
    public int getIndex(TreeNode node) {
        return 0;
    }

    @Override
    public boolean getAllowsChildren() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public Enumeration children() {
        return null;
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

    public char getCodechar() {
        return _codechar;
    }

    public void setCodechar(char codechar) {
        _codechar = codechar;
    }

    public boolean hasChar() {
        if (_codechar >= 'A' && _codechar <= 'Z') {
            return true;
        } else {
            return false;
        }
    }




}
