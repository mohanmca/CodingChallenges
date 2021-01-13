package leedcode.string.easy;

public class RemoveVowel {
    public static void main(String[] args) {
        System.out.printf(removeVowels("leetcodeisacommunityforcoders"));
    }

    public static String removeVowels(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (aChar != 'a'
                    && aChar != 'e'
                    && aChar != 'i'
                    && aChar != 'o'
                    && aChar != 'u'
            ) {
                sb.append(aChar);
            }
        }
        return sb.toString();
    }
}
