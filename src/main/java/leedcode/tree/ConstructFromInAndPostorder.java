package leedcode.tree;

import java.util.Arrays;

public class ConstructFromInAndPostorder {

    public static void main(String[] args) {
        ConstructFromInAndPostorder buildTree = new ConstructFromInAndPostorder();
        TreeNode tree = buildTree.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(tree);
        tree = buildTree.buildTree(new int[]{9}, new int[]{9});
        System.out.println(tree);
        tree = buildTree.buildTree(new int[]{}, new int[]{});
        System.out.println(tree);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        if (inorder.length == 1) return new TreeNode(inorder[0]);

        int root = postorder[postorder.length - 1];
        int index = indexOf(inorder, root);
        TreeNode left = null;
        TreeNode right = null;
        if (index > -1)
            left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        if (index < inorder.length - 1)
            right = buildTree(Arrays.copyOfRange(inorder, index + 1, inorder.length), Arrays.copyOfRange(postorder, index, postorder.length - 1));
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
