package leedcode.tree.bst;

import leedcode.tree.TreeNode;

import java.util.Arrays;

public class BstFromPreorderTraversal {
    public static void main(String[] args) {
//        TreeNode rightTree = new TreeNode(10, null, new TreeNode(12) );
//        TreeNode leftTree = new TreeNode(5, new TreeNode(1), new TreeNode(7));
//        TreeNode root = new TreeNode(8,leftTree, rightTree );
//        System.out.println(verticalTraversal(rootTree));
        BstFromPreorderTraversal solution = new BstFromPreorderTraversal();
        TreeNode tree = solution.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        System.out.println(tree.toString());

    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        int root = preorder[0];
        TreeNode leftTree = bstFromPreorder(Arrays.stream(preorder).filter(i -> i < preorder[0]).toArray());
        TreeNode rightTree = bstFromPreorder(Arrays.stream(preorder).filter(i -> i > preorder[0]).toArray());
        return new TreeNode(root, leftTree, rightTree);
    }


    public TreeNode bstFromPreorderV1(int[] preorder) {
        int root = preorder[0];
        TreeBuilderStatus left = bstFromPreorderV1(preorder, 1, root, root);
        TreeBuilderStatus right = bstFromPreorderV1(preorder, left.currentPointer, root, Integer.MAX_VALUE);
        return new TreeNode(root, left.tree, right.tree);
    }

    /**
     * @param array
     * @param immediateRoot - it is inclusive and not used till now in tree
     * @param ultimateRoot  - currentRoot (it could be maximum value of left-subtree)
     * @param maxValue      - maximum applicable
     * @return
     */
    public TreeBuilderStatus bstFromPreorderV1(int[] array, int immediateRoot, int ultimateRoot, int maxValue) {
        if (immediateRoot == array.length || array[immediateRoot] > maxValue)
            return TreeBuilderStatus.build(null, immediateRoot);
        if (immediateRoot == array.length - 1)
            return TreeBuilderStatus.build(new TreeNode(array[immediateRoot]), immediateRoot + 1);
        TreeBuilderStatus builderStatus = null;
        TreeNode leftTree = null;
        TreeNode rightTree = null;
        int pointer = immediateRoot + 1;
        if (array[pointer] < array[immediateRoot]) {
            builderStatus = bstFromPreorderV1(array, pointer, array[immediateRoot], array[immediateRoot]);
            pointer = builderStatus.currentPointer;
            leftTree = builderStatus.tree;
        }
        if (pointer < array.length && array[pointer] > array[immediateRoot] && array[pointer] < maxValue) {
            builderStatus = bstFromPreorderV1(array, pointer, array[pointer], maxValue);
            pointer = builderStatus.currentPointer;
            rightTree = builderStatus.tree;
        }
        TreeNode currentNode = new TreeNode(array[immediateRoot], leftTree, rightTree);
        return TreeBuilderStatus.build(currentNode, pointer);
    }

    private static class TreeBuilderStatus {
        TreeNode tree;
        int currentPointer;

        public static TreeBuilderStatus build(TreeNode root, int pointer) {
            TreeBuilderStatus status = new TreeBuilderStatus();
            status.tree = root;
            status.currentPointer = pointer;
            return status;
        }
    }

}
