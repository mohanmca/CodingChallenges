package leedcode.string;

import java.util.Stack;

public class AddStrings {
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

        shortString = new StringBuilder(shortString.length()).append(shortString).reverse().toString();
        longString = new StringBuilder(longString.length()).append(longString).reverse().toString();

        for (int i = 0; i < shortString.length(); i++) {
            int a = longString.charAt(i) - '0';
            int b = shortString.charAt(i) - '0';
            int sum = a + b + carry;
            carry = sum / 10;
            stack.add(sum % 10);
        }
        if (longString.length() > shortString.length()) {
            String leftOver = longString.substring(shortString.length());
            for (int i = 0; i < leftOver.length(); i++) {
                int sum = carry + leftOver.charAt(i) - '0';
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
        return sb.toString();
    }
}
