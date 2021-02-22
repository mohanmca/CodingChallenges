package leedcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubsetsUsingBackTracking {

    List<List<Integer>> output = new ArrayList();
    int n, k;

    public static void main(String[] args) {
        SubsetsUsingBackTracking solution = new SubsetsUsingBackTracking();
        solution.subsets(new int[]{1, 2, 3}).forEach(l -> System.out.println(Arrays.deepToString(l.toArray())));
    }

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k)
            output.add(new ArrayList(curr));

        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        //k = 2;  and remove below loop, to generate NC2
        for (k = 0; k <= n; k++) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }
}
