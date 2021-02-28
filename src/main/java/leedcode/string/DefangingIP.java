package leedcode.string;

public class DefangingIP {
    public static void main(String[] args) {
        DefangingIP solution = new DefangingIP();
        System.out.println(solution.defangIPaddr("1.1.1.1"));
        System.out.println(solution.defangIPaddr("255.100.50.0"));
    }

    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder(address.length() + 6);
        for (char aChar : address.toCharArray()) {
            if (aChar == '.') {
                sb.append("[.]");
            } else {
                sb.append(aChar);
            }
        }
        return sb.toString();
    }

}
