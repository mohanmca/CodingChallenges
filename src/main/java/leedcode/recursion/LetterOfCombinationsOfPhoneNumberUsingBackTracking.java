package leedcode.recursion;

import java.util.ArrayList;
import java.util.List;

class LetterOfCombinationsOfPhoneNumberUsingBackTracking {

    public static void main(String[] args) {
        LetterOfCombinationsOfPhoneNumberUsingBackTracking solution =
                new LetterOfCombinationsOfPhoneNumberUsingBackTracking();
        solution.letterCombinations("").forEach(System.out::println);
        solution.letterCombinations("23").forEach(System.out::println);
    }

    String[] phone = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            output.add(combination);
        } else {
            String letters = phone[next_digits.charAt(0) - '0'] ;
            for (Character c: letters.toCharArray()) {
                backtrack(combination + c, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }
}