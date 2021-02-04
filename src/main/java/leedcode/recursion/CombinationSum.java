package leedcode.recursion;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        System.out.println(Arrays.deepToString(combinationSum(nums, 7).toArray()));
        int[] nums2 = {2, 3, 5};
        System.out.println(Arrays.deepToString(combinationSum(nums2, 8).toArray()));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i < candidates.length; i++) {
            numbers.put(candidates[i], i);
        }
        List<List<Integer>> combinations = new ArrayList<>();
        for (int num = candidates.length - 1; num >= 0; num--) {
            if (target == candidates[num]) {
                combinations.add(Collections.singletonList(candidates[num]));
            }
            int quotient = target / candidates[num];
            int reminder = target % candidates[num];
            if (reminder > 0 && numbers.getOrDefault(reminder, -1) < num && numbers.getOrDefault(reminder, -1) != -1) {
                ArrayList<Integer> partition = fillNumbers(candidates[num], quotient);
                partition.add(reminder);
                combinations.add(partition);
            } else if (reminder > 0
                    && reminder + candidates[num] != target
                    && numbers.getOrDefault(reminder + candidates[num], -1) < -1) {
                ArrayList<Integer> partition = fillNumbers(candidates[num], quotient - 1);
                partition.add(reminder + candidates[num]);
                combinations.add(partition);
            } else if (reminder == 0 && quotient > 1) {
                ArrayList<Integer> partition = fillNumbers(candidates[num], quotient);
                combinations.add(partition);
            }
        }
        return combinations;
    }

    private static ArrayList<Integer> fillNumbers(int num, int count) {
        ArrayList<Integer> partition = new ArrayList<>(count);
        for (int i = 0; i < count; i++)
            partition.add(num);
        return partition;
    }
}
