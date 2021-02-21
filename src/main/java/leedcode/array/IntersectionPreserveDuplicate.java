package leedcode.array;

import java.util.*;

public class IntersectionPreserveDuplicate {
    public static void main(String[] args) {
        IntersectionPreserveDuplicate solution = new IntersectionPreserveDuplicate();
        System.out.println(Arrays.toString(solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(solution.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(solution.intersect(new int[]{4, 9, 5}, new int[]{1})));
        System.out.println(Arrays.toString(solution.intersect(new int[]{3, 1, 2}, new int[]{1, 1})));
        System.out.println(Arrays.toString(solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2})));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }


    public int[] intersectV1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> numFrequency = new TreeMap<>();

        Arrays.stream(nums1).forEach(
                num -> numFrequency.put(num, numFrequency.getOrDefault(num, 0) + 1)
        );

        List<Integer> intersection = new LinkedList<>();
        for (Integer num : nums2) {
            if (numFrequency.getOrDefault(num, 0) > 0) {
                intersection.add(num);
                numFrequency.put(num, numFrequency.getOrDefault(num, 0) - 1);
            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}
