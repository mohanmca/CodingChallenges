package leedcode.tree;

import java.util.*;

public class PostOrderTrversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(5), null));
        PostOrderTrversal solution = new PostOrderTrversal();
        Object[] values = solution.postorderTraversal(root).toArray();
        System.out.println(Arrays.deepToString(values));
        values = solution.postorderTraversal(null).toArray();
        System.out.println(Arrays.deepToString(values));

        System.out.println(Arrays.deepToString(values));
    }



    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Stack<TreeNode> reversePostOrder = new Stack<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        List<Integer> answer = new ArrayList<>();
        while (!stack.isEmpty()) {
            root = stack.pop();
            reversePostOrder.add(root);
            if (root.left != null)
                stack.add(root.left);
            if (root.right != null)
                stack.add(root.right);
        }
        while (!reversePostOrder.isEmpty()) {
            answer.add(reversePostOrder.pop().val);
        }
        return answer;
    }
}


