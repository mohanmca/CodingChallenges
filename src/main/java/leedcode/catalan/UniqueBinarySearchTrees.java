package leedcode.catalan;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        UniqueBinarySearchTrees solution = new UniqueBinarySearchTrees();
        System.out.println(solution.numTrees(0));
        System.out.println(solution.numTrees(1));
        System.out.println(solution.numTrees(2));
        System.out.println(solution.numTrees(3));
        System.out.println(solution.numTrees(4));
        System.out.println(solution.numTrees(5));
        System.out.println(solution.numTrees(6));

    }

    public int numTrees(int n) {
        if (n < 2) return 1;
        int[] catalan = new int[n+1];
        catalan[0] = 1;
        catalan[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += catalan[j] * catalan[i - 1 - j];
            }
            catalan[i] = sum;
        }
        return catalan[n];
    }
}
