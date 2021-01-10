package leedcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParent {


    public static void main(String[] args) {
        System.out.println(isValid(""));
        System.out.println(isValid("{}"));
        System.out.println(isValid("}}}"));
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

    public static boolean isOpen(char c) {
        return c == '{' || c == '[' || c == '(';
    }

    public static char findOpen(char c) {
        switch (c) {
            case '}':
                return '{';
            case ')':
                return '(';
            case ']':
                return '[';
        }
        throw new IllegalStateException("not possible");
    }


    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stackMatcher = new Stack<>();
        for (char aChar : chars) {
            if (isOpen(aChar))
                stackMatcher.push(aChar);
            else {
                char open = findOpen(aChar);
                if (stackMatcher.isEmpty() || stackMatcher.pop() != open) {
                    return false;
                }
            }
        }
        return stackMatcher.isEmpty();
    }


}
