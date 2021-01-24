package leedcode.list;

import java.util.PriorityQueue;

public class MergeKSortedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(5))));
        ListNode l3 = new ListNode(2, new ListNode(6));
        System.out.println(mergeKLists(new ListNode[]{l1, l2, l3}));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode(Integer.MAX_VALUE);
        ListNode head = merged;
        if (lists.length == 0) return null;
        while (true) {
            int pointer = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && min > lists[i].val) {
                    merged.next = lists[i];
                    min = lists[i].val;
                    pointer = i;
                }
            }
            if (pointer >= 0) {
                lists[pointer] = lists[pointer].next;
                merged = merged.next;
            } else {
                break;
            }
        }
        return head.next;
    }
}
