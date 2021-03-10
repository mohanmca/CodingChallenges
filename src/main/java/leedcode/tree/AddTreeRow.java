package leedcode.tree;

import java.util.*;

import leedcode.tree.TreeNode;

public class AddTreeRow {

    public static void main(String[] args) {
        AddTreeRow solution = new AddTreeRow();
        TreeNode node = LevelOrderedTree.sampleTree2();
        System.out.println(solution.addOneRow(node, 9, 2));
    }

    public TreeNode addOneRow(TreeNode node, int val, int d) {
        if (d == 1) return new TreeNode(val, node, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int depth = 0;
        while (!queue.isEmpty() && depth < d) {
            int N = queue.size();
            depth++;
            for (int i = 0; i < N; i++) {
                TreeNode n = queue.remove();
                if (depth == d - 1) {
                    n.left = new TreeNode(val, n.left, null);
                    n.right = new TreeNode(val, null, n.right);
                } else {
                    if (n.left != null)
                        queue.add(n.left);
                    if (n.right != null)
                        queue.add(n.right);
                }
            }
        }
        return node;
    }

}