package leedcode.string.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
    }


    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<Character>();
        for (char c : jewels.toCharArray()) {
            jewelSet.add(c);
        }

        int count = 0;
        for (char c : stones.toCharArray()) {
            count += jewelSet.contains(c) ? 1 : 0;
        }
        return count;
    }

}
