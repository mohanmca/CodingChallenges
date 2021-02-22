package leedcode.recursion;

import java.util.*;

public class LetterOfCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        LetterOfCombinationsOfPhoneNumber solution = new LetterOfCombinationsOfPhoneNumber();
        solution.letterCombinations("").forEach(System.out::println);
        solution.letterCombinations("23").forEach(System.out::println);
    }

    String[] phoneNumbers = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0) return Collections.emptyList();

        List<String> result = Collections.singletonList("");
        for(int i=0; i<digits.length() ; i++) {
            result = multiply(result, phoneNumbers[digits.charAt(i) - '0']);
        }
        return result;
    }

    public List<String> multiply(List<String> values, String newValue) {
        List<String> result = new ArrayList<>(values.size() * newValue.length());
        for(String name: values) {
            for(Character c: newValue.toCharArray()) {
                result.add(name+c);
            }
        }
        return result;
    }
}

