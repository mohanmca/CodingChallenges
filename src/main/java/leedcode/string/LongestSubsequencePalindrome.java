package leedcode.string;

import code.challenge.AlgorithmUtils;

public class LongestSubsequencePalindrome {
    public static void main(String[] args) {
        LongestSubsequencePalindrome solution = new LongestSubsequencePalindrome();
        AlgorithmUtils.printInvokeReturn(solution::longestSubseqencePalindrome, "abba");
        AlgorithmUtils.printInvokeReturn(solution::longestSubseqencePalindrome, "Mohan");

    }

    public String longestSubseqencePalindrome(String content, int j, int k) {
        String palindrom = "";
        for (; j >= 0 && k <= content.length() - 1; ) {
            if (content.charAt(j) == content.charAt(k)) {
                palindrom = content.substring(j, k+1);
                --j;
                ++k;
            } else {
                break;
            }
        }
        return palindrom;
    }


    public String longestSubseqencePalindrome(String input) {
        String palindrom = "";
        for (int i = 0; i < input.length() - 1; i++) {
            String tmp = longestSubseqencePalindrome(input, i-1, i+1);
            palindrom = Math.max(tmp.length(), palindrom.length()) == tmp.length() ? tmp : palindrom;
            tmp = longestSubseqencePalindrome(input, i, i+1);
            palindrom = Math.max(tmp.length(), palindrom.length()) == tmp.length() ? tmp : palindrom;
        }
        return palindrom;
    }

}
