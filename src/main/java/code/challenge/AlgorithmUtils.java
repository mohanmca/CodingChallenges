package code.challenge;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

public class AlgorithmUtils {
    public static void main(String[] args) {
        AlgorithmUtils.printEquals(new Integer[]{1, 2, 4, 4}, new Integer[]{1, 2, 3, 4});
        printEquals(3, 3);
        printEquals(3, 4);
        AlgorithmUtils.printEquals("mohan", "nahom");
    }

    public static void printEquals(Integer amount, Integer amount3) {
        if (amount.equals(amount3)) {
            System.out.printf("Integer is equal :: %1$d\n", amount);
        } else {
            System.err.printf("X - Integer is un-equal :: %1$d\n", amount);
        }
    }

    public static <T, R> R printInvokeReturn(Function<T, R> fun, T input) {
        if (isArray(input)) {
            System.out.printf("%40s", Arrays.deepToString(Arrays.asList(input).toArray()));
        } else {
            System.out.print(input);
        }
        R output = fun.apply(input);
        if (isArray(output)) {
            System.out.printf("  :: %15s\n", Arrays.deepToString(Arrays.asList(output).toArray()));
        } else {
            System.out.printf("  :: %-15s\n ", output);
        }
        return output;
    }

    public static <T, U, R> R printInvokeReturn(BiFunction<T, U, R> fun, T input, U input2) {
        if (isArray(input)) {
            System.out.printf("%40s", Arrays.deepToString(Arrays.asList(input).toArray()));
        } else {
            System.out.print(input);
        }
        if (isArray(input2)) {
            System.out.printf("%40s", Arrays.deepToString(Arrays.asList(input2).toArray()));
        } else {
            System.out.print(input2);
        }
        R output = fun.apply(input, input2);
        if (isArray(output)) {
            System.out.printf("  :: %15s\n", Arrays.deepToString(Arrays.asList(output).toArray()));
        } else {
            System.out.printf("  :: %-15s\n ", output);
        }
        return output;
    }


    public static boolean isArray(Object obj) {
        return obj != null && obj.getClass().isArray();
    }


    public static void printEquals(Object[] items, Object[] items2) {
        if (items.length != items2.length) {
            System.out.printf("Obejcts are not equal size %1$2s - %2$2s\n", items.length, items2.length);
            return;
        }

        Arrays.sort(items);
        Arrays.sort(items2);

        OptionalInt unEqual = IntStream.rangeClosed(0, items.length - 1).filter(i -> !items[i].equals(items2[i])).findAny();


        if (unEqual.isEmpty()) {
            System.out.printf("Pair of Items[] are equal with length :: %1$s :: %2$d\n", Arrays.deepToString(items), items.length);
        } else {
            int misMatch = unEqual.getAsInt();
            System.err.printf("Element were not equal at position :: %1$d,  They differ by :: %2$s vs %3$s\n", misMatch, items[misMatch], items2[misMatch]);
        }
    }


    public static void printEquals(String first, String second) {
        if (first.equals(second)) {
            System.out.printf("String is equal :: %1$s\n", first);
        } else {
            System.err.printf("X - String is un-equal :: %1$s vs %2$s\n", first, second);
        }
    }

    public static String reverse(String s) {
        char[] text = s.toCharArray();
        for (int i = 0; i < text.length / 2; i++) {
            char temp = text[(text.length - 1) - i];
            text[(text.length - 1) - i] = text[i];
            text[i] = temp;
        }
        return new String(text);
    }

}
