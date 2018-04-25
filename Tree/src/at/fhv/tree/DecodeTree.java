package at.fhv.tree;

public class DecodeTree implements Tree {

    /**
     * 1011 0 100 11 = SENT
     * T: 11
     * N: 100
     * S: 1011
     * I: 1010
     * E: 0
     */

    private Node _root;

    /**
     * Hard-Coded Tree which creates a DecodeTree as stated.
     */

    public DecodeTree() {

        _root = new Node();

        _root.setLeft(new Node());
        _root.setRight(new Node('E'));
        _root.getLeft().setLeft(new Node('T'));
        _root.getLeft().setRight(new Node());
        _root.getLeft().getRight().setLeft(new Node());
        _root.getLeft().getRight().setRight(new Node('N'));
        _root.getLeft().getRight().getLeft().setLeft(new Node('S'));
        _root.getLeft().getRight().getLeft().setRight(new Node('I'));
    }

    /**
     * Gets a code-String and a given (hardcoded tree), returns the decoded String as result.
     */

    public String decode(String code, Tree tree) {

        StringBuilder result = new StringBuilder();

        Node node = _root;
        int counter = 0;

        for (int i = 0; i < code.length(); i++) {

            if (!node.hasChar()) {
                if (code.charAt(i) == '1') {
                    node = node.getLeft();
                }
                if (code.charAt(i) == '0') {
                    node = node.getRight();
                }

                counter++;
            } else {
                result.append(node.getCodechar());
                node = _root;
                i--;
            }
        }
        result.append(node.getCodechar());
        return result.toString();
    }


    @Override
    public void createTree(StringBuilder str, boolean searchtree) {

    }
}







