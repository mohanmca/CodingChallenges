package leedcode.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MajorityElement2V2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};
        System.out.println(Arrays.toString(majorityElement(nums).toArray()));
        int[] nums2 = new int[]{1};
        System.out.println(Arrays.toString(majorityElement(nums2).toArray()));
        int[] nums3 = new int[]{1, 2};
        System.out.println(Arrays.toString(majorityElement(nums3).toArray()));
    }

    public static List<Integer> majorityElement(int[] nums) {
        int majority = nums.length / 3;
        HashMap<Integer, Integer> frequency = new HashMap<>(majority);
        List<Integer> result = new ArrayList<>(majority);
        for (int num : nums) {
            int count = frequency.getOrDefault(num, 0) + 1;
            frequency.put(num, count);
            //Below condition will trigger only once
            if (count == majority+1) {
                result.add(num);
            }
        }
        return result;
    }
}
