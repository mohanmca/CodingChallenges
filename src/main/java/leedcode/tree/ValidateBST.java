package leedcode.tree;

public class ValidateBST {
    public static void main(String[] args) {
        ValidateBST solution = new ValidateBST();
        TreeNode tree = LevelOrderedTree.buildTree(new Integer[]{5, 4, 6, null, null, 3, 7});
        System.out.println("Valid should be " + solution.isValidBST(tree));
        tree = LevelOrderedTree.buildTree(new Integer[]{2, 1, 3});
        System.out.println("Valid should be " + solution.isValidBST(tree));
        tree = LevelOrderedTree.buildTree(new Integer[]{5, 1, 4, null, null, 3, 6});
        System.out.println("InvValid should be " + !solution.isValidBST(tree));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
        boolean valid = true;
        if (root.left != null)
            valid = isValidBSTHelper(root.left, Integer.MIN_VALUE, root.val);
        if (root.right != null)
            valid = isValidBSTHelper(root.right, root.val, Integer.MAX_VALUE);
        return valid;
    }

    public boolean isValidBSTHelper(TreeNode root, int min_value, int max_value) {
        boolean valid = root.val < max_value;
        if (root.left != null) {
            valid = root.left.val > min_value && root.left.val < root.val && isValidBSTHelper(root.left, min_value, max_value);
        }
        if (valid && root.right != null) {
            valid = max_value > root.right.val && root.right.val > root.val && isValidBSTHelper(root.right, min_value, max_value);
        }
        return valid;
    }
}
