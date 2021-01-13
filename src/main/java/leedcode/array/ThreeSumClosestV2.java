package leedcode.array;

import java.util.Arrays;

public class ThreeSumClosestV2 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0, 2, 1, -3}, 1));
        System.out.println(threeSumClosest(new int[]{1, 2, 3, 4}, 11));
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int sum = 0, delta = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {

            if (i == 0) {
                sum = sum + nums[i] + nums[i + 1] + nums[i + 2];
            } else {
                sum = sum - nums[i - 1] + nums[i + 2];
            }

            if (sum - target == 0) {
                return 0;
            } else if (Math.abs(sum - target) < Math.abs(delta)) {
                delta = sum - target;
            } else {
                return sum + nums[i - 1] - nums[i + 2];
            }
        }
        return sum;
    }
}
