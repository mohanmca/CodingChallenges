package leedcode.array;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0, 1, 2}, 0));
        System.out.println(threeSumClosest(new int[]{0, 2, 1, -3}, 1));
        System.out.println(threeSumClosest(new int[]{1, 2, 3, 4}, 11));
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0, delta = Integer.MIN_VALUE, closest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            sum = nums[i];
            for (int j = i + 1; j < (nums.length - 1); j++) {
                sum += nums[j];
                for (int k = j + 1; k < nums.length ; k++) {
                    sum += nums[k];
                    int newDelta = sum - target;

                    if (delta < 0 && newDelta < 0 && newDelta > delta) {
                        closest = sum;
                        delta = newDelta;
                    } else if (delta < 0 && newDelta > 0 && delta == Integer.MIN_VALUE) {
                        closest = sum;
                        delta = newDelta;
                    } else if (delta < 0 && newDelta > 0 && Math.abs(newDelta) < Math.abs(delta)) {
                        closest = sum;
                        delta = newDelta;
                    } else if (newDelta == 0) {
                        return sum;
                    } else if (newDelta > 0 && newDelta < delta) {
                        closest = sum;
                        delta = newDelta;
                    }
                    sum -= nums[k];
                }
                sum -= nums[j];
            }
        }
        return closest;
    }
}