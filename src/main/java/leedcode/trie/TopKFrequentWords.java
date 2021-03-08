package leedcode.trie;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/top-k-frequent-words/submissions/
 */
public class TopKFrequentWords {
    public static void main(String[] args) {
        TopKFrequentWords solution = new TopKFrequentWords();
        List<String> topKwords = solution.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 1);
        System.out.println(Arrays.deepToString(topKwords.toArray()));

        topKwords = solution.topKFrequent(new String[]{"dd", "dd", "bb", "bb", "aa", "aa", "cc", "cc"}, 1);
        System.out.println(Arrays.deepToString(topKwords.toArray()));
        topKwords = solution.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
        System.out.println(Arrays.deepToString(topKwords.toArray()));
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        List<String> keys = new ArrayList<>(wordCount.keySet());
        keys.sort((w, w2) -> wordCount.get(w2).equals(wordCount.get(w)) ? w.compareTo(w2) : wordCount.get(w2) - wordCount.get(w));
        return keys.subList(0,k);
    }

    public List<String> topKFrequentV1(String[] words, int k) {
        TrieNode trieRoot = new TrieNode();
        Map<TrieNode, Integer> triesCount = new HashMap<TrieNode, Integer>();
        Map<TrieNode, String> triesToWord = new HashMap<TrieNode, String>();
        for (String word : words) {
            TrieNode node = TrieNode.of(trieRoot, word);
            triesCount.put(node, triesCount.getOrDefault(node, 0) + 1);
            triesToWord.put(node, word);
        }
        List<String> topUsed = triesCount.entrySet().stream().sorted((tc, tc2) -> {
            if (tc.getValue() == tc2.getValue())
                return triesToWord.get(tc.getKey()).compareTo(triesToWord.get(tc2.getKey()));
            return tc2.getValue() - tc.getValue();
        }).map(kv -> triesToWord.get(kv.getKey())).collect(Collectors.toList());
        return topUsed.subList(0, k);
    }


    static class TrieNode {
        short count = 0;
        TrieNode[] nodes = new TrieNode[26];

        public static TrieNode of(TrieNode root, String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                current = current.put(c);
            }
            return current;
        }

        public TrieNode put(char c) {
            if (nodes[c - 'a'] == null) {
                nodes[c - 'a'] = new TrieNode();
                count++;
            }
            return nodes[c - 'a'];
        }
    }


}
