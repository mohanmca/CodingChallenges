package leedcode.binary;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class BinaryStringWithSubstringRep1ToN {
    public static void main(String[] args) {
        BinaryStringWithSubstringRep1ToN solution = new BinaryStringWithSubstringRep1ToN();
        System.out.println("Is valid : " + solution.queryString("0110", 3)); ;
        System.out.println("Is valid : " + solution.queryString("0110", 4)); ;
        System.out.println("Is valid : " + solution.queryString("1", 1)); ;
    }

    public boolean queryStringV1(String binartyString, int n) {
        boolean valid = true;
        for (int i = 1; i <= n; i++) {
            valid = valid && binartyString.contains(Integer.toBinaryString(i));

        }
        return valid;
    }

    public boolean queryString(String S, int n) {
        return IntStream.rangeClosed(1,n).mapToObj(Integer::toBinaryString).filter(Predicate.not(S::contains)).findFirst().isEmpty();
    }
}
