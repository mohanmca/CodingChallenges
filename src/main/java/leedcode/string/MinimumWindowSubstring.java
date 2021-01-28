package leedcode.string;

import java.util.*;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println("Result : " + minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("Result : " + minWindow("AA", "AA"));
        System.out.println("Result : " + minWindow("ADOBECODEBANC", "ABCZ"));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> windowCharacters = new HashMap<Character, Integer>();
        Map<Character, Integer> actualCharacters = new HashMap<Character, Integer>();
        for (char a : t.toCharArray()) {
            actualCharacters.put(a, actualCharacters.getOrDefault(a, 0) + 1);
        }
        int[] result = {-1, 0, 0};
        char[] chars = s.toCharArray();
        int numberOfCharactersFormed = 0;
        int l = 0;

        for (int r = 0; r < chars.length; r++) {
            char c = chars[r];
            windowCharacters.put(c, windowCharacters.getOrDefault(c, 0) + 1);
            if (actualCharacters.containsKey(c) && windowCharacters.get(c).intValue() == actualCharacters.get(c).intValue()) {
                numberOfCharactersFormed++;
            }
            while (l <= r && numberOfCharactersFormed == actualCharacters.size()) {
                if (result[0] == -1 || result[0] > r - l + 1) {
                    result[0] = r - l + 1;
                    result[1] = l;
                    result[2] = r;
                }
                char toRemove = chars[l++];
                int priorCount = windowCharacters.put(toRemove, windowCharacters.get(toRemove) - 1);
                if (actualCharacters.containsKey(toRemove) && actualCharacters.get(toRemove) > priorCount - 1) {
                    numberOfCharactersFormed--;
                }
            }
        }

        if (result[0] > -1) {
            return s.substring(result[1], result[2] + 1);
        }
        return "";
    }
}
