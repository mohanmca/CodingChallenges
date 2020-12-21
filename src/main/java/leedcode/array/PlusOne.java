package leedcode.array;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] > 0)
                return digits;
        }

        if (digits[0] == 0) {
            int[] results = new int[digits.length + 1];
            for (int j = 0; j < digits.length; j++) {
                results[j + 1] = digits[j];
            }
            results[0] = 1;
            return results;
        }
        return digits;
    }
}
