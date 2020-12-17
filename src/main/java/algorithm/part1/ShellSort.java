package algorithm.part1;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] input = new int[]{7, 2, 4, 9, 20, 14, 9, 43};
        System.out.println(Arrays.toString(input));
        ShellSort.sort(input);
        System.out.println(Arrays.toString(input));
    }

    public static void sort(int[] inputs) {
        hsort(inputs);
    }

    public static void hsort(int[] inputs) {
        int n = inputs.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && inputs[j - h] > inputs[j]; j--) {
                    swap(inputs, j - h, j);
                }

            }
            h = h / 3;
        }
        System.out.println(Arrays.toString(inputs));
    }

    public static boolean less(int[] inputs, int j, int k) {
        return inputs[j] < inputs[k];
    }

    private static void swap(int[] inputs, int j, int k) {
        int temp = inputs[j];
        inputs[j] = inputs[k];
        inputs[k] = temp;
    }
}
