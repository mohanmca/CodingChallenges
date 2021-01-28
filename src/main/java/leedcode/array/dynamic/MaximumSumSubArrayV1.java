package leedcode.array.dynamic;

public class MaximumSumSubArrayV1 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(findMaxSumSubArrayUsingKadaneAlgorith(nums));
        nums = new int[]{1, 2, 3, -5};
        System.out.println(findMaxSumSubArrayUsingKadaneAlgorith(nums));
        nums = new int[]{-10000};
        System.out.println(findMaxSumSubArrayUsingKadaneAlgorith(nums));
        nums = new int[]{1};
        System.out.println(findMaxSumSubArrayUsingKadaneAlgorith(nums));
        nums = new int[]{0};
        System.out.println(findMaxSumSubArrayUsingKadaneAlgorith(nums));
        nums = new int[]{-1};
        System.out.println(findMaxSumSubArrayUsingKadaneAlgorith(nums));
    }

    public static int findMaxSumSubArrayUsingKadaneAlgorith(int[] nums) {
        int current_sum = 0;
        int best_max = Integer.MIN_VALUE;
        for (int num : nums) {
            current_sum = Math.max(num, current_sum + num);
            best_max = Math.max(current_sum, best_max);
        }
        return best_max;
    }


}
