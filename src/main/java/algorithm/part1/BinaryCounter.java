package algorithm.part1;

import java.util.Arrays;

public class BinaryCounter {
    int[] arr;

    public BinaryCounter(int N) {
        this.arr = new int[N];
        enumerate(0);
    }

    public static void main(String[] args) {
        BinaryCounter counter = new BinaryCounter(3);
    }

    public void enumerate(int k) {
        if (k == arr.length) {
            Arrays.stream(arr).forEach(System.out::print);
            System.out.println("");
            return;
        }
        enumerate(k + 1);
        arr[k] = 1;
        enumerate(k + 1);
        arr[k] = 0;
    }
}
