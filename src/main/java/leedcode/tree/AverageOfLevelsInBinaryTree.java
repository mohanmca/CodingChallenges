package leedcode.tree;

import java.util.*;

public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        AverageOfLevelsInBinaryTree solution = new AverageOfLevelsInBinaryTree();

        TreeNode root = LevelOrderedTree.buildTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
//        solution.averageOfLevels(root).forEach(System.out::println);
        root = LevelOrderedTree.buildTree(new Integer[]{1, Integer.MAX_VALUE, Integer.MAX_VALUE});
        solution.averageOfLevels(root).forEach(System.out::println);

    }


    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return Collections.emptyList();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        List<Double> averages = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode leaf = queue.remove();
                Optional.ofNullable(leaf.right).ifPresent(queue::add);
                Optional.ofNullable(leaf.left).ifPresent(queue::add);
                sum += leaf.val;
            }
            double average = (double) sum / size;
            averages.add(average);
        }
        return averages;
    }

}
