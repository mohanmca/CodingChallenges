package algorithm.part1;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] integers = new int[]{7, 8, 7, 2, 3, 2, 4};
        QuickSort quick = new QuickSort();
        quick.sort(integers, 0, integers.length - 1);
        System.out.println(Arrays.toString(integers));
    }

    public void sort(int[] integers, int low, int high) {
        if (high <= low) return;

        int j = partition(integers, low, high);

        sort(integers, low, j - 1);
        sort(integers, j + 1, high);
    }


    public int partition(int[] arr, int low, int high) {
        int i = low;
        int j = high + 1;
        int pivot = arr[low];
        while (true) {

            // find item on lo to swap
            while (arr[++i] < pivot) {
                if (i == high) break;
            }

            // find item on hi to swap
            while (arr[--j] > pivot) {
                if (j == low) break;      // redundant since a[lo] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;

            swap(arr, i, j);
        }

        // put partitioning item v at a[j]
        swap(arr, low, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    private void swap(int[] arr, int j, int k) {
        int temp = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
    }


}
