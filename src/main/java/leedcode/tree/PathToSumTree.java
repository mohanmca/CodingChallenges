package leedcode.tree;

/**
 * https://leetcode.com/problems/path-sum/submissions/
 */
public class PathToSumTree {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode right = new TreeNode(2, new TreeNode(4), new TreeNode(3, new TreeNode(13), new TreeNode(3)));
        TreeNode root = new TreeNode(1, left, right);
        PathToSumTree solution = new PathToSumTree();
        System.out.println(solution.hasPathSum(root, 19));

        left = new TreeNode(2, null, new TreeNode(3));
        right = new TreeNode(2, null, new TreeNode(5));
        root = new TreeNode(1, left, right);
        System.out.println(solution.hasPathSum(root, 8));

        left = new TreeNode(-2, null, new TreeNode(-3));
        right = new TreeNode(2, null, new TreeNode(5));
        root = new TreeNode(-1, left, right);
        System.out.println(solution.hasPathSum(root, -6));

        root = new TreeNode(1, new TreeNode(-2), new TreeNode(3));
        System.out.println("Finding -1"+solution.hasPathSum(root, -1));

        System.out.println(solution.hasPathSum(root, 3));
        System.out.println(solution.hasPathSum(root, -3));
        root = new TreeNode(1, new TreeNode(2), null);
        System.out.println(solution.hasPathSum(root, 0));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;

        targetSum = targetSum - root.val;
        if( targetSum == 0 && (root.left==null && root.right==null) ) {
            return true;
        }
        return hasPathSum(root.left, targetSum) ||  hasPathSum(root.right,targetSum);
    }

    public boolean hasPathSumV2_Working(TreeNode root, int targetSum) {
        if (root == null) return false;
        int newTarget = targetSum;
        if (root.val < 0 && targetSum > 0 || root.val > 0 && targetSum < 0)
            newTarget = targetSum + (root.val * -1);
        else
            newTarget = targetSum - root.val;

        if (newTarget == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget);
    }

    public boolean hasPathSumV1(TreeNode root, int targetSum) {
        if (root == null && targetSum == 0) return true;
        if (root == null) return false;
        int target = targetSum - root.val;
        return target >= 0 && hasPathSumV1(root.left, target) || hasPathSumV1(root.right, target);
    }

}
