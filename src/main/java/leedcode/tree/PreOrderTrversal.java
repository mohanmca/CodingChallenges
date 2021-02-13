package leedcode.tree;

import java.util.*;

public class PreOrderTrversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(2), new TreeNode(1));
        PreOrderTrversal solution = new PreOrderTrversal();
        Object[] values = solution.preorderTraversal(root).toArray();
        System.out.println(Arrays.deepToString(values));
        values = solution.preorderTraversal(null).toArray();
        System.out.println(Arrays.deepToString(values));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> answer = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                answer.add(root.val);
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;
        }
        return answer;
    }

    public List<Integer> preorderTraversalV1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        List<Integer> leftNodes = preorderTraversalV1(root.left);
        List<Integer> rightNodes = preorderTraversalV1(root.right);
        result.addAll(leftNodes);
        result.addAll(rightNodes);
        return result;
    }
}
