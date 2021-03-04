package leedcode.list;

import java.util.ArrayDeque;

public class IntersectionOfLinkedList {

    public static void main(String[] args) {
        IntersectionOfLinkedList solution = new IntersectionOfLinkedList();
        var commonNode = new ListNode(8, new ListNode(4, new ListNode(5)));
        var listNode1 = new ListNode(4, new ListNode(1, commonNode));
        var listNode2 = new ListNode(5, new ListNode(6, new ListNode(1, commonNode)));
        System.out.println(solution.getIntersectionNode(listNode1, listNode2));
        listNode2 = new ListNode(1, commonNode);
        System.out.println(solution.getIntersectionNode(listNode1, listNode2));
        listNode1 = new ListNode(1);
        System.out.println(solution.getIntersectionNode(listNode1, listNode2));
        System.out.println(solution.getIntersectionNode(null, listNode1));
    }

    public ListNode getIntersectionNode(ListNode nodeA, ListNode headB) {
        ArrayDeque<ListNode> stackA = new ArrayDeque<>();
        ArrayDeque<ListNode> stackB = new ArrayDeque<>();

        while (nodeA != null) {
            stackA.push(nodeA);
            nodeA = nodeA.next;
        }
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }
        ListNode intersection = null;
        while (stackA.peek() != null && stackA.peek().equals(stackB.peek())) {
            stackA.pop();
            intersection = stackB.pop();
        }
        return intersection;
    }


}
