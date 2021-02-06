package leedcode.easy;

import java.util.Arrays;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }

    public static List<String> fizzBuzz(int n) {
        String[] fizzBuzz = new String[n];

        for (int i = 0; i < n; i++) {
            if ((i + 1) % 15 == 0) {
                fizzBuzz[i] = "FizzBuzz";
            } else if ((i + 1) % 3 == 0) {
                fizzBuzz[i] = "Fizz";
            } else if ((i + 1) % 5 == 0) {
                fizzBuzz[i] = "Buzz";
            } else {
                fizzBuzz[i] = String.valueOf(i+1);
            }
        }
        return Arrays.asList(fizzBuzz);
    }
}
