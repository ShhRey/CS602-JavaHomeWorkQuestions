package bst;

class TreeNode<E extends Comparable<E>> {
    TreeNode<E> leftNode;
    E data; // node value 
    TreeNode<E> rightNode;

    public TreeNode(E nodeData) {
        data = nodeData;
        leftNode = rightNode = null;
    }

    public void insert(E insertValue) {
        if (insertValue.compareTo(data) < 0) { // Insert in the left subtree
            if (leftNode == null) {
                leftNode = new TreeNode<>(insertValue);
            } else {
                leftNode.insert(insertValue);
            }
        } else { // Insert in the right subtree
            if (rightNode == null) {
                rightNode = new TreeNode<>(insertValue);
            } else {
                rightNode.insert(insertValue);
            }
        }
    }
}
