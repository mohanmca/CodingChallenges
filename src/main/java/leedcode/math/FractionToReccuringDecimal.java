package leedcode.math;

import java.util.*;
import java.util.stream.Stream;

public class FractionToReccuringDecimal {
    public static void main(String[] args) {
        FractionToReccuringDecimal solution = new FractionToReccuringDecimal();
        List<Integer> numbers = Arrays.asList(1, 2, 5, 3, 4);
        Object[] values = numbers.stream().flatMap(n -> numbers.stream()
                .map(i -> Arrays.asList(n, i, solution.fractionToDecimal(n, i)))).toArray();
        Arrays.stream(values).forEach(System.out::println);

    }

    public String fractionToDecimal(int n, int d) {
        StringBuilder sb = new StringBuilder();
        if (n < d) {
            sb.append(0);
        }
        Map<Integer, Integer> repeat = new HashMap<Integer, Integer>();
        boolean decimalPoint = false;
        while (n != 0 && !repeat.containsKey(n)) {
            final int inputN = n;
            if (n < d) {
                if (!decimalPoint) {
                    sb.append(".");
                    decimalPoint = true;
                    n = n * 10;
                } else {
                    n *= 10;
                }
                while (n < d) {
                    n = n * 10;
                    sb.append(0);
                }
            }
            int q = n / d;
            sb.append(q);
            repeat.put(inputN, q);
            n = n - d * q;
        }

        if (sb.indexOf(".") != -1 && repeat.containsKey(n)) {
            String value = repeat.get(n) + "";
            int lastIndex = sb.lastIndexOf(value);
            String result = sb.toString();
            return result.substring(0, lastIndex) + "(" + value + ")";
        }

        return sb.toString();
    }
}
