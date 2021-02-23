package leedcode.recursion;

import java.util.*;

public class PermutationOfString {


    PermutationOfString() {
    }

    public static void main(String[] args) {
        PermutationOfString solution = new PermutationOfString();
        solution.permutate("abc").forEach(System.out::println);
    }

    private List<String> permutate(String text) {
        List<String> output = new LinkedList<>();
        if (text == null || text.length() == 0) return Collections.emptyList();
        permutate("", text, output);
        return output;
    }

    private void permutate(String combination, String text, List<String> output) {
        if (text.length() == 0) {
            output.add(combination);
            return;
        }
        for (int i = 0; i < text.length(); i++) {
            permutate(combination + text.charAt(i), deleteCharAt(text, i), output);
        }
    }

    private String deleteCharAt(String text, int pos) {
        StringBuilder sb = new StringBuilder(text);
        sb.deleteCharAt(pos);
        return sb.toString();
    }

}
