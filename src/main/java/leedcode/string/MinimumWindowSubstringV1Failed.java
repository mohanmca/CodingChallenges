package leedcode.string;

import java.util.*;

public class MinimumWindowSubstringV1Failed {
    public static void main(String[] args) {
        System.out.println("Result : " + minWindow("AA", "AA"));
        System.out.println("Result : " + minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("Result : " +minWindow("ADOBECODEBANC", "ABCZ"));
    }

    public static String minWindow(String s, String t) {
        Set<Character> constraintChars = new HashSet<>();
        for (char a : t.toCharArray()) {
            constraintChars.add(a);
        }

        Map<Character, Integer> actualCharacters = new HashMap<Character, Integer>();
        int maxIndex;
        int minIndex = Integer.MAX_VALUE;
        int window = Integer.MAX_VALUE;
        String result = "";

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (constraintChars.contains(c)) {
                Integer prevIndex = actualCharacters.put(c, i);
                maxIndex = i;
                if (prevIndex != null && prevIndex == minIndex) {
                    minIndex = Collections.min(actualCharacters.values());
                } else if (prevIndex == null && actualCharacters.size() == t.length()) {
                    minIndex = Collections.min(actualCharacters.values());
                }

                if (actualCharacters.size() == t.length()) {
                    if (maxIndex - minIndex < window) {
                        result = s.substring(minIndex, maxIndex + 1);
                        window = maxIndex - minIndex;
                    }
                }
            }
        }
        return result;
    }
}
