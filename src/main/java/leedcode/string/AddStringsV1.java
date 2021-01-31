package leedcode.string;

import java.util.Stack;

public class AddStringsV1 {
    public static void main(String[] args) {
        System.out.println(addStrings("123", "456"));
        System.out.println(addStrings("98", "9"));
        System.out.println(addStrings("99", "99"));
        System.out.println(addStrings("99999", "99"));
    }


    public static String addStrings(String num1, String num2) {
        int carry = 0;
        Stack<Integer> stack = new Stack<Integer>();
        String shortString = num1.length() > num2.length() ? num2 : num1;
        String longString = num1.length() > num2.length() ? num1 : num2;

        for (int i = shortString.length() - 1; i >= 0; i--) {
            int a = longString.charAt(longString.length() - 1 - i) - '0';
            int b = shortString.charAt(shortString.length() - 1 - i) - '0';
            int sum = a + b + carry;
            carry = sum / 10;
            stack.add(sum % 10);
        }
        if (longString.length() > shortString.length()) {
            int len = longString.length() - shortString.length();
            for (int i = len; i > 0; i--) {
                int b = longString.charAt(i-1) - '0';
                int sum = b + carry;
                carry = sum / 10;
                stack.add(sum % 10);
            }
        }
        if (carry > 0) {
            stack.add(carry);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
