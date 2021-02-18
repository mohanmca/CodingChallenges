package leedcode.tree;

public class PopulatingNextRightPointers {

    public static void main(String[] args) {
        PopulatingNextRightPointers solution = new PopulatingNextRightPointers();
        Node left = new Node(3, new Node(2), new Node(1), null);
        Node right = new Node(3, new Node(2), new Node(1), null);
        Node root = new Node(7, left, right, null);
        System.out.println(root);
        System.out.println(solution.connect(root));
    }

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
