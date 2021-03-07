package leedcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/short-encoding-of-words/
 */
public class ShortEncodingOfWords {

    public static void main(String[] args) {
        ShortEncodingOfWords solution = new ShortEncodingOfWords();
        String[] words = new String[]{"time", "me", "bell", "rhyme", "hyme"};
        words = new String[]{"time", "me", "bell"};

        System.out.println(solution.minimumLengthEncoding(words));
    }

    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap<>();
        for (int j = 0; j < words.length; ++j) {
            TrieNode current = root;
            for (int i = words[j].length() - 1; i >= 0; i--) {
                current = current.get(words[j].charAt(i));
            }
            nodes.put(current, j);
        }
        return nodes.entrySet().stream()
                .filter(e -> e.getKey().count == 0)
                .mapToInt(e -> words[e.getValue()].length() + 1).sum();

    }


    static class TrieNode {
        TrieNode[] chars = new TrieNode[26];
        short count = 0;

        public TrieNode get(char c) {
            if (chars[c - 'a'] == null) {
                chars[c - 'a'] = new TrieNode();
                count++;
            }
            return chars[c - 'a'];
        }
    }

}

