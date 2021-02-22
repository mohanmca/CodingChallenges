package leedcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Subsets {


    public static void main(String[] args) {
        Subsets solution = new Subsets();
        solution.subsets(new int[]{1, 2, 3}).forEach(l -> System.out.println(Arrays.deepToString(l.toArray())));
//        solution.subsets(new int[]{1}).forEach(l -> System.out.println(Arrays.deepToString(l.toArray())));
//        solution.subsets(new int[]{}).forEach(l -> System.out.println(Arrays.deepToString(l.toArray())));
    }

    /**
     * It is using BinaryCounter technique, every element is added once, and removed once to create subset
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsV1(int[] nums) {
        if (nums.length == 0) {
            List<Integer> empty = new ArrayList<Integer>();
            List<List<Integer>> container = new ArrayList<List<Integer>>();
            container.add(empty);
            return container;
        }
        List<List<Integer>> result = subsets(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> result2 = result.stream().map(this::clone).collect(Collectors.toList());
        for (List<Integer> subset : result2) {
            subset.add(nums[0]);
        }
        result.addAll(result2);
        return result;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        output.add(new ArrayList<Integer>());

        for (Integer num : nums) {
            List<List<Integer>> subsets = new ArrayList<List<Integer>>();
            for (List<Integer> container : output) {
                subsets.add(new ArrayList<>(container) {{
                    add(num);
                }});
            }
            output.addAll(subsets);
        }
        return output;
    }


    private List<Integer> clone(List<Integer> list) {
        List<Integer> copy = new ArrayList<>(list.size());
        copy.addAll(list);
        return copy;
    }

}
