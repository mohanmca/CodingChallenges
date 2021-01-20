package leedcode.list;

public class ReverseLinkedList {

    public static void main(String[] args) {
        var listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        System.out.println(reverseList(listNode1));
        listNode1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(reverseList(listNode1));
        listNode1 = new ListNode(1);
        System.out.println(reverseList(listNode1));
        System.out.println(reverseList(null));
    }

    public static ListNode reverseList(ListNode node) {
        ListNode newNode = null;
        while (node != null) {
            ListNode head = node;
            node = node.next;
            head.next = newNode;
            newNode = head;
        }
        return newNode;
    }


}
