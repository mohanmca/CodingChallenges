package leedcode.string;

public class LongSubStringWithoutRepetition {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("anviaj"));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("a"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
    }

    public static int lengthOfLongestSubstring(String args) {
        int max = 0, length = 0;
        int[] chars = new int[128];
        for (int i = 0; i < args.length(); i++){
            char c = args.toCharArray()[i];
            int noOfCharsApart = (i + 1) - chars[c];
            if (noOfCharsApart > length) {
                chars[c] = i + 1;
                length++;
            } else {
                max = Math.max(max, length);
                length = (i+1)-chars[c];
                chars[c] = i + 1;
            }

        }
        return Math.max(max, length);
    }

    public static int lengthOfLongestSubstringV1(String args) {
        int max = 0, length = 0;
        int[] chars = new int[128];
        for (int i = 0; i < args.length(); ) {
            char c = args.toCharArray()[i];
            int noOfCharsApart = (i + 1) - chars[c];
            if (noOfCharsApart > length || noOfCharsApart == 0) {
                chars[c] = i + 1;
                length++;
                i++;
            } else {
                if (length > max)
                    max = length;
                length = 0;
                i = chars[c];
            }
        }
        return Math.max(max, length);
    }


}
