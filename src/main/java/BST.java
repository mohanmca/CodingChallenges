import java.util.Arrays;
import java.util.List;

public class BST {

    private Node root;

    BST() {

    }

    private static void main(String[] args) {
        List<Integer> integers = Arrays.asList(9, 1, 2, 3, 4, 5, 6, 7, 8);

    }

    public void insert(int integer) {
        insert(root, integer);
    }

    public Node insert(Node node, int integer) {
        if (node == null) {
            node = new Node();
            node.value = integer;
            node.size = 1;
            root = node;
            return node;
        } else if (node.value > integer) {
            return insert(node.left, integer);
        } else if (node.value < integer) {
            insert(node.right, integer);
        }
        return node;
    }

    private static class Node {
        int value;
        int size;
        Node left;
        Node right;
    }
}
