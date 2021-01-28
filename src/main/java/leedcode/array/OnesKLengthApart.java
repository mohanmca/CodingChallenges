package leedcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class OnesKLengthApart {
    public static void main(String[] args) {
        System.out.println(kLengthApart(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2));
        System.out.println(kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2));
        System.out.println(kLengthApart(new int[]{1, 1, 1, 1, 1}, 0));
        System.out.println(kLengthApart(new int[]{0, 1, 0, 1}, 1));
        System.out.println(kLengthApart(new int[]{0, 0, 0, 0}, 2));
    }

    public static boolean kLengthApart(int[] nums, int k) {
        //first one could appear anywhere, hence start as if count satisfies
        int count = k;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else if (nums[i] == 1 && count >= k) {
                count = 0;
            } else {
                return false;
            }
        }
        return true;
    }

}
