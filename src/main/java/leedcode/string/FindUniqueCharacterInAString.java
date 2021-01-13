package leedcode.string;

public class FindUniqueCharacterInAString {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("ee"));
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("mohan"));
    }

    public static int firstUniqChar(String s) {
        int[] charMap = new int[128];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (charMap[chars[i]] == 0) {
                charMap[chars[i]] = i + 1;
            } else {
                charMap[chars[i]] = -1;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < charMap.length; i++) {
            if (charMap[i] > 0) {
                min = Math.min(charMap[i], min);
            }
        }
        return min != Integer.MAX_VALUE ? min - 1 :-1;
    }
}
