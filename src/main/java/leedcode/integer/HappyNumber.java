package leedcode.integer;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {

//        System.out.println(isHappy(1));
//        System.out.println(isHappy(0));
//        System.out.println(isHappy(68));
//        System.out.println(isHappy(19));
        System.out.println(isHappy(145));
        System.out.println(isHappy(64));
    }

    public static boolean isHappy(int n) {
        return isHappy(n, new HashSet<Integer>());
    }

    public static boolean isHappy(int n, Set<Integer> sadStack) {
        if (n == 1) return true;
        if (n == 0) return false;
        if (Math.ceil(Math.log10(n)) == Math.floor(Math.log10(n))) return true;
        sadStack.add(n);

        int pow = (int) Math.floor(Math.log10(n));
        int i = 0;
        while (pow >= 1) {
            int divisor = (int) Math.pow(10, pow--);
            i += (int)Math.pow(n / divisor, 2);
            n = n % divisor;
        }
        i += Math.pow(n, 2);

        if (sadStack.contains(i)) return false;
        return isHappy(i, sadStack);
    }

}
