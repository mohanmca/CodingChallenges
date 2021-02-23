package leedcode.string;

import java.util.Arrays;
import java.util.stream.IntStream;

public class VerifyinganAlienDictionary {
    public static void main(String[] args) {
        VerifyinganAlienDictionary solution = new VerifyinganAlienDictionary();
        System.out.println(solution.isAlienSorted(new String[]{"kuvp", "q"}, "ngxlkthsjuoqcpavbfdermiywz"));
        System.out.println(solution.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(solution.isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(solution.isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(solution.isAlienSorted(new String[]{"app","apple"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(solution.isAlienSorted(new String[]{"apple","apple"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    public boolean isAlienSorted(String[] words, String order) {
        char[] chars = order.toCharArray();
        int[] alpha = new int[26];
        for (int i = 0; i < alpha.length; i++) {
            alpha[chars[i] - 'a'] = i;
        }
        String[] alienWords = Arrays.stream(words).map(s -> toNumbers(alpha, s)).toArray(String[]::new);
        return isSorted(alienWords);
    }

    public boolean isSorted(String[] words) {
        return IntStream.range(0, words.length-1).noneMatch( i -> words[i+1].compareTo(words[i]) < 0 );
    }

    public String toNumbers(int[] alpha, String text) {
        StringBuilder sb = new StringBuilder(text.length());
        for (char c : text.toCharArray()) {
            sb.append(alpha[c - 'a']);
        }
        return sb.toString();
    }

}
