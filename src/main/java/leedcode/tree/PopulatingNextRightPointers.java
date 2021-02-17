package leedcode.tree;

public class PopulatingNextRightPointers {
    public Node connect(Node root) {
        if (root == null) return root;
        connect(root.left, root.right);
        return root;
    }

    public void connect(Node leftNode, Node rightNode) {
        if (leftNode == null && rightNode == null) return;
        if (leftNode != null) {
            leftNode.next = rightNode;
            connect(leftNode.left, leftNode.right);
        }
        if (leftNode != null && rightNode != null) {
            connect(leftNode.right, rightNode.left);
        }
        if (rightNode != null) {
            connect(rightNode.left, rightNode.right);
        }
    }
}
