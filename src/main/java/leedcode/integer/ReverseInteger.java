package leedcode.integer;

public class ReverseInteger {
    public static void main(String[] args) {
        //534236469 --> 964632435
        System.out.println(reverseInteger(1534236469));
        System.out.println(reverseInteger(123));
        System.out.println(reverseInteger(0));
        System.out.println(reverseInteger(1));
        System.out.println(reverseInteger(11));
        System.out.println(reverseInteger(001));
        System.out.println(reverseInteger(100));
        System.out.println(reverseInteger(-321));
    }

    private static int reverseInteger(int x) {
        int sign = x > 0 ? 1 : -1;
        x = Math.abs(x);
        int reversed = 0;
        while (x != 0) {
            int reminder = x % 10;
            reversed += reminder;
            x = x / 10;
            if (x > 0) {
                try {
                    reversed = Math.multiplyExact(reversed, 10);
                } catch (ArithmeticException e) {
                    return 0;
                }
                //reversed *= 10;
            }
            if (reversed < 0) return 0;
        }
        return reversed * sign;
    }

}
