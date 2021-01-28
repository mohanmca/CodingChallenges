package leedcode.array;

import java.util.Arrays;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 1};
        System.out.println(findDuplicate(nums));
        nums = new int[]{1, 2, 3, 4, 3};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i = i + 2) {
            if (nums[i - 1] == nums[i] || nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[0];
    }
}
