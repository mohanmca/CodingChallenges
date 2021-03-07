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

    private static ListNode reverseList(ListNode listNode) {
        ListNode reverse = null;
        while (listNode != null) {
            ListNode tmp = listNode;
            listNode = listNode.next;
            tmp.next = reverse;
            reverse = tmp;
        }
        return reverse;
    }

}
