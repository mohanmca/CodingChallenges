package leedcode.string;

import code.challenge.AlgorithmUtils;

import java.util.*;
import java.util.stream.IntStream;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        AlgorithmUtils.printInvokeReturn(solution::longestPalindrome, "bb");
        AlgorithmUtils.printInvokeReturn(solution::longestPalindrome, "babad");
        AlgorithmUtils.printInvokeReturn(solution::longestPalindrome, "cbbd");
        AlgorithmUtils.printInvokeReturn(solution::longestPalindrome, "a");
        AlgorithmUtils.printInvokeReturn(solution::longestPalindrome, "ac");
    }

    public String longestPalindrome(String s) {
        for (int n = s.length() ; n > 1; n--) {
            Optional<String> found = windowOfCharacters(s, n).stream().filter(this::isPalindrome).findFirst();
            if (found.isPresent()) {
                return found.get();
            }
        }
        return s.charAt(0) + "";
    }

    /*
    ["abc"] - ws -2 ab - bc 3-2+1
     */
    public List<String> windowOfCharacters(String s, int windowSize) {
        if (s.length() < windowSize) return Collections.emptyList();
        if (s.length() == windowSize) return Collections.singletonList(s);
        List<String> size = new ArrayList<String>(s.length() - windowSize + 1);
        for (int ws = 0; ws < (s.length() - windowSize + 1); ws++)
            size.add(s.substring(ws, ws + windowSize));
        return size;
    }

    public boolean isPalindrome(String content) {
        char[] chars = content.toCharArray();
        return IntStream.range(0, chars.length / 2).allMatch(i -> chars[i] == chars[chars.length - 1 - i]);
    }
}
