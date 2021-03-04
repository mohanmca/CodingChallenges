package leedcode.tree;

public class MinimumBinaryTreeCamera {

    public static void main(String[] args) {
        MinimumBinaryTreeCamera solution = new MinimumBinaryTreeCamera();
        TreeNode root = LevelOrderedTree.buildTree(new Integer[]{0, null, 0, null, 0, null, 0});
        System.out.println(root);
        solution = new MinimumBinaryTreeCamera();
        System.out.println(solution.minCameraCover(root));


        root = LevelOrderedTree.buildTree(new Integer[]{0, 0, null, 0, 0});
        System.out.println(root);
        solution = new MinimumBinaryTreeCamera();
        System.out.println(solution.minCameraCover(root));

        root = LevelOrderedTree.buildTree(new Integer[]{0, 0, 0});
        System.out.println(root);
        solution = new MinimumBinaryTreeCamera();
        System.out.println(solution.minCameraCover(root));


        root = LevelOrderedTree.buildTree(new Integer[]{0, 0, null, 0, null, 0, null, null, 0});
        System.out.println(root);
        solution = new MinimumBinaryTreeCamera();
        System.out.println(solution.minCameraCover(root));

        solution = new MinimumBinaryTreeCamera();
        root = LevelOrderedTree.sampleTree();
        System.out.println(root);
        System.out.println(solution.minCameraCover(root));
    }


    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        TreeAccumulator accumulator = countCameraCover(root);
        return Math.min(accumulator.optimisticCount, accumulator.pessimisticCount);
    }

    public TreeAccumulator countCameraCover(TreeNode root) {
        if (root == null) return TreeAccumulator.of(0, 0, 0);
        if (root.left == null && root.right == null) {
            TreeAccumulator accu = TreeAccumulator.of(0, 1, 1);
            root.depth=1;
            accu.pessimisticCount = 1;
            accu.pesDepthCoverage = 1;
            return accu;
        } else {
            TreeAccumulator laccumulator = countCameraCover(root.left);
            TreeAccumulator raccumulator = countCameraCover(root.right);
            int curDepth = Math.max(laccumulator.depth, raccumulator.depth) + 1;
            TreeAccumulator accumulator = TreeAccumulator.of(laccumulator.optimisticCount + raccumulator.optimisticCount,
                    laccumulator.pessimisticCount + raccumulator.pessimisticCount, curDepth);
            if (curDepth % 3 == 1) {
                accumulator.pesDepthCoverage = curDepth;
                accumulator.pessimisticCount++;
            } else if (curDepth % 3 == 2) {
                accumulator.optDepthCoverage = curDepth;
                accumulator.optimisticCount++;
            }
            return accumulator;
        }
    }

    static class TreeAccumulator {
        int optimisticCount;
        int pessimisticCount;
        int optDepthCoverage;
        int pesDepthCoverage;
        int depth;

        static TreeAccumulator of(int optCount, int pesCount, int depth) {
            TreeAccumulator accumulator = new TreeAccumulator();
            accumulator.optimisticCount = optCount;
            accumulator.pessimisticCount = pesCount;
            accumulator.depth = depth;
            return accumulator;
        }
    }
}
