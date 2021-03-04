package leedcode.array.dynamic;

import code.challenge.AlgorithmUtils;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        RemoveDuplicateLetters solution = new RemoveDuplicateLetters();
        AlgorithmUtils.printInvokeReturn(solution::removeDuplicateLetters, "abcba");
    }

    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i = 0; i < chars.length; i++) {
            lastIndex[chars[i] - 'a'] = i;
        }
        boolean[] seen = new boolean[26];
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            while (!charStack.empty() && !seen[chars[i] - 'a'] && chars[i] < charStack.peek() && lastIndex[charStack.peek() - 'a'] > i) {
                seen[charStack.pop() - 'a'] = false;
            }
            if (!seen[chars[i] - 'a']) {
                seen[chars[i] - 'a'] = true;
                charStack.push(chars[i]);
            }
        }
        StringBuilder sb = new StringBuilder(charStack.size());
        while (!charStack.empty())
            sb.append(charStack.pop());
        return sb.reverse().toString();
    }


    /**
     * Below would work exactly opposite of above
     *
     * @param s
     * @return
     */
    public String removeDuplicateLettersV2(String s) {
        char[] chars = s.toCharArray();
        int[] lastIndex = new int[26];
        for (char aChar : chars) {
            lastIndex[aChar - 'a']++;
        }
        boolean[] seen = new boolean[26];
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            while (!charStack.empty() && chars[i] < charStack.peek() && lastIndex[charStack.peek() - 'a'] > i) {
                seen[charStack.pop() - 'a'] = false;
            }
            if (!seen[chars[i] - 'a']) {
                seen[chars[i] - 'a'] = true;
                charStack.push(chars[i]);
            }
        }
        StringBuilder sb = new StringBuilder(charStack.size());
        while (!charStack.empty())
            sb.append(charStack.pop());
        return sb.toString();
    }
}
