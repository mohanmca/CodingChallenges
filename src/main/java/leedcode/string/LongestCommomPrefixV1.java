package leedcode.string;

public class LongestCommomPrefixV1 {
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
        if (strs.length == 1) return strs[0];
        int length = 0;
        boolean scan = true;
        char c = ' ';
        while (scan) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() > length) {
                    if (i == 0) {
                        c = strs[i].charAt(length);
                    } else if (c != strs[i].charAt(length)) {
                        scan = false;
                    } else if (i == strs.length - 1 && scan && c == strs[i].charAt(length)) {
                        length++;
                    }
                } else {
                    scan = false;
                }
            }
        }
        return length == 0 ? "" : strs[0].substring(0, length);
    }
}
