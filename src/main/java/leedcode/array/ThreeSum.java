package leedcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Integer[] t = new Integer[0];
        threeSum(new int[]{-1, 0, 1, 2, -1, -4}).forEach(l -> System.out.println(Arrays.toString(l.toArray(t))));
        //threeSum(new int[]{-3, -2, -1, 0, 1, 2, 3}).forEach(l -> System.out.println(Arrays.toString(l.toArray(t))));
        //threeSum(new int[]{-3, -2}).forEach(l -> System.out.println(Arrays.toString(l.toArray(t))));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) return lists;
        Arrays.sort(nums);
        for (int j = nums.length - 1; j > 1; j--) {
            int i = 0;
            while (nums[i] + nums[i + 1] + nums[j] <= 0 && i < j - 1) {
                if (nums[i] + nums[i + 1] + nums[j] == 0) {
                    lists.add(Arrays.asList(nums[i], nums[i + 1], nums[j]));
                }
                i++;
            }
        }
        return lists;
    }

}
