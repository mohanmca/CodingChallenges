package leedcode;

import java.util.Arrays;
import java.util.stream.IntStream;

class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 2};
        int length = removeDuplicates(nums);
        printNums(nums, length);
        nums = new int[]{1, 1, 1, 1, 2};
        length = removeDuplicates(nums);
        printNums(nums, length);
    }

    public static void printNums(int[] nums, int length) {
        System.out.println(length);
        IntStream.rangeClosed(0, length - 1).forEach(i -> System.out.print(nums[i] + ","));
        System.out.println("-");
    }

    public static int removeDuplicates(int[] nums) {
        int N = nums.length;
        if (N < 2) return N;
        int tp = 0, lp = 0, count = 1;
        while (++lp < N) {
            if (nums[lp] != nums[tp]) {
                nums[++tp] = nums[lp];
                count++;
            }
        }
        return count;
    }
}