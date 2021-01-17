package general;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://stackoverflow.com/questions/8375452/how-to-loop-through-all-the-combinations-of-e-g-48-choose-5
 */
public class NChooseK {
    public static void main(String[] args) {
        final int n = 10;
        final int r = 3;
        int[] current = IntStream.range(0, 3).toArray();
//        int[] nums = IntStream.range(1, 10).toArray();
        System.out.println(Arrays.toString(current));
        int count = 0;
        while (++count < 1000) {
            /**
             * Example:  10C3
             * We should think two invariants of the combination before learning this code.
             *
             * Invariant-1 for the last element
             * current[0] will never reach more than 7
             * current[1] will never reach more than 8
             * current[2] will never reach more than 9
             * (position-length) will grow inversly proportional [0-2+9, 1-2+9, 2-2+9]
             * (position-length) will grow inversly proportional [7, 8, 9]
             *
             * Invariant-2 find successive elements index
             * current[0] is 1, current[1] will be higher than current[0]
             * current[2] will be higher than current[1], current[j] = current[i]+ (j-i)
             * Here j-i is the distance between j and i indices (j>i) always
             *
             * i-th position value should be from i to n
             * if i<j, j-th-position-value should, distance between j and i |(j-i)| + i-th position-value
             * 121..129, 134..139,
             *
             */
            for (int i = r - 1; i >= 0; i--) {
                if (current[i] < n - r + i) {
                    current[i]++;
                    for (int j = i + 1; j < r; j++) {
                        current[j] = current[i] + j - i;
                    }
                    System.out.println(Arrays.toString(current));
                }
            }
        }

    }
}
