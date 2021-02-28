package leedcode.math;

public class PowerOfThree {
    public static void main(String[] args) {
        PowerOfThree solution = new PowerOfThree();
        System.out.println(solution.isPowerOfThree(3));
        System.out.println(solution.isPowerOfThree(4));
        System.out.println(solution.isPowerOfThree(1));
        System.out.println(solution.isPowerOfThree(10));
        System.out.println(solution.isPowerOfThree(27));
    }

    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }
}
