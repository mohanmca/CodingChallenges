package leedcode.array;

import java.util.Arrays;

public class GetMaximum {
    public static void main(String[] args) {
        System.out.println(getMaximum(5));
        System.out.println(getMaximum(15));
//        System.out.println(getMaximum(100));
//        System.out.println(getMaximum(64));
    }

    public static int getMaximum(int n) {
        if (n <= 1) return n;
        int[] vals = new int[n + 1];
        vals[0] = 0;
        vals[1] = 1;
        int max = 1;
        for (int i = 2; i < n + 1; i++) {
            if (i % 2 == 0) {
                vals[i] = vals[i / 2];
            } else {
                vals[i] = vals[i / 2] + vals[1 + (i / 2)];
            }
            max = Math.max(max, vals[i]);
        }
        return max;
    }
}
