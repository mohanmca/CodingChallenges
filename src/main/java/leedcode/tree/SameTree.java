package leedcode.tree;

public class SameTree {
    public static void main(String[] args) {
        TreeNode leftTree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode rightTree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode thirdTree = new TreeNode(2, new TreeNode(2), new TreeNode(3));
        System.out.println(isSameTree(thirdTree, rightTree));
        System.out.println(isSameTree(leftTree, rightTree));
        System.out.println(isSameTree(leftTree, null));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if ((p != null && q == null) || (q != null && p == null)) {
            return false;
        }

        return (p.val == q.val)
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}
