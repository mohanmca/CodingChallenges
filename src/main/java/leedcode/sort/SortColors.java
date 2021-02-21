package leedcode.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortColors {

    private final int numberOfColors;

    public SortColors(int N) {
        this.numberOfColors = N;
    }

    public static void main(String[] args) {
        SortColors solution = new SortColors(3);
        int[] nums = solution.sortColors(new int[]{2, 0, 2, 1, 1, 0});
        System.out.println(Arrays.toString(nums));
        nums = solution.sortColors(new int[]{1, 2, 0});
        System.out.println(Arrays.toString(nums));
        nums = solution.sortColors(new int[]{0});
        System.out.println(Arrays.toString(nums));
        nums = solution.sortColors(new int[]{2, 0, 1});
        System.out.println(Arrays.toString(nums));
        nums = solution.sortColors(new int[]{1});
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Considering we have just 3 element, we can place all 0 in the initial places
     * Place others in middle.., similarly place all 2s at the end and others in middle.
     *
     * @param nums
     * @return
     */
    public int[] sortColors(int[] nums) {
        if (nums.length <= 1) return nums;
        int curr = 0, l = 0, r = nums.length - 1;
        while (curr <= r) {
            if (nums[curr] == 0) {
                swap(nums, l++, curr++);
            } else if (nums[curr] == 2) {
                swap(nums, r--, curr);
            } else curr++;

        }
        return nums;
    }

    public void swap(int[] nums, int j, int k) {
        int temp = nums[j];
        nums[j] = nums[k];
        nums[k] = temp;
    }

    public int[] sortColorsV1(int[] nums) {
        if (nums.length <= 1) return nums;
        Map<Integer, Integer> counter = new HashMap<>();
        Arrays.stream(nums).forEach(i -> counter.put(i, counter.getOrDefault(i, 0) + 1));
        int j = 0;
        int i = 0;
        while (j < numberOfColors) {
            while (counter.getOrDefault(j, 0) > 0) {
                nums[i++] = j;
                counter.put(j, counter.getOrDefault(j, 0) - 1);
            }
            j++;
        }

        return nums;
    }
}
