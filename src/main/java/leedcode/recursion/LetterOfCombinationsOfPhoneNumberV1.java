package leedcode.recursion;

import java.util.*;

public class LetterOfCombinationsOfPhoneNumberV1 {
    static Map<Integer, String> phoneNumberCharacters = new HashMap<>();

    static {
        phoneNumberCharacters.put(2, "abc");
        phoneNumberCharacters.put(3, "def");
        phoneNumberCharacters.put(4, "ghi");
        phoneNumberCharacters.put(5, "jkl");
        phoneNumberCharacters.put(6, "mno");
        phoneNumberCharacters.put(7, "pqrs");
        phoneNumberCharacters.put(8, "tuv");
        phoneNumberCharacters.put(9, "wxyz");
    }

    public static void main(String[] args) {
        letterCombinations("").forEach(System.out::println);
        letterCombinations("23").forEach(System.out::println);
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return Collections.emptyList();
        return letterOfCombinations(toNumericalAlphabets(digits));
    }

    public static List<String> toNumericalAlphabets(String numbers) {
        List<String> numberStrings = new ArrayList<>(numbers.length());
        for (char c : numbers.toCharArray()) {
            int phoneDigit = c - 48;
            if (phoneDigit < 2) throw new IllegalStateException("1 and below numbers are not supported!");
            numberStrings.add(phoneNumberCharacters.get(phoneDigit));
        }
        return numberStrings;
    }

    public static List<String> letterOfCombinations(List<String> letters) {
        Stack<String> strings = new Stack<>();
        strings.addAll(letters);
        List<String> result = new ArrayList<>();
        result.add("");
        while (!strings.isEmpty()) {
            result = letterOfCombination(strings.pop().toCharArray(), result);
        }
        return result;
    }


    public static List<String> letterOfCombination(char[] letters, List<String> existingCombinations) {
        ArrayList<String> result = new ArrayList<>(letters.length * existingCombinations.size());
        for (char letter : letters) {
            for (String existingCombination : existingCombinations) {
                result.add(letter + "" + existingCombination);
            }
        }
        return result;
    }

}

