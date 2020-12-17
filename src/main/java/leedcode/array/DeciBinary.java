package leedcode.array;

public class DeciBinary {
    public static void main(String[] args) {
        System.out.println("For 22 - " + DeciBinaryCount("22"));
        System.out.println("For 32 - " + DeciBinaryCount("32"));
        System.out.println("For 45 - " + DeciBinaryCount("45"));
        System.out.println("For 82734 - " + DeciBinaryCount("82734"));
        System.out.println("For 2734609830709182346 - " + DeciBinaryCount("2734609830709182346"));
    }

    public static int DeciBinaryCount(String n) {
        int length = n.length();
        long value = Long.parseLong(n, 10);
        long fullOnes = generateOnes(length-1);
        int count = (int)(value / fullOnes);
        return value % fullOnes > 0 ? count + 1 : count;

    }

    public static long generateOnes(long n) {
        if (n == 0) return 1;
        return (long) Math.pow(10, n) + generateOnes(n - 1);
    }
}
