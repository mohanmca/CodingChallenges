package leedcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SquaresOfASortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -3, -2, -1})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4,-3,-2,-1,0,1,2,3})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-9, -3, -2, 5, 6, 7})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{0})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{1})));
    }

    public static int[] sortedSquares(int[] nums) {
        List<Integer> positiveSquare = new ArrayList<>(nums.length / 2);
        List<Integer> negativeSquare = new ArrayList<>(nums.length / 2);
        int[] result = new int[nums.length];
        for (int n : nums) {
            if (n < 0) {
                negativeSquare.add(n * n);
            } else {
                positiveSquare.add(n * n);
            }
        }
        Collections.reverse(negativeSquare);
        int i = 0;
        while (!positiveSquare.isEmpty() && !negativeSquare.isEmpty()) {
            if (positiveSquare.get(0) > negativeSquare.get(0)) {
                result[i++] = negativeSquare.remove(0);
            } else {
                result[i++] = positiveSquare.remove(0);
            }
        }
        List<Integer> leftOver = positiveSquare.isEmpty() ? negativeSquare : positiveSquare;
        while (!leftOver.isEmpty()) {
            result[i++] = leftOver.remove(0);
        }
        return result;
    }
}
