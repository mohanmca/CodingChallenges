package leedcode.string;

import java.util.Arrays;

public class AtoI {
    public static void main(String[] args) {
        System.out.println(atoi(" "));
        System.out.println(atoi(""));
        System.out.println(atoi("   -1"));
        System.out.println(atoi("  -5-"));
        System.out.println(atoi("  +0 123"));
        System.out.println(atoi("  -0012a42"));
        System.out.println(atoi("00000-42a1234"));
        System.out.println(atoi("-91283472332"));
        System.out.println(atoi("2147483649"));
        System.out.println(atoi("-42"));
        System.out.println(atoi("   -42"));
        System.out.println(atoi("   459"));
        System.out.println(atoi("   234 abced"));
        System.out.println(atoi("words   234"));
        System.out.println(atoi("   -91283472332"));

    }

    public static int atoi(String s) {
        if (s == null || s.length() == 0) return 0;
        Integer sign = null;

        int num = 0;

        int i = 0;
        char[] chars = s.toCharArray();
        while (i < s.toCharArray().length && chars[i] == ' ') {
            i++;
        }

        if (chars.length == i) return num;

        switch (chars[i]) {
            case '-':
                sign = -1;
                i++;
                break;
            case '+':
                sign = 1;
                i++;
                break;
            default:
                sign = 1;
                break;
        }

        while (num >= 0 && i < chars.length) {
            char c = chars[i++];
            if (c >= '0' && c <= '9') {
                if (num > Integer.MAX_VALUE / 10
                        || (num == Integer.MAX_VALUE / 10 && c - '0' > Integer.MAX_VALUE % 10)) {
                    return (sign > 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else {
                    num = num * 10 + (c - '0');
                }
            } else {
                return num * sign;
            }
        }
        return num * sign;
    }

}
