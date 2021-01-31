package leedcode.array;

import java.util.Arrays;

public class FindRunningSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(Arrays.toString(runningSum(nums)) );
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(runningSum(nums2)) );
    }

    public static int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];

        for (int i = 0; i < runningSum.length; i++) {
            runningSum[i] = i == 0 ? nums[i] : runningSum[i - 1] + nums[i];
        }
        return runningSum;
    }
}
