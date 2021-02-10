package leedcode.design;

import java.util.Iterator;
import java.util.PriorityQueue;

public class MinStack {
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }

    private void push(int i) {
        int[] value = new int[2];
        value[0] = pq.size();
        value[1] = i;
        pq.add(value);
    }

    private int pop() {
        int[] item = null;
        Iterator<int[]> values = pq.iterator();
        for (Iterator<int[]> it = values; it.hasNext(); ) {
            item = it.next();
            if (item[0] == pq.size() - 1) {
                it.remove();
                break;
            }
        }
        return item[1];
    }

    private int top() {
        int[] item = null;
        Iterator<int[]> values = pq.iterator();
        for (Iterator<int[]> it = values; it.hasNext(); ) {
            item = it.next();
            if (item[0] == pq.size() - 1) {
                break;
            }
        }
        return item[1];
    }

    private int getMin() {
        return pq.peek()[1];
    }

}
