package leedcode.tree;

public class BinaryTreePruning {
    public static void main(String[] args) {
        BinaryTreePruning solution = new BinaryTreePruning();
        TreeNode root = LevelOrderedTree.buildTree(new Integer[]{1, null, 0, 0, 1});
        System.out.println(root);
        System.out.println(solution.pruneTree(root));
        root = LevelOrderedTree.buildTree(new Integer[]{1, 0, 1, 0, 0, 0, 1});
        System.out.println(root);
        System.out.println(solution.pruneTree(root));
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = root.left != null ? pruneTree(root.left) : null;
        root.right = root.right != null ? pruneTree(root.right) : null;
        if (root.right == null && root.left == null && root.val == 0)
            return null;
        return root;
    }
}
