package leedcode.set;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SetMismatch {

    public static void main(String[] args) {
        SetMismatch solution = new SetMismatch();
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{5, 5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{5, 4, 3, 2, 1, 1})));
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{3, 2, 3, 4, 6, 5})));
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{2, 2})));
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{3, 2, 2})));
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{1, 1})));
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{1, 2, 2, 3, 4})));
    }

    public int[] findErrorNums(int[] nums) {
        final int DUPLICATE = 0;
        final int MISSING = 1;

        Map<Integer, List<Integer>> frequency = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity()));
        int[] setSize = new int[2];
        for (int i = 1; i < nums.length + 1; i++) {
            if (frequency.getOrDefault(i, Collections.emptyList()).size() == 0) {
                setSize[MISSING] = i;
            } else if (frequency.getOrDefault(i, Collections.emptyList()).size() == 2) {
                setSize[DUPLICATE] = i;
            }
        }
        return setSize;
    }
}
