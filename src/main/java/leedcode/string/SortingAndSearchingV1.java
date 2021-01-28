package leedcode.string;

public class SortingAndSearchingV1 {
    public static void main(String[] args) {
        System.out.println(isAnagram("car", "rac"));
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("malayalam", "malayalam"));
        System.out.println(isAnagram("t", "ta"));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return  false;

        int[] leftFrequency = new int[26];
        int[] rightFrequency = new int[26];

        char[] leftChars = s.toCharArray();
        char[] rightChars = t.toCharArray();

        for (char c : leftChars) {
            leftFrequency[c - 'a']++;
        }

        for (char c : rightChars) {
            rightFrequency[c - 'a']++;
        }

        for (int i = 0; i < leftFrequency.length; i++) {
            if (leftFrequency[i] != rightFrequency[i]) {
                return false;
            }
        }
        return true;
    }

}
