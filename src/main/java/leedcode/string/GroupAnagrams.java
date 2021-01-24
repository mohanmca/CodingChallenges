package leedcode.string;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] anagrams = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(anagrams));
        anagrams = new String[]{""};
        System.out.println(groupAnagrams(anagrams));
        anagrams = new String[]{"a"};
        System.out.println(groupAnagrams(anagrams));
        anagrams = new String[]{"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"};
        System.out.println(groupAnagrams(anagrams));

        /**
         * [["buy"],["duh","ill"],["bar"],["cab"],["max"],["doc"],["may"],["tin"],["pew"]]
         * [["buy"],["doc"],["bar"],["ill"],["tin"],["cab"],["pew"],["may"],["max"],["duh"]]
         */
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> anagrams = new HashMap<>();
        for (String item : strs) {
            char[] chars = item.toCharArray();
            Arrays.sort(chars);
            int hashCode = Arrays.hashCode(chars);
            if (anagrams.containsKey(hashCode)) {
                anagrams.get(hashCode).add(item);
            } else {
                anagrams.put(hashCode, new ArrayList<>(Arrays.asList(item)));
            }
        }
        return new ArrayList<>(anagrams.values());
    }
}
