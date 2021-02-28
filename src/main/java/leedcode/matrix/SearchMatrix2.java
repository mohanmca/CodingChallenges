package leedcode.matrix;

import java.util.Arrays;

public class SearchMatrix2 {
    public static void main(String[] args) {
        SearchMatrix2 solution = new SearchMatrix2();
        int[][] grid = new int[][]{{1, 1}};
        System.out.println(solution.searchMatrix(grid, 2));
        System.out.println(solution.searchMatrix(grid, 1));
        grid = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(solution.searchMatrix(grid, 15));
        System.out.println(solution.searchMatrix(grid, 8));
        System.out.println(solution.searchMatrix(grid, 30));
        System.out.println(solution.searchMatrix(grid, 1));
        System.out.println(solution.searchMatrix(grid, 99));
        grid = new int[][]{{}};
        System.out.println(solution.searchMatrix(grid, 99));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        int r = 0, c = n - 1;
        int pivot;
        while (r < m && c >= 0) {
            pivot = matrix[r][c];
            if (target > pivot) {
                r++;
            } else if (target < pivot) {
                c--;
            } else {
                return true;
            }
        }
        return false;
    }

}
