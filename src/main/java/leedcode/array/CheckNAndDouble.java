package leedcode.array;

import code.challenge.AlgorithmUtils;

import java.util.Arrays;

public class CheckNAndDouble {
    public static void main(String[] args) {
        CheckNAndDouble solution = new CheckNAndDouble();

        AlgorithmUtils.printInvokeReturn(solution::checkIfExist, new int[]{0, 0});
        AlgorithmUtils.printInvokeReturn(solution::checkIfExist, new int[]{-20, 8, -6, -14, 0, -19, 14, 4});
        AlgorithmUtils.printInvokeReturn(solution::checkIfExist, new int[]{-2, 0, 10, -19, 4, 6, -8});

//        AlgorithmUtils.printInvokeReturn(solution::checkIfExist, new int[]{-16, 8, 5, 3});
//        AlgorithmUtils.printInvokeReturn(solution::checkIfExist, new int[]{10, 2, 5, 3});
//        AlgorithmUtils.printInvokeReturn(solution::checkIfExist, new int[]{7, 1, 14, 11});
//        AlgorithmUtils.printInvokeReturn(solution::checkIfExist, new int[]{1, 3, 7, 11});
    }

    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int[] sortedArr = arr;
        int[] sorted = Arrays.stream(arr).filter(i -> i % 2 == 0).toArray();
        if (sorted.length == 0) return false;
        for (int i = 0; i < sorted.length; i++) {
            int key = sorted[i] / 2;
            int index = Arrays.binarySearch(arr, key);
            if (key == 0) {
                int index2 = Arrays.binarySearch(sortedArr, index + 1, arr.length, key);
                if (index >= 0 && index2 > index) {
                    return true;
                }
            } else if (index >= 0) {
                return true;
            }
        }
        return false;
    }
}
