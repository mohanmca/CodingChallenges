package leedcode.list;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode l2 = new ListNode(3, new ListNode(4, new ListNode(5)));
        System.out.println(mergeLists(l1, l2));
//        System.out.println(mergeLists(l1, null));
//        System.out.println(mergeLists(null, l1));
    }

    public static ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode resultTail = null;
        ListNode head = null;
        while (l1 != null && l2 != null) {
            ListNode smaller = null;
            if (l1.val < l2.val) {
                smaller = l1;
                l1 = l1.next;
            } else {
                smaller = l2;
                l2 = l2.next;
            }
            if (resultTail == null) {
                resultTail = smaller;
                resultTail.next = null;
                head = resultTail;
            } else {
                resultTail.next = smaller;
                resultTail = resultTail.next;
            }

        }
        ListNode leftOver = l1 == null ? l2 : l1;

        if (resultTail == null) {
            resultTail = leftOver;
            head = resultTail;
        } else {
            resultTail.next = leftOver;
        }
        return head;
    }
}

