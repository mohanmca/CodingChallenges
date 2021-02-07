package leedcode.tree;

public class DiameterOfBinaryTree {


    private static int ans = 0;

    public static void main(String[] args) {
        System.out.println(diameterOfBinaryTree(LevelOrderedTree.sampleTree2()));
        System.out.println(diameterOfBinaryTree(LevelOrderedTree.sampleTree()));

        System.out.println(diameterOfBinaryTree(new TreeNode(15)));

        TreeNode rightTree = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode rootTree = new TreeNode(3, new TreeNode(9), rightTree);
        System.out.println(diameterOfBinaryTree(rootTree));
        TreeNode leftTree = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        rightTree = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        rootTree = new TreeNode(1, leftTree, rightTree);
        System.out.println(diameterOfBinaryTree(rootTree));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        height(root);
        return ans - 1;
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        ans = Math.max(ans, left + right + 1);
        return 1 + Math.max(left, right);
    }

}
