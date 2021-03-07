package leedcode.integer;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindNUniqueInteger {

    public static void main(String[] args) {
        FindNUniqueInteger integer = new FindNUniqueInteger();
        int[] result = integer.sumZero(4);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.stream(result).reduce(0, Integer::sum));
        result = integer.sumZero(5);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.stream(result).reduce(0, Integer::sum));
        result = integer.sumZero(17);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.stream(result).reduce(0, Integer::sum));
        result = integer.sumZero(0);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.stream(result).reduce(0, Integer::sum));
    }

    public int[] sumZero(int n) {
        if (n == 1) {
            return new int[]{0};
        } else if (n % 2 == 0) {
            return IntStream.rangeClosed(1, n / 2)
                    .flatMap(i -> Arrays.stream(new int[]{i, i * -1}))
                    .toArray();
        }
        return IntStream.concat(Arrays.stream(sumZero(n-1 )), Arrays.stream(sumZero(1))).toArray();
    }
}
