package general;

import java.util.*;

public class Subsets {
    public static List<List<Integer>> findSubsets(int[] nums) {
        if (nums.length == 1) {
            return Arrays.asList(Collections.emptyList(), Collections.singletonList(nums[0]));
        }
        List<List<Integer>> subSets = new LinkedList<>();
        for (int i = 1; i < nums.length; i++) {
            int finalI = i;
            int[] curr_nums  = Arrays.stream(nums).filter(j -> j != nums[finalI]).toArray();

            subSets.addAll(findSubsets(curr_nums));
        }
        List<List<Integer>> subSets2 = new ArrayList<>(subSets.size());
        for (List<Integer> l : subSets) {
            List<Integer> newOne = clone(l);
            newOne.add(nums[0]);
            subSets2.add(newOne);
        }
        subSets.addAll(subSets2);
        return subSets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets2(new int[]{1, 2, 3});
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets2(new int[]{1, 5, 3});

        System.out.println("Here is the list of subsets: " + result);
    }

    public static List<List<Integer>> findSubsets2(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // start by adding the empty subset
        subsets.add(new ArrayList<>());
        for (int currentNumber : nums) {
            // we will take all existing subsets and insert the current number in them to create new subsets
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                // create a new subset from the existing subset and insert the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }
        }
        return subsets;
    }

    private static List<Integer> clone(List<Integer> source) {
        List<Integer> target = new ArrayList<>(source.size());
        target.addAll(source);
        return target;
    }
}
