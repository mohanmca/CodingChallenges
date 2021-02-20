package leedcode.string;

import java.util.Stack;

public class MinRemoveToMakeValid {
    public static void main(String[] args) {
        MinRemoveToMakeValid solution = new MinRemoveToMakeValid();

        System.out.println(solution.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(solution.minRemoveToMakeValid("((lee(t(c)o)de)"));
        System.out.println(solution.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(solution.minRemoveToMakeValid("))(("));
    }

    public String minRemoveToMakeValid(String input) {
        Stack<Integer> stack = new Stack<Integer>();
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                if (stack.isEmpty()) {
                    chars[i] = '~';
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty())
            chars[stack.pop()] = '~';
        return new String(chars).replaceAll("~", "");
    }
}
