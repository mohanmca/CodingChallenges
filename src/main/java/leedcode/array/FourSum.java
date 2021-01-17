package leedcode.array;

import java.util.*;

public class FourSum {

    public static void main(String[] args) {
        System.out.printf(Arrays.deepToString(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0).toArray()));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    int remaining = target - (nums[i] + nums[j] + nums[k]);
                    int index = Arrays.binarySearch(nums, k+1, nums.length, remaining);
                    if (index >= 0)
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[index]));

                }
            }
        }
        return new ArrayList<>(result);
    }

}
