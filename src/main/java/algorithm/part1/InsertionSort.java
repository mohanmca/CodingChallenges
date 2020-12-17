package algorithm.part1;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] input = new int[]{7, 2, 4, 9, 20, 14, 9, 43};
        System.out.println(Arrays.toString(input));
        InsertionSort.sort(input);
        System.out.println(Arrays.toString(input));
    }

    public static void sort(int[] inputs) {
        for (int i = 1; i < inputs.length; i++) {
            for (int j = i; j > 0 && inputs[j - 1] > inputs[j]; j--) {
                swap(inputs, j);
            }
            System.out.println(Arrays.toString(inputs));
        }
    }

    private static void swap(int[] inputs, int j) {
        int temp = inputs[j];
        inputs[j] = inputs[j - 1];
        inputs[j - 1] = temp;
    }
}
