package leedcode.string;

public class SortingAndSearching {
    public static void main(String[] args) {
        System.out.println(isAnagram("car", "rac"));
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("malayalam", "malayalam"));
        System.out.println(isAnagram("t", "ta"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] frequency = new int[26];

        char[] leftChars = s.toCharArray();
        char[] rightChars = t.toCharArray();

        for (int i = 0; i < leftChars.length; i++) {
            frequency[leftChars[i] - 'a']++;
            frequency[rightChars[i] - 'a']--;
        }
        
        for (int j : frequency) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

}
