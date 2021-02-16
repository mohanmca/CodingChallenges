package leedcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode right = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        TreeNode root = new TreeNode(1, left, right);
        SymmetricTree solution = new SymmetricTree();
        System.out.println(solution.isSymmetric(root));

        left = new TreeNode(2,  null, new TreeNode(3));
        right = new TreeNode(2, null, new TreeNode(3));
        root = new TreeNode(1, left, right);
        solution = new SymmetricTree();
        System.out.println(solution.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right != null || left != null && right == null ) return false;
        if (left == null && right == null) return true;
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
