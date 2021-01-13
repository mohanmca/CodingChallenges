package leedcode.string;

public class IntegerToRoman {

    public static void main(String[] args) {
//        System.out.println(intToRoman(39));
//        System.out.println(intToRoman(1));
//        System.out.println(intToRoman(87));
//        System.out.println(intToRoman(187));
        System.out.println(intToRoman(99));
        System.out.println(intToRoman(3999));
        System.out.println(intToRoman(3599));
        System.out.println(intToRoman(3499));
    }

    public static String intToRoman(int num) {
        int thousand = num / 1000;
        num = num % 1000;
        int nineHundred = num / 900;
        num = num % 900;
        int fiveHundred = num / 500;
        num = num % 500;
        int fourHundred = num / 400;
        num = num % 400;
        int hundred = num / 100;
        num = num % 100;
        int ninty = num / 90;
        num = num % 90;
        int fifty = num / 50;
        num = num % 50;
        int fourty = num / 40;
        num = num % 40;
        int tens = num / 10;
        num = num % 10;
        int nine = num / 9;
        num = num % 9;
        int five = num / 5;
        num = num % 5;
        int four = num / 4;
        num = num % 4;
        StringBuilder roman = new StringBuilder();

        while (thousand-- > 0)
            roman.append("M");
        if (nineHundred > 0) {
            roman.append("CM");
        }
        if (fiveHundred > 0) {
            roman.append("D");
        }
        if (fourHundred > 0) {
            roman.append("CD");
        }
        while (hundred-- > 0)
            roman.append("C");
        if (ninty > 0) {
            roman.append("XC");
        }
        if (fifty > 0) {
            roman.append("L");
        }
        if (fourty > 0) {
            roman.append("XL");
        }
        while (tens-- > 0)
            roman.append("X");
        if (nine > 0) {
            roman.append("IX");
        }
        if (five > 0) {
            roman.append("V");
        }
        if (four > 0) {
            roman.append("IV");
        }
        while (num-- > 0)
            roman.append("I");

        return roman.toString();
    }

}
