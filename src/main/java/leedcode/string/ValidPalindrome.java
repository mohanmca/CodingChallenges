package leedcode.string;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("Race a car"));
    }

    public static boolean isPalindrome(String s) {
        Deque<Character> deque = new ArrayDeque<>(s.length());
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                deque.add(Character.toLowerCase(c));
            }
        }
        int count = deque.size() / 2;
        while (count-- > 0)
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        if (deque.size() % 2 == 1) return deque.size() == 1;
        return deque.isEmpty();
    }

}
