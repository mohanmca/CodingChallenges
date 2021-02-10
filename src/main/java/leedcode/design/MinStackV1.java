package leedcode.design;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MinStackV1 {

    /** initialize your data structure here. */
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);

    public MinStackV1(){
    }

    public static void main(String[] args) {
        MinStackV1 stack = new MinStackV1();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }

    public void push(int i) {
        int[] value = new int[2];
        value[0] = pq.size();
        value[1] = i;
        pq.add(value);
    }

    public int pop() {
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

    public int top() {
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

    public int getMin() {
        return pq.peek()[1];
    }

}

//["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
//[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
//[null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,2147483647,null,2147483647]
//[null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]
//
