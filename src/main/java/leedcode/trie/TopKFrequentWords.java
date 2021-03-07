package leedcode.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/top-k-frequent-words/submissions/
 */
public class TopKFrequentWords {
    public static void main(String[] args) {
        TopKFrequentWords solution = new TopKFrequentWords();
        List<String> topKwords = solution.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 1);
        System.out.println(Arrays.deepToString(topKwords.toArray()));
        topKwords = solution.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
        System.out.println(Arrays.deepToString(topKwords.toArray()));
    }

    public List<String> topKFrequent(String[] words, int k) {
        TrieNode trieRoot = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap<TrieNode, Integer>();
        Map<TrieNode, String> nodes2 = new HashMap<TrieNode, String>();
        for (String word : words) {
            TrieNode node = TrieNode.of(trieRoot, word);
            nodes.put(node, nodes.getOrDefault(node, 0)+1);
            nodes2.put(node, word);
        }
        List<String> topUsed = nodes.entrySet().stream().sorted((kv, kv2) -> kv2.getValue() - kv.getValue()).map(kv -> nodes2.get(kv.getKey())).collect(Collectors.toList());
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
