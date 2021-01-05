package leedcode.array;

import java.util.PriorityQueue;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{1, 2, 9};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{0, 2, 2, 1, 1};
        System.out.println(firstMissingPositive(nums));


    }

    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        int currentMin = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue(nums.length);

        for (int num : nums) {
            if (num > 0) {
                if (num < currentMin) currentMin = num;
                if (!pq.contains(num))
                    pq.add(num);
            }
        }
        int expectedSequence = 1;
        while (!pq.isEmpty()) {
            if (pq.remove() != expectedSequence++)
                return (expectedSequence - 1);
        }
        return expectedSequence;
    }
}
