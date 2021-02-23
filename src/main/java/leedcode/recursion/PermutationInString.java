package leedcode.recursion;

import java.util.*;

public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString solution = new PermutationInString();
        System.out.println(solution.checkInclusion("adc", "dcda"));
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0) return true;

        List<Integer> positions = new ArrayList<>(s1.length());
        char[] chars = s1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int pos = s2.indexOf(chars[i]);
            if (pos == -1) return false;
            else {
                while (pos != -1) {
                    positions.add(pos);
                    pos = s2.indexOf(chars[i], pos+1);
                }
            }
        }
        Collections.sort(positions);
        return true;
//        int distance = positions[positions.length - 1] - positions[0];
//        return distance + 1 == positions.length;
    }


    public boolean checkInclusionFailed(String s1, String s2) {
        List<String> permutations = permutate(s1);
        for (String txt : permutations) {
            if (s2.contains(txt)) {
                return true;
            }
        }
        return false;
    }

    private List<String> permutate(String text) {
        List<String> output = new LinkedList<>();
        if (text == null || text.length() == 0) return Collections.emptyList();
        permutate("", text, output);
        return output;
    }

    private void permutate(String combination, String text, List<String> output) {
        if (text.length() == 0) {
            output.add(combination);
            return;
        }
        for (int i = 0; i < text.length(); i++) {
            permutate(combination + text.charAt(i), deleteCharAt(text, i), output);
        }
    }

    private String deleteCharAt(String text, int pos) {
        StringBuilder sb = new StringBuilder(text);
        sb.deleteCharAt(pos);
        return sb.toString();
    }

}
