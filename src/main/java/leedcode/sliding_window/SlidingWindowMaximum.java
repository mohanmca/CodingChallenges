package leedcode.sliding_window;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums5 = {1, -1};
        System.out.println(Arrays.toString(maxSlidingWindow(nums5, 1)));
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
        int[] nums2 = {1};
        System.out.println(Arrays.toString(maxSlidingWindow(nums2, 1)));
        int[] nums3 = {9, 11};
        System.out.println(Arrays.toString(maxSlidingWindow(nums3, 2)));
        int[] nums4 = {4, -2};
        System.out.println(Arrays.toString(maxSlidingWindow(nums4, 2)));
    }

    public static int[] maxSlidingWindow(int[] nums2, int k) {
        int[][] nums = new int[nums2.length][2];
        for (int i = 0; i < nums2.length; i++) {
            nums[i] = new int[]{i, nums2[i]};
        }
        PriorityQueue<int[]> maxPq = new PriorityQueue<>(k, (o1, o2) -> o2[1] - o1[1]);
        int[] result = new int[nums.length - k + 1];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            maxPq.add(nums[i]);
            if (i + 1 >= k) {
                result[j++] = maxPq.peek()[1];
                maxPq.remove(nums[i + 1 - k]);
            }
        }
        return result;
    }

}
