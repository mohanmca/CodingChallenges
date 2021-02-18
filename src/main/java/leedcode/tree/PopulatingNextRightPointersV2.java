package leedcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersV2 {

    public static void main(String[] args) {
        PopulatingNextRightPointersV2 solution = new PopulatingNextRightPointersV2();
        Node left = new Node(3, new Node(2), new Node(1), null);
        Node right = new Node(3, new Node(2), new Node(1), null);
        Node root = new Node(7, left, right, null);
        System.out.println(root);
        System.out.println(solution.connect(root));
    }

    public Node connect(Node root) {
        if (root == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node prevNode = null;
            for (int i = 0; i < n; i++) {
                Node node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (prevNode != null) {
                    prevNode.next = node;
                }
                prevNode = node;
            }
        }

        return root;
    }

}
