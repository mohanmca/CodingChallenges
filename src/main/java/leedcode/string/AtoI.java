package leedcode.string;

import java.util.Arrays;

public class AtoI {
    public static void main(String[] args) {
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
        if (s == null && s.length() == 0) return 0;
        Integer sign = null;

        int num = 0;

        int i = 0;
        int size = s.toCharArray().length;
        char[] chars = s.toCharArray();
        while (num >= 0 && i < s.toCharArray().length) {
            char c = chars[i++];
            if (c >= '0' && c <= '9' || c == '-' || c == '+') {
                if ((c == '-' || c == '+') && sign == null)
                    sign = c == '-' ? -1 : 1;
                else if (c == '-' || c == '+')
                    return 0;
                else {
                    if (num > Integer.MAX_VALUE / 10
                            || (num == Integer.MAX_VALUE / 10 && c - '0' > Integer.MAX_VALUE % 10)) {
                        if (sign == null || sign > 0)
                            return Integer.MAX_VALUE;
                        else
                            return Integer.MIN_VALUE;

                    } else {
                        num = num * 10 + (c - '0');
                    }
                }

            } else if (c != ' ') {
                return num;
            }
        }

        if (num < 0) return Integer.MIN_VALUE;
        return (sign != null ? num * sign : num);
    }

}
