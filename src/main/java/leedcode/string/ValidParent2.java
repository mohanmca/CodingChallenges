package leedcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParent2 {


    public static void main(String[] args) {
//        System.out.println(isValid(""));
//        System.out.println(isValid("{}"));
//        System.out.println(isValid("}}}"));
        System.out.println(isValid("[({])}"));
        System.out.println(isValid("[])"));
        System.out.println(isValid("({}"));
        System.out.println(isValid("{([])}"));
    }

    public static char getCounterChar(char input) {
        switch (input) {
            case '{':
                return '}';
            case '(':
                return ')';
            case '[':
                return ']';
        }
        throw new IllegalStateException("InvalidState");
    }

    public static boolean isValid(String s) {
        Map<Character, Integer> mapChar = new HashMap<Character, Integer>();
        Map<Character, Stack<Integer>> mapCharIndex = new HashMap<Character, Stack<Integer>>();
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '}' || chars[i] == ']' | chars[i] == ')') {
                int newValue = mapChar.compute(chars[i], (k, v) -> {
                    if (v == null)
                        return -1;
                    else
                        return v - 1;
                });
                if (Math.abs(newValue) > i) {
                    System.out.println("Failed at :: " + i + ", " + chars[i]);
                    return false;
                }
                mapCharIndex.putIfAbsent(chars[i], new Stack<>());
                mapCharIndex.get(chars[i]).push(i);
            } else {
                int newValue = mapChar.compute(getCounterChar(chars[i]), (k, v) -> {
                    if (v == null)
                        return 1;
                    else
                        return v + 1;
                });
                if (newValue > 0) {
                    System.out.println("Failed at :: " + i + ", " + chars[i]);
                    return false;
                }
                if (mapCharIndex.get(getCounterChar(chars[i])) == null ||
                        mapCharIndex.get(getCounterChar(chars[i])).isEmpty() ||
                        ((mapCharIndex.get(getCounterChar(chars[i])).pop() & 1) == (i & 1))) {
                    System.out.println("Failed due to index at :: " + i + ", " + chars[i]);
                    return false;

                }
            }
        }
        return mapChar.entrySet().stream().noneMatch((kv) -> Math.abs(kv.getValue()) > 0);
    }


}
