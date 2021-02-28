package leedcode.array.easy;

import java.util.Arrays;

public class ShuffleArray {
    public static void main(String[] args) {
        ShuffleArray solution = new ShuffleArray();
        System.out.println(Arrays.toString(solution.shuffle(new int[]{1, 2, 3, 4}, 2)));
    }

    public int[] shuffle(int[] nums, int n) {
        for (int i = 1; i < n/2+1; i = i + 2) {
            int tmp = nums[i];
            nums[i] = nums[i + n];
            nums[i + n] = tmp;
        }
        return nums;
    }

}
