package leedcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int length = 4;
        int[][] matrix = new int[length][length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = i * length + j + 1;
            }
        }
        int[][] spiral = new int[1][1];
        spiral[0][0] = 1;

        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(spiralOrderV1(matrix).toArray()));
        System.out.println(Arrays.deepToString(spiralOrderV1(spiral).toArray()));
    }

    public static List<Integer> spiralOrderV1(int[][] matrix) {
        /**
         * count%4 == 0 --> increment column
         * count%4 == 1 --> increment row
         * count%4 == 2 --> decrement column
         * count%4 == 3 --> decrement row
         */
        int count = 0;
        int row = 0, column = 0;
        int iteration = (matrix.length * matrix[0].length);
        int iter = 0;
        boolean flag = true;
        List<Integer> spiralIntegers = new ArrayList<>(iteration);
        while (iter < iteration) {
            int spiralCount = count / 4;
            int maxColumn = matrix.length - 1 - spiralCount;
            int maxRow = matrix[0].length - 1 - spiralCount;
            if (flag) {
                spiralIntegers.add(matrix[row][column]);
                iter++;
            }
            if (count % 4 == 0 && column < maxColumn) {
                flag = true;
                column++;
            } else if (count % 4 == 1 && row < maxRow) {
                flag = true;
                row++;
            } else if (count % 4 == 2 && column > spiralCount) {
                flag = true;
                column--;
            } else if (count % 4 == 3 && row > spiralCount + 1) {
                flag = true;
                row--;
            } else {
                count++;
                flag = false;
            }
        }
        return spiralIntegers;
    }


}
