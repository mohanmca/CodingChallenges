//package leedcode.stack.catalan;
//
//import java.util.Stack;
//
//public class ScoreParenthesis {
//    public static void main(String[] args) {
//        ScoreParenthesis paren = new ScoreParenthesis();
//        System.out.println(paren.scoreParenthesis("(())"));
//    }
//
//    public int scoreParenthesis(String s) {
//        Stack<String> stack = new Stack<>();
//        for (Character c : s.toCharArray()) {
//            if (c == '(') {
//                stack.push(c + "");
//            } else {
//                if (!stack.isEmpty()) {
//                    String c1 = stack.pop();
//                    if (c1.equals("("))
//                        stack.push(1 + "");
//                    else if (Character.isDigit(c1.toCharArray()[0]) )
//                        stack.pop();
//                    else
//                        stack.push(Integer.parseInt(c1) * 2 + "");
//                } else {
//                    throw new IllegalStateException("Not possible!");
//                }
//            }
//        }
//        int count = 0;
//        while(!stack.isEmpty()){
//            count += Integer.parseInt(stack.pop());
//        }
//        return count;
//    }
//}
