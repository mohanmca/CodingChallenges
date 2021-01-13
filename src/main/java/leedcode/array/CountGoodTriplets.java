package leedcode.array;

import java.util.Arrays;

public class CountGoodTriplets {
    public static void main(String[] args) {
        System.out.println(countGoodTriplets(new int[]{7, 3, 7, 3, 12, 1, 12, 2, 3}, 5, 8, 1));
//        System.out.println(countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3));
    }

    public static int countGoodTriplets(int[] nums, int a, int b, int c) {
        int count = 0;
        for (int k = (nums.length - 1); k >= 2; k--) {
            for (int j = k - 1; j >= 1; j--) {
                if (Math.abs(nums[k] - nums[j]) <= b) {
                    for (int i = j - 1; i >= 0; i--) {
                        if (Math.abs(nums[i] - nums[j]) <= a && Math.abs(nums[i] - nums[k]) <= c)
                            count++;
                    }
                }
            }
        }
        return count;
    }

//    public static int countGoodTriplets(int[] nums, int a, int b, int c) {
//        int count = 0;
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                if (Math.abs(nums[i] - nums[j]) <= a)
//                    for (int k = j + 1; k < nums.length; k++) {
//                        if (Math.abs(nums[j] - nums[k]) <= b && Math.abs(nums[k] - nums[i]) <= c)
//                            count++;
//                    }
//            }
//        }
//        return count;
//    }

//    public int countGoodTriplets(int[] nums, int a, int b, int c) {
//        int count = 0;
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length - 1 && Math.abs(nums[i] - nums[j]) <= a; j++) {
//                for (int k = j + 1; k < nums.length
//                        && Math.abs(nums[j] - nums[k]) <= b
//                        && Math.abs(nums[i] - nums[k]) <= c
//                        ; k++
//                ) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
}
