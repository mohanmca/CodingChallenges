package leedcode.tree;

/**
 * Every leaf node is subtree itself.
 */
public class UnivalueSubtrees {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode right = new TreeNode(2, new TreeNode(4), new TreeNode(3, new TreeNode(13), new TreeNode(3)));
        TreeNode root = new TreeNode(1, left, right);
        UnivalueSubtrees solution = new UnivalueSubtrees();
        System.out.println(solution.countUnivalSubtrees(root));

        left = new TreeNode(2, null, new TreeNode(3));
        right = new TreeNode(2, null, new TreeNode(5));
        root = new TreeNode(1, left, right);
        System.out.println(solution.countUnivalSubtrees(root));

        left = new TreeNode(-2, null, new TreeNode(-3));
        right = new TreeNode(2, null, new TreeNode(5));
        root = new TreeNode(-1, left, right);
        System.out.println(solution.countUnivalSubtrees(root));

        root = new TreeNode(1, new TreeNode(-2), new TreeNode(3));
        System.out.println("Finding -1" + solution.countUnivalSubtrees(root));

        System.out.println(solution.countUnivalSubtrees(root));
        System.out.println(solution.countUnivalSubtrees(root));
        root = new TreeNode(1, new TreeNode(2), null);
        System.out.println(solution.countUnivalSubtrees(root));


        left = new TreeNode(2);
        right = new TreeNode(2, new TreeNode(2), new TreeNode(2, null, new TreeNode(3)));
        root = new TreeNode(2, left, right);
        System.out.println(solution.countUnivalSubtrees(root));

        left = new TreeNode(3);
        right = new TreeNode(2, new TreeNode(2), new TreeNode(2, null, new TreeNode(2)));
        root = new TreeNode(1, left, right);
        System.out.println(solution.countUnivalSubtrees(root));

    }

    public int countUnivalSubtrees(TreeNode root) {
        return countUnivalSubtreesFromRoot(root).numberOfSubtreeUnival;
    }

    private TreeResultAccumulator countUnivalSubtreesFromRoot(TreeNode root) {
        if (root == null) return TreeResultAccumulator.build(true, 0);
        if (root.left == null && root.right == null) return TreeResultAccumulator.build(true, 1);

        boolean currentNodeUnival = true;
        if (root.right != null) {
            currentNodeUnival = root.right.val == root.val;
        }
        if (root.left != null) {
            currentNodeUnival = currentNodeUnival && root.left.val == root.val;
        }

        TreeResultAccumulator leftStatus = countUnivalSubtreesFromRoot(root.left);
        TreeResultAccumulator rightStatus = countUnivalSubtreesFromRoot(root.right);
        int numberOfSubtreeUnival = leftStatus.numberOfSubtreeUnival + rightStatus.numberOfSubtreeUnival;
        currentNodeUnival = leftStatus.isSubtreeUnival && rightStatus.isSubtreeUnival && currentNodeUnival;
        if (leftStatus.isSubtreeUnival && rightStatus.isSubtreeUnival && currentNodeUnival) {
            numberOfSubtreeUnival += 1;
        }

        return TreeResultAccumulator.build(currentNodeUnival, numberOfSubtreeUnival);
    }

    private static class TreeResultAccumulator {
        boolean isSubtreeUnival;
        int numberOfSubtreeUnival;

        public static TreeResultAccumulator build(boolean isSubtreeUnival, int numberOfSubtreeUnival) {
            TreeResultAccumulator accu = new TreeResultAccumulator();
            accu.isSubtreeUnival = isSubtreeUnival;
            accu.numberOfSubtreeUnival = numberOfSubtreeUnival;
            return accu;
        }
    }

}
