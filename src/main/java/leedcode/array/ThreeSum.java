package leedcode.array;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ThreeSum {
    public static void main(String[] args) {
        Integer[] t = new Integer[0];
        printResult(threeSum(new int[]{-2, 0, 1, 1, 2}));
        printResult(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        printResult(threeSum(new int[]{0, 0, 0, 0}));
        printResult(threeSum(new int[]{-3, -2, -1, 0, 1, 2, 3}));
        printResult(threeSum(new int[]{-3, -2}));
    }

    private static void printResult(List<List<Integer>> t) {
        t.forEach(l -> System.out.println(Arrays.toString(l.toArray())));
        System.out.println("---");
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> lists = new HashSet<List<Integer>>();
        if (nums.length < 3) return new ArrayList<>(lists);
        Arrays.sort(nums);
        for (int j = nums.length - 1; j > 1 && nums[j] >= 0; j--) {
            int left = 0;
            int right = j - 1;
            int target = nums[j] * -1;
            while (left < right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    lists.add(Arrays.asList(nums[left], nums[right], nums[j]));
                    left++;
                    right--;
                }
            }

        }
        return new ArrayList<>(lists);
    }

}
