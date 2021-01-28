package leedcode.array.dynamic;

import java.util.Arrays;

public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(findMaxSumSubArray(nums));
        nums = new int[]{1, 2, 3, -5};
        System.out.println(findMaxSumSubArray(nums));
        nums = new int[]{-10000};
        System.out.println(findMaxSumSubArray(nums));
        nums = new int[]{1};
        System.out.println(findMaxSumSubArray(nums));
        nums = new int[]{0};
        System.out.println(findMaxSumSubArray(nums));
        nums = new int[]{-1};
        System.out.println(findMaxSumSubArray(nums));
    }

    public static int findMaxSumSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            max = Math.max(scanToFindMaxSum(nums, i), max);
        }
        return max;
    }

    public static int scanToFindMaxSum(int[] nums, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - n; i++) {
            max = Math.max(Arrays.stream(nums, i, i + n).sum(), max);
        }
        return max;
    }

}
