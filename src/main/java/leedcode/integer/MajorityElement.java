package leedcode.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Boyer-Moore Voting Algorithm - Streaming Algorithm - element that has more than n/2
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};
        System.out.println(majorityElement(nums));
        int[] nums2 = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums2));
        int[] nums3 = new int[]{3,2,3};
        System.out.println(majorityElement(nums3));
    }

    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (candidate == num) {
                count++;
            } else {
                count--;
                //if we selecte the candidate element here when count==0, it is wrong
                //If current element cancelled the cumulative sum, next element should be the next candidate
            }
        }
        return candidate;
    }
}
