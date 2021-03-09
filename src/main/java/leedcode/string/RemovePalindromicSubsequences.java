package leedcode.string;

import code.challenge.AlgorithmUtils;

import java.util.stream.IntStream;

public class RemovePalindromicSubsequences {

    public static void main(String[] args) {
        RemovePalindromicSubsequences solution = new RemovePalindromicSubsequences();

        AlgorithmUtils.printInvokeReturn(solution::removePalindromeSub, "abba");
        AlgorithmUtils.printInvokeReturn(solution::removePalindromeSub, "abb");
        AlgorithmUtils.printInvokeReturn(solution::removePalindromeSub, "baabb");
        AlgorithmUtils.printInvokeReturn(solution::removePalindromeSub, "abbab");
    }

    public int removePalindromeSub(String s) {
        if (s.length() <= 1) return s.length();
        if(isPalindrom(s)) return 1;
        return 2;
    }

    public boolean isPalindrom(String content) {
        return IntStream.rangeClosed(1, content.length()).allMatch(i -> content.charAt(i - 1) == content.charAt(content.length() - i));
    }

}
