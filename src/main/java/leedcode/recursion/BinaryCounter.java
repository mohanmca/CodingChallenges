package leedcode.recursion;

import java.util.Arrays;

public class BinaryCounter {
    int[] arr;

    public BinaryCounter(int n) {
        this.arr = new int[n];
        enumerate(0);
    }

    private void enumerate(int k) {
        if (k == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        enumerate(k + 1);
        arr[k] = 1;
        enumerate(k + 1);
        arr[k] = 0;
    }

    public static void main(String[] args) {
        BinaryCounter counter = new BinaryCounter(4);
    }

}
