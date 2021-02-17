package leedcode.tree;

import java.util.Arrays;

public class ConstructFromInAndPreorder {

    public static void main(String[] args) {
        ConstructFromInAndPreorder buildTree = new ConstructFromInAndPreorder();
        TreeNode tree = buildTree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(tree);
        tree = buildTree.buildTree(new int[]{9}, new int[]{9});
        System.out.println(tree);
        tree = buildTree.buildTree(new int[]{}, new int[]{});
        System.out.println(tree);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) return null;
        if (inorder.length == 1) return new TreeNode(inorder[0]);

        int root = preorder[0];
        int index = indexOf(inorder, root);
        TreeNode left = null;
        TreeNode right = null;
        if (index > -1)
            left = buildTree(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index) );
        if (index < inorder.length - 1)
            right = buildTree(Arrays.copyOfRange(preorder, index+1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return new TreeNode(root, left, right);
    }

    private int indexOf(int[] elements, int key) {
        int index = -1;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == key) return i;
        }
        return index;
    }


}
