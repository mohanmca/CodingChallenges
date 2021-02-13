package leedcode.integer;

import java.util.stream.IntStream;

public class SqrtOfx {

    public static void main(String[] args) {
        SqrtOfx sqrtOfX = new SqrtOfx();
        IntStream.range(1, 32000).forEach(i ->
                System.out.printf("x: %1$5s, x^2: %2$5s\n", i, sqrtOfX.mySqrtV1(i))
        );
        int i = Integer.MAX_VALUE;
        System.out.printf("x: %1$5s, x^2: %2$5s\n", i, sqrtOfX.mySqrtV1(i));
    }

    public int mySqrt(int x) {
        if (x < 2) return x;
        int leftOfRootOfX = (int) Math.pow(Math.E, 0.5 * Math.log(x));
        return Math.pow(leftOfRootOfX + 1, 2) == x ? leftOfRootOfX + 1 : leftOfRootOfX;
    }

    public int mySqrtV1(int x) {
        if (x < 2) return x;
        long num;
        int pivot, left = 2, right = x / 2;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = (long) pivot * pivot;
            if (num < x) left = pivot + 1;
            else if (num > x) right = pivot - 1;
            else return pivot;
        }
        return left-1;
    }
}
