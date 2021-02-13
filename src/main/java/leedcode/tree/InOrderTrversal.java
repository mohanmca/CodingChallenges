package leedcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class InOrderTrversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(2), new TreeNode(1));
        InOrderTrversal solution = new InOrderTrversal();
        Object[] values = solution.inorderTraversal(root).toArray();
        System.out.println(Arrays.deepToString(values));
        values = solution.inorderTraversal(null).toArray();
        System.out.println(Arrays.deepToString(values));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            answer.add(root.val);
            root = root.right;
        }
        return answer;
    }

    public List<Integer> inorderTraversalV1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> leftNodes = inorderTraversalV1(root.left);
        leftNodes.add(root.val);
        List<Integer> rightNodes = inorderTraversalV1(root.right);
        leftNodes.addAll(rightNodes);
        return leftNodes;
    }
}
