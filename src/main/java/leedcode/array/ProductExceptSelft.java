package leedcode.array;

import java.util.Arrays;

public class ProductExceptSelft {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 0})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{0})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{2})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] digits = new int[nums.length];
        int product = 1;
        int numberOfZero = 0;
        for (int num : nums) {
            if (num != 0)
                product *= num;
            else if (numberOfZero++ == 2) {
                product = 0;
                break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && numberOfZero > 0)
                digits[i] = 0;
            else if (nums[i] == 0)
                digits[i] = product;
            else
                digits[i] = product / nums[i];
        }
        return digits;
    }

}
