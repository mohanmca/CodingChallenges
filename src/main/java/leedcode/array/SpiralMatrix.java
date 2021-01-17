package leedcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int length = 3;
        int[][] matrix = new int[length][length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = i * length + j + 1;
            }
        }

        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(spiralOrder(matrix).toArray()));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int count = 0;
        int row = 0, column = 0;
        int maxColumn = matrix.length - 1;
        int maxRow = matrix[0].length - 1;
        int iteration = (matrix.length * matrix[0].length);
        int iter = 0;

        while (iter < iteration) {
            System.out.print(row + "," + column + ":" + count + ":");
            System.out.println(matrix[row][column]);

            if (isIncrementColumn(row, column, count, maxColumn)) {
                column++;
            } else if (isDecrementColumn(row, column, count, maxColumn)) {
                column--;
            } else if (isIncrementRow(row, column, count, maxRow)) {
                row++;
            } else if (isDecrementRow(row, column, count, maxRow)) {
                row--;
            } else {
                count++;
            }

            iter++;
        }

        return Collections.emptyList();
    }

    private static boolean isIncrementColumn(int row, int column, int count, int maxColumn) {
        return count % 4 == 0 && (column >= count / 4 && column < maxColumn - (count / 4));
    }

    private static boolean isDecrementColumn(int row, int column, int count, int maxColumn) {
        return count % 4 == 2 && (column > count / 4);
    }

    private static boolean isIncrementRow(int row, int column, int count, int maxRow) {
        return count % 4 == 1 && (row >= count / 4 && row < maxRow - (count / 4));
    }

    private static boolean isDecrementRow(int row, int column, int count, int maxRow) {
        return count % 4 == 3 && (row > (count / 4) + 1);
    }
}
