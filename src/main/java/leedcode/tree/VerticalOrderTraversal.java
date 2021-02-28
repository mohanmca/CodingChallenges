package leedcode.tree;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderTraversal {

    TreeMap<Integer, List<int[]>> verticalOrder = new TreeMap<Integer, List<int[]>>();

    public static void main(String[] args) {
        VerticalOrderTraversal solution = new VerticalOrderTraversal();

        TreeNode rightTree = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode rootTree = new TreeNode(3, new TreeNode(9), rightTree);
        System.out.println(solution.verticalTraversal(rootTree));
        solution = new VerticalOrderTraversal();
        System.out.println(solution.verticalTraversal(new TreeNode(15)));
        TreeNode leftTree = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        rightTree = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        rootTree = new TreeNode(1, leftTree, rightTree);
        solution = new VerticalOrderTraversal();
        System.out.println(solution.verticalTraversal(rootTree));
        TreeNode node = LevelOrderedTree.buildTree(new Integer[]{3, 1, 4, 0, 2, 2});
        solution = new VerticalOrderTraversal();
        System.out.println(solution.verticalTraversal(node));
        node = LevelOrderedTree.buildTree(new Integer[]{1, 2, 3, 4, 6, 5, 7});
        solution = new VerticalOrderTraversal();
        System.out.println(solution.verticalTraversal(node));
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        verticalTraversal(root, 0, 0);
        List<List<Integer>> items = new ArrayList<>(verticalOrder.size());
        for (Integer key : verticalOrder.keySet()) {
            List<Integer> sorted = verticalOrder.get(key).stream().sorted(this::compare).map(i -> i[1]).collect(Collectors.toList());
            items.add(sorted);
        }
        return items;
    }

    public int compare(int[] i, int[] j) {
        int depthCompare = Integer.compare(i[0], j[0]);
        if (depthCompare == 0) {
            return Integer.compare(i[1], j[1]);
        } else
            return depthCompare;
    }

    public void verticalTraversal(TreeNode root, int depth, int direction) {
        if (root == null) return;
        List<int[]> set = verticalOrder.getOrDefault(direction, new ArrayList<int[]>());
        set.add(new int[]{depth, root.val});
        verticalOrder.put(direction, set);
        verticalTraversal(root.left, depth + 1, direction - 1);
        verticalTraversal(root.right, depth + 1, direction + 1);
    }

}
