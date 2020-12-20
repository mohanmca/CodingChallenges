package educative;

import java.util.Arrays;

public class AvgContiniguousSubArrayBruteForce {

    public static void main(String[] args) {
        var nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(movingAvgSum(nums, 3));
    }

    public static int movingAvgSum(int[] nums, int k) {
        int total = 0;
        int count = 0;
        for (int i = 0; i < nums.length - (k - 1); i++) {
            int sum = 0;
            count++;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            total += sum;
        }
        return total / count;
    }
}
