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

    public Node copyRandomList(Node head) {
        Map<Node, Node> index = new HashMap<>();
        return copyRandomList(head, index);
    }

    public Node copyRandomList(Node head, Map<Node, Node> nodes) {
        if (head == null) return null;
        Node headPointer = head;
        Node oldNode = head;
        while (oldNode != null) {
            Node newNode = new Node(oldNode.val);
            nodes.put(oldNode, newNode);
            oldNode = oldNode.next;
        }
        while (head != null) {
            nodes.get(head).random = nodes.get(head.random);
            nodes.get(head).next = nodes.get(head.next);
            head = head.next;
        }
        return nodes.get(headPointer);
    }


}
