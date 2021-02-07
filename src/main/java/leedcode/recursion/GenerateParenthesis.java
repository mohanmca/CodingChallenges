package leedcode.recursion;

import java.util.*;
import java.util.stream.IntStream;

/**
 *  TODO : https://www.geeksforgeeks.org/number-of-ways-a-convex-polygon-of-n2-sides-can-split-into-triangles-by-connecting-vertices/
 *  1 - Catalan numbers
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
//        int i = 1;
//        generateParenthesis(i++);//.forEach(System.out::println);
        IntStream.range(1,10)
                .mapToObj(GenerateParenthesis::generateParenthesis)
                .map(accumulator -> " :: number of size +  " + accumulator.size())
                .forEach(System.out::println);

        System.out.println();

    }

    public static List<String> generateParenthesis(int n) {
        List<String> accumulator = new ArrayList<>(-1 + (int) Math.pow(2, n));
        generate(accumulator, "", 0, 0, n);
        return accumulator;
    }

    public static void generate(List<String> accumulator, String current, int open, int close, int max) {
        if (current.length() / 2 == max) {
            accumulator.add(current);
            return;
        }
        if (open < max)
            generate(accumulator, current + "(", open + 1, close, max);
        if (close < open)
            generate(accumulator, current + ")", open, close + 1, max);
    }

}


