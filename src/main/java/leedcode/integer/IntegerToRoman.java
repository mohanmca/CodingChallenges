package leedcode.integer;

public class IntegerToRoman {

    public static void main(String[] args) {
//        System.out.println(intToRoman(39));
//        System.out.println(intToRoman(1));
//        System.out.println(intToRoman(87));
//        System.out.println(intToRoman(187));
/**
 * Symbol       Value
 * M             1000
 * D             500
 * C             100
 * L             50
 * X             10
 * V             5
 * I             1
 */
        System.out.println(1499 + " " + intToRoman(1499));
        System.out.println(3999 + " " + intToRoman(3999));
        System.out.println(3599 + " " + intToRoman(3599));
        System.out.println(3499 + " " + intToRoman(3499));
        System.out.println(1234 + " " + intToRoman(1234));
        System.out.println(123 + " " + intToRoman(123));
    }


    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num).length());
        int n = 3;
        while (n > 0 && num > 0) {
            int quotient = num / (int) Math.pow(10, n);
            if (quotient > 0) {
                sb.append(repeatString(getPositionChar(n, 0), quotient));
                num = num % (int) Math.pow(10, n);
            }

            int nearestPower = num - ((int) Math.pow(10, n) - (int) Math.pow(10, n - 1));
            if (nearestPower >= 0) {
                sb.append(getPositionChar(n, 1));
                num = num - ((int) Math.pow(10, n) - (int) Math.pow(10, n - 1));
            }

            int halfOfPower = num - ((int) Math.pow(10, n) / 2);
            if (halfOfPower >= 0) {
                sb.append(getPositionChar(n, 2));
                num = num - ((int) Math.pow(10, n) / 2);
            }

            int nearestHalfPower = num - ((int) Math.pow(10, n) / 2 - (int) Math.pow(10, n - 1));
            if (nearestHalfPower >= 0) {
                sb.append(getPositionChar(n, 3));
                num = num - ((int) Math.pow(10, n) / 2 - (int) Math.pow(10, n - 1));
            }
            n--;
        }
        while (num-- > 0)
            sb.append("I");

        return sb.toString();
    }

    public static String repeatString(String romanChar, int num) {
        StringBuilder sb = new StringBuilder(num);
        while (num-- > 0) {
            sb.append(romanChar);
        }
        return sb.toString();
    }


    public static String getPositionChar(int power, int offset) {
        char[] symbols = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        if (offset == 0) {
            return symbols[(power * 2)] + "";
        } else if (offset == 1) {
            return symbols[(power * 2) - 2] + "" + symbols[(power * 2)];
        } else if (offset == 2) {
            return symbols[(power * 2) - 1] + "";
        } else if (offset == 3) {
            return symbols[(power * 2) - 2] + "" + symbols[(power * 2) - 1] + "";
        }
        throw new IllegalStateException("Not possible");
    }

}
