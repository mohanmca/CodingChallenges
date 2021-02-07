package leedcode.recursion;

import java.util.*;

public class GenerateParenthesisV1 {
    public static void main(String[] args) {
        generateParenthesis(3).forEach(System.out::println);
    }

    public static List<String> generateParenthesis(int n) {
        if (n == 0) return Collections.emptyList();
        if (n == 1) return Collections.singletonList("()");
        List<String> parenthesis = generateParenthesis(n - 1);
        Set<String> result = new HashSet<>(parenthesis.size() * 3);
        for (String paren : parenthesis) {
            result.add("(" + paren + ")");
            result.add(paren + "()");
            result.add("()" + paren);
        }
        return new ArrayList<>(result);
    }

}


