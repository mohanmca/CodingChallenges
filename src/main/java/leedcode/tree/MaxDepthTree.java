package leedcode.tree;

import java.util.List;

public class MaxDepthTree {

    public static void main(String[] args) {
        System.out.println(maxDepth(new TreeNode(15)));
        TreeNode rightTree = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode rootTree = new TreeNode(3, new TreeNode(9), rightTree);
        System.out.println(maxDepth(rootTree));
        TreeNode leftTree = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        rightTree = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        rootTree = new TreeNode(1, leftTree, rightTree);
        System.out.println(maxDepth(rootTree));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
