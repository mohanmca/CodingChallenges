package leedcode.integer;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    static char[] symbols = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    static Map<Character, Integer> positionalValues = null;

    static {
        positionalValues = new HashMap<Character, Integer>();
        for (int i = 0; i < symbols.length; i++) {
            positionalValues.put(symbols[i], i);
        }
    }

    public static void main(String[] args) {
//        System.out.println(intToRoman(39));
//        System.out.println(intToRoman(1));
//        System.out.println(intToRoman(87));
//        System.out.println(intToRoman(187));
/**
 * Symbol       Value
 * M             1000
 * D             500
 * C             100
 * L             50
 * X             10
 * V             5
 * I             1
 */
        char[] symbols = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
//        1499 MCDXCIX
//        3999 MMMCMXCIX
//        3599 MMMDXCIX
//        3499 MMMCDXCIX
//        1234 MCCXXXIV
//        123 CXXIII
        System.out.println(9 + " " + romanToInteger("IX"));
        System.out.println("1499" + " " + romanToInteger("MCDXCIX"));
        System.out.println("3999" + " " + romanToInteger("MMMCMXCIX"));
        System.out.println("3599" + " " + romanToInteger("MMMDXCIX"));
        System.out.println("3499" + " " + romanToInteger("MMMCDXCIX"));
        System.out.println("1234" + " " + romanToInteger("MCCXXXIV"));
        System.out.println("123" + " " + romanToInteger("CXXIII"));
    }


    public static int romanToInteger(String num) {
        int value = 0;
        for (int i = 0; i < num.length(); ) {
            if (i < num.length() - 1 && positionalValues.get(num.charAt(i)) < positionalValues.get(num.charAt(i + 1))) {
                value += getPositionalValue(num.charAt(i + 1), num.charAt(i));
                i = i + 2;
            } else {
                char symbol = num.charAt(i++);
                value += getPositionalValue(symbol);
            }
        }
        return value;
    }

    public static String repeatString(String romanChar, int num) {
        StringBuilder sb = new StringBuilder(num);
        while (num-- > 0) {
            sb.append(romanChar);
        }
        return sb.toString();
    }

    public static int getPositionalValue(char c1, char c2) {
        return getPositionalValue(c1) - getPositionalValue(c2);
    }

    public static int getPositionalValue(char c1) {
        int n = positionalValues.get(c1);
        if (n % 2 == 0) return (int) Math.pow(10, n / 2);
        return (int) (Math.pow(10, (n + 1) / 2) / 2);
    }

}
