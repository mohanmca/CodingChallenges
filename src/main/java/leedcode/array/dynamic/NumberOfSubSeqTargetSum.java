package leedcode.array.dynamic;

import java.util.Arrays;

public class NumberOfSubSeqTargetSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 6, 7};

    }


    public int numSubseq(int[] nums, int target) {
        Arrays.sort(num);

        int l = 0, r = nums.length - 1;
        int sum = nums[l];
        while (l <= r) {
            if (sum + nums[++l] <= target && l < r) {
                l = l + 1;
            } else {

            }
        }
    }
}
