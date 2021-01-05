package leedcode.array;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sequence_sum = (n * (n + 1)) / 2;
        int total = Arrays.stream(nums).sum();
        return sequence_sum - total;
    }
}
