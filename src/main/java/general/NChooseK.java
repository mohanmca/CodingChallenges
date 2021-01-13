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
             * i-th position value should be from i to n
             * if i<j, j-th-position-value should, distance between j and i |(j-i)| + i-th position-value
             * 121..129, 134..139,
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
