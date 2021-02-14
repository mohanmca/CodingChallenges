package leedcode.integer;

import java.util.stream.IntStream;

public class ReduceANumberToZero {
    public static void main(String[] args) {
        ReduceANumberToZero reducer = new ReduceANumberToZero();
        IntStream.range(1, 124).forEach(i -> System.out.printf("%1$2d, %2$2d\n", i, reducer.numberOfSteps(i)));
    }

    public int numberOfSteps(int num) {
        if (num <= 2) return num;
        int count = 0;
        while (num != 0) {
            count++;
            if (num % 2 == 0)
                num = num / 2;
            else
                num -= 1;
        }
        return count;
    }
}
