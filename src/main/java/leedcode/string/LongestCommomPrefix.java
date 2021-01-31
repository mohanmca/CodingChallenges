package leedcode.string;

import java.util.Arrays;

public class LongestCommomPrefix {
    public static void main(String[] args) {
        String[] items = {"flower", "flow", "flight"};
        System.out.println(commonPrefix(items));
        System.out.println(commonPrefix(new String[]{"flower", "dflow", "sflight"}));
        System.out.println(commonPrefix(new String[]{"lower", "", "l1"}));
        System.out.println(commonPrefix(new String[]{}));
        System.out.println(commonPrefix(new String[]{"a"}));
    }

    public static String commonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
