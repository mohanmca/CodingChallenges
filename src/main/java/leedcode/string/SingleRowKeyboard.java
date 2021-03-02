package leedcode.string;

import code.challenge.AlgorithmUtils;

import java.util.HashMap;
import java.util.Map;

public class SingleRowKeyboard {
    public static void main(String[] args) {
        SingleRowKeyboard solution = new SingleRowKeyboard();
        AlgorithmUtils.printInvokeReturn(solution::calculateTime, "abcdefghijklmnopqrstuvxyz", "abc");
        AlgorithmUtils.printInvokeReturn(solution::calculateTime, "abcdefghijklmnopqrstuvxyz", "cba");
        AlgorithmUtils.printInvokeReturn(solution::calculateTime, "pqrstuvwxyzabcdefghijklmno", "leetcode");
    }

    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> characterDistance = new HashMap<Character, Integer>();
        char[] chars = keyboard.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            characterDistance.put(chars[i], i);
        }
        chars = word.toCharArray();
        int prevIndex = 0;
        int distance = 0;
        for (char aChar : chars) {
            distance += Math.abs(characterDistance.get(aChar) - prevIndex);
            prevIndex = characterDistance.get(aChar);
        }
        return distance;
    }
}
