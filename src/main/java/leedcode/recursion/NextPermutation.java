package leedcode.recursion;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation solution = new NextPermutation();
        int[] nums = new int[]{4, 2, 0, 2, 3, 2, 0};
        System.out.print(Arrays.toString(nums));
        solution.nextPermutation(nums);
        System.out.print(Arrays.toString(nums) + "\n");
        nums = new int[]{1, 3, 2};
        System.out.print(Arrays.toString(nums));
        solution.nextPermutation(nums);
        System.out.print(Arrays.toString(nums) + "\n");
        nums = new int[]{2, 3, 1};
        solution.nextPermutation(nums);
        System.out.print(Arrays.toString(nums));
        solution.nextPermutation(nums);
        System.out.print(Arrays.toString(nums) + "\n");
        nums = new int[]{5, 4, 7, 5, 3, 2};
        System.out.print(Arrays.toString(nums));
        solution.nextPermutation(nums);
        System.out.print(Arrays.toString(nums) + "\n");
        nums = new int[]{1, 1, 2};
        System.out.print(Arrays.toString(nums));
        solution.nextPermutation(nums);
        System.out.print(Arrays.toString(nums) + "\n");
        nums = new int[]{3, 1, 2};
        System.out.print(Arrays.toString(nums));
        solution.nextPermutation(nums);
        System.out.print(Arrays.toString(nums) + "\n");
        nums = new int[]{3, 2, 1};
        System.out.print(Arrays.toString(nums));
        solution.nextPermutation(nums);
        System.out.print(Arrays.toString(nums) + "\n");
    }

    public void nextPermutation(int[] nums) {
        int j = nums.length - 2;
        while (j >= 0 && nums[j] >= nums[j + 1])
            j--;
        if (j >= 0) {
            int i = nums.length - 1;
            while (i >= 0 && nums[i] <= nums[j]) {
                i--;
            }
            swap(nums, i, j);
        }
        reverse(nums, j + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int first, int last) {
        while (first < last) {
            swap(nums, first++, last--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
