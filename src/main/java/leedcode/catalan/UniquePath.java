package leedcode.catalan;

public class UniquePath {
    public static void main(String[] args) {
        UniquePath solution = new UniquePath();
        System.out.println(solution.uniquePaths(1, 7));
        System.out.println(solution.uniquePaths(3, 7));
        System.out.println(solution.uniquePaths(3, 2));
    }

    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    paths[i][j] = 1;
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        return paths[m - 1][n - 1];
    }

    public int uniquePathsV1(int m, int n) {
        if (m == 1 || n == 1) return 1;
        return uniquePaths(m, n - 1) + uniquePaths(m - 1, n);
    }
}
