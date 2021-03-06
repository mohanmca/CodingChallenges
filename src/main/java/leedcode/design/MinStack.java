package leedcode.design;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MinStack {
    PriorityQueue<long[]> pq = new PriorityQueue<long[]>(Comparator.comparingLong(a -> a[1]));

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.getMin());

        MinStack stack2 = new MinStack();
        stack2.push(2147483647);
        System.out.println(stack2.top());
        System.out.println(stack2.getMin());
        stack2.push(-2147483648);
        System.out.println(stack2.top());
        System.out.println(stack2.getMin());
    }

    public void push(int i) {
        long[] value = new long[2];
        value[0] = pq.size();
        value[1] = i;
        pq.add(value);
    }

    public int pop() {
        long[] item = null;
        Iterator<long[]> values = pq.iterator();
        for (Iterator<long[]> it = values; it.hasNext(); ) {
            item = it.next();
            if (item[0] == pq.size() - 1) {
                it.remove();
                break;
            }
        }
        return (int)item[1];
    }

    public int top() {
        long[] item = null;
        Iterator<long[]> values = pq.iterator();
        for (Iterator<long[]> it = values; it.hasNext(); ) {
            item = it.next();
            if (item[0] == pq.size() - 1) {
                break;
            }
        }
        return (int) item[1];
    }

    public int getMin() {
        return (int)pq.peek()[1];
    }

}

//["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
//[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
//[null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,2147483647,null,2147483647]
//[null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]
//
