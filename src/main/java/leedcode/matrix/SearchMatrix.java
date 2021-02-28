package leedcode.matrix;

public class SearchMatrix {
    public static void main(String[] args) {
        SearchMatrix solution = new SearchMatrix();
        int[][] grid = new int[][]{{1, 1}};
        System.out.println(solution.searchMatrix(grid, 2));
        System.out.println(solution.searchMatrix(grid, 1));
        grid = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(solution.searchMatrix(grid, 8));
        System.out.println(solution.searchMatrix(grid, 11));
        System.out.println(solution.searchMatrix(grid, 16));
        System.out.println(solution.searchMatrix(grid, 34));
        System.out.println(solution.searchMatrix(grid, 3));
        System.out.println(solution.searchMatrix(grid, -1));
        grid = new int[][]{{1}};
        System.out.println(solution.searchMatrix(grid, 2));
        System.out.println(solution.searchMatrix(grid, 1));
        grid = new int[][]{{}};
        System.out.println(solution.searchMatrix(grid, 2));
        System.out.println(solution.searchMatrix(grid, 1));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rs = matrix.length;
        if (rs == 0) return false;
        int cs = matrix[0].length;
        int l = 0, r = rs * cs - 1, mid = 0, midElement;
        while (l <= r) {
            mid = l + (r - l) / 2;
            midElement = matrix[mid / cs][mid % cs];
            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }


}
