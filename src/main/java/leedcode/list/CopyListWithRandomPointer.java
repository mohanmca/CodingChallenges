package leedcode.list;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public static void main(String[] args) {
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();
        var one = new Node(1);
        var ten = new Node(10, one);
        var eleven = new Node(11, ten);
        ten.random = eleven;
        var thirteen = new Node(13, eleven);

        var head = new Node(7, thirteen, null);
        thirteen.random = head;
        System.out.println(head);
        System.out.println(solution.copyRandomList(head));
    }

    public  Node copyRandomList(Node node) {
        Map<Integer, Node> index = new HashMap<>();
        return copyRandomList(node, index);
    }

    public  Node copyRandomList(Node node, Map<Integer, Node> nodes) {
        if (node == null) return null;
        int i = nodes.size();
        Node newNode = new Node(node.val);
        nodes.put(i, newNode);
        newNode.next = copyRandomList(node.next, nodes);
        int j = findN(node.random);
        if (j >= 0) {
            int k = nodes.size() - 1 - j;
            newNode.random = nodes.getOrDefault(k, null);
        }
        return newNode;
    }

    private static int findN(Node random) {
        int n = -1;
        while (random != null) {
            n++;
            random = random.next;
        }
        return n;
    }


}
