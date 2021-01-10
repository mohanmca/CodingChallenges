package leedcode.array;

import java.util.Arrays;

public class SubArratSumEqualsKV2 {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySum(new int[]{1, 2, 1, 2, 1}, 3));
    }

    public static int subarraySum(int[] nums, int k) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return subarraySum(nums, k, 0, nums.length - 1);
    }

    public static int subarraySum(int[] nums, int k, int low, int high) {
        if (low > high) return 0;

        if (nums[high] - k == 0) {
            return 1 + subarraySum(nums, k, low, high - 1);
        } else if (nums[low] - k == 0) {
            return 1 + subarraySum(nums, k, low+1, high);
        } else if (nums[high] - k > 0) {
            return subarraySum(nums, k, low, high - 1);
        } else if (nums[high] - k < 0) {
            return subarraySum(nums, k - nums[high], low, high - 1);
        } else if (nums[low] - k < 0) {
            return subarraySum(nums, k - nums[low], low + 1, high);
        } else if (nums[low] - k > 0) {
            return 0;
        }
        return 1 + subarraySum(nums, k, low + 1, high)
                + subarraySum(nums, k, low, high - 1);
    }


}
