package leedcode.list;

public class AddTwoNumber {
    public static void main(String[] args) {
        var listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        var listNode2 = new ListNode(7, new ListNode(0, new ListNode(8)));
        System.out.println(addTwoNumbers(listNode1, listNode2).toString());
        var listNode3 = new ListNode(7, new ListNode(8));
        System.out.println(addTwoNumbers(listNode1, listNode3).toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = null;
        ListNode head = null;

        while (l1 != null && l2 != null) {
            if (node == null) {
                node = new ListNode(l1.val + l2.val);
                head = node;
            } else {
                node.next = new ListNode(l1.val + l2.val);
                if (node.val > 9) {
                    int carry = node.val / 10;
                    node.val = node.val % 10;
                    node.next.val += carry;
                }
                node = node.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode leftOverNode = l1 != null ? l1 : l2;
        node.next = leftOverNode;
        while (node.next != null && node.val > 9) {
            int carry = node.val / 10;
            node.val = node.val % 10;
            node.next.val = node.next.val + carry;
            node = node.next;
        }

        if (node.val > 9) {
            int carry = node.val / 10;
            node.next = new ListNode(carry);
            node.val = node.val % 10;

        }

        return head;
    }
}
