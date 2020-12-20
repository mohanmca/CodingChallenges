package leedcode.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RotateArray {
    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6}, 3);
        Arrays.stream(new int[][]{
//                new int[]{},
//                new int[]{1},
//                new int[]{1, 2},
//                new int[]{1, 2, 3},
//                new int[]{1, 2, 3, 4},
//                new int[]{1, 2, 3, 4, 5},
                new int[]{1, 2, 3, 4, 5, 6},
        }).forEach(nums -> {
            Arrays.stream(nums).forEach(k -> {
                int[] numsCp = nums;
                rotate(numsCp, k);
                printNums(numsCp);
            });
        });
    }

    public static void printNums(int[] nums) {
        IntStream.range(0, nums.length).forEach(i -> System.out.print(nums[i] + ","));
        System.out.println("-");
    }


    public static void rotate(int[] nums, int k) {
        if (nums.length < 1) return;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[0];
            for (int src = 0; src < n; src++) {
                int target = (src + 1) % n;
                int newTemp = nums[target];
                nums[target] = temp;
                temp = newTemp;
            }
        }
    }


    public static void oldRotate(int[] nums, int k) {
        if (nums.length < 1) return;
        int n = nums.length;
        int i = 0, j = 0, count = 0, temp = nums[i];
        while (count < nums.length) {
            j = (i + k) % n;
            int newTemp = nums[j];
            nums[j] = temp;
            temp = newTemp;
            i = j;
            count++;
            if (n % 2 == 0 && count == n / 2 && k % 2 == 0) {
                i = i + 1;
                temp = nums[i];
            }
        }
    }


}
