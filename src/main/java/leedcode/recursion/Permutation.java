package leedcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Permutation {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(permute(new int[]{1, 2, 3}).toArray()));
        System.out.println(Arrays.deepToString(permute(new int[]{1}).toArray()));
        System.out.println(Arrays.deepToString(permute(new int[]{}).toArray()));
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        } else if (nums.length == 1) {
            ArrayList<Integer> items = new ArrayList<Integer>(1);
            items.add(nums[0]);
            ArrayList<List<Integer>> itemsOfItems = new ArrayList<List<Integer>>(1);
            itemsOfItems.add(items);
            return itemsOfItems;
        } else {
            ArrayList<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int finalI = i;
                int[] rest = IntStream.range(0, nums.length).filter(j -> j != finalI).map(j -> nums[j]).toArray();
                List<List<Integer>> tmpResult = permute(rest);
                tmpResult.forEach(items -> items.add(nums[finalI]));
                result.addAll(tmpResult);
            }
            return result;
        }
    }
}
