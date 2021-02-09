package leedcode.tree;

public class IfBalancedBinaryTree {


    private static final int heighDifference = 0;

    public static void main(String[] args) {
        System.out.println(isBalanced(LevelOrderedTree.sampleBalancedBinary()));
        System.out.println(isBalanced(LevelOrderedTree.sampleTree2()));
        System.out.println(isBalanced(LevelOrderedTree.sampleTree()));

        System.out.println(isBalanced(new TreeNode(15)));

        TreeNode rightTree = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode rootTree = new TreeNode(3, new TreeNode(9), rightTree);
        System.out.println(isBalanced(rootTree));
        TreeNode leftTree = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        rightTree = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        rootTree = new TreeNode(1, leftTree, rightTree);
        System.out.println(isBalanced(rootTree));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        if (!isBalanced(root.left)) return false;
        if (!isBalanced(root.right)) return false;

        int heightOfRight = height(root.right);
        int heightOfLeft = height(root.left);
        return Math.abs(heightOfRight - heightOfLeft) <= 1;
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

}
