package leedcode.string;

/**
 * https://leetcode.com/problems/strobogrammatic-number/
 */
import java.util.*;

class Solution {

    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> oppositeNumber = new HashMap<Character, Character>();
        oppositeNumber.put('9','6');
        oppositeNumber.put('6','9');
        oppositeNumber.put('8','8');
        oppositeNumber.put('0','0');
        oppositeNumber.put('1','1');
        char[] chars = num.toCharArray();

        if(chars.length==1 && (chars[0]=='8' || chars[0]=='1')) {
            return true;
        } else if(chars.length==1) {
            return false;
        }

        for(int i=1; i<=chars.length/2; i++) {
            if(!oppositeNumber.containsKey(chars[i-1])
                    || (oppositeNumber.get(chars[i-1]) != chars[chars.length-i])){
                return false;
            }
        }


        Set<Character> numbers = new HashSet<Character>();
        for(char c: chars) {
            numbers.add(c);
        }
        numbers.remove('9');
        numbers.remove('1');
        numbers.remove('8');
        numbers.remove('6');
        numbers.remove('0');
        return numbers.size() == 0;
    }
}