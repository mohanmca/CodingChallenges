package leedcode.string;

import java.util.*;
import java.util.stream.Collectors;

public class ShortEncodingOfWordsV1 {
    public static void main2(String[] args) {

        String[] words = new String[]{"time", "me", "bell", "rhyme", "hyme"};
        Map<Object, List<String>> groups = Arrays.stream(words)
                .collect(Collectors.groupingBy(s -> s.charAt(s.length() - 1)));
        System.out.println(Arrays.deepToString(groups.entrySet().toArray()));
        Set<String> unique = groups.entrySet().stream().filter(kv -> kv.getValue().size() == 1)
                .map(kv -> kv.getValue().get(0))
                .collect(Collectors.toSet());
        System.out.println(Arrays.deepToString(unique.toArray()));
        Set<String> overlap = groups.entrySet().stream().filter(kv -> kv.getValue().size() > 1)
                .flatMap(kv -> kv.getValue().stream())
                .collect(Collectors.toSet());
        System.out.println(Arrays.deepToString(overlap.toArray()));
        groups = overlap.stream().collect(Collectors.groupingBy(s -> s.charAt(s.length() - 2)));
        unique = groups.entrySet().stream().filter(kv -> kv.getValue().size() == 1)
                .map(kv -> kv.getValue().get(0))
                .collect(Collectors.toSet());
        System.out.println(Arrays.deepToString(unique.toArray()));
        overlap = groups.entrySet().stream().filter(kv -> kv.getValue().size() > 1)
                .flatMap(kv -> kv.getValue().stream())
                .collect(Collectors.toSet());
        System.out.println(Arrays.deepToString(overlap.toArray()));
        Set<String> suffixes = overlap.stream().filter(s -> s.length() == 2).collect(Collectors.toSet());
        System.out.println(Arrays.deepToString(suffixes.toArray()));
        groups = overlap.stream()
                .filter(s -> s.length() > 2)
                .collect(Collectors.groupingBy(s -> s.charAt(s.length() - 3)));
        unique = groups.entrySet().stream().filter(kv -> kv.getValue().size() == 1)
                .map(kv -> kv.getValue().get(0))
                .collect(Collectors.toSet());
        System.out.println(Arrays.deepToString(unique.toArray()));
        overlap = groups.entrySet().stream().filter(kv -> kv.getValue().size() > 1)
                .flatMap(kv -> kv.getValue().stream())
                .collect(Collectors.toSet());
        System.out.println("Overlap " + Arrays.deepToString(overlap.toArray()));
        suffixes = overlap.stream().filter(s -> s.length() == 3).collect(Collectors.toSet());
        System.out.println(Arrays.deepToString(suffixes.toArray()));
        groups = overlap.stream()
                .filter(s -> s.length() > 4)
                .collect(Collectors.groupingBy(s -> s.charAt(s.length() - 4)));
        unique = groups.entrySet().stream().filter(kv -> kv.getValue().size() == 1)
                .map(kv -> kv.getValue().get(0))
                .collect(Collectors.toSet());
        System.out.println("Unique " + Arrays.deepToString(unique.toArray()));
    }

    public static void main(String[] args) {
        ShortEncodingOfWords solution = new ShortEncodingOfWords();
        String[] words = new String[]{"time", "me", "bell", "rhyme", "hyme"};
        words = new String[]{"time", "me", "bell"};

        System.out.println(solution.minimumLengthEncoding(words));
    }

    public int minimumLengthEncoding(String[] W) {
        Set<String> set = new HashSet<>(Arrays.asList(W));
        for (String word : W)
            if (set.contains(word))
                for (int i = 1; i < word.length(); i++)
                    set.remove(word.substring(i));
        int ans = set.size();
        for (String word : set) ans += word.length();
        return ans;
    }


}
