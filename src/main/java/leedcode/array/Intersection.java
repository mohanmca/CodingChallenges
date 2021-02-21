package leedcode.array;

import java.util.*;

public class Intersection {
    public static void main(String[] args) {
        Intersection solution = new Intersection();
        System.out.println(Arrays.toString(solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(solution.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(solution.intersection(new int[]{4, 9, 5}, new int[]{1})));

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet = new HashSet<>();
        List<Integer> intersection = new LinkedList<>();
        Arrays.stream(nums1).forEach(numSet::add);
        for (Integer num : nums2) {
            if (numSet.contains(num)) {
                intersection.add(num);
                numSet.remove(num);
            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}
