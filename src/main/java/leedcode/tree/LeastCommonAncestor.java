package leedcode.tree;

import java.util.*;

public class LeastCommonAncestor {
    private TreeNode ans = null;

    public static void main(String[] args) {
        LeastCommonAncestor solution = new LeastCommonAncestor();
        TreeNode left = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(6);
        TreeNode right = new TreeNode(4, p, q);
        TreeNode root = new TreeNode(7, left, right);
//        System.out.println(root);
//        System.out.println(solution.lowestCommonAncestorV3(root, p, q));
//        System.out.println(solution.lowestCommonAncestorV3(root, p, q));
        System.out.println(solution.lowestCommonAncestor(root, p, q));
        p = new TreeNode(3);
        root = new TreeNode(7, p, null);
//        System.out.println(root);
        System.out.println(solution.lowestCommonAncestor(root, p, root));
//        System.out.println(solution.lowestCommonAncestorV3(root, p, root));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        findAncestor(root, p, q);
        return ans;
    }


    public int findAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;
        int left = findAncestor(root.left, p, q);
        int right = findAncestor(root.right, p, q);
        int mid = (root.val == p.val || root.val == q.val) ? 1 : 0;
        if (left + right + mid == 2 && ans == null) {
            ans = root;
        }
        return left + mid + right;
    }

    public TreeNode lowestCommonAncestorV3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.add(root);
        boolean notFound = true;
        while (notFound && !deque.isEmpty()) {
            TreeNode node = deque.pop();
            if (node.left != null) {
                parents.put(node.left, node);
                deque.add(node.left);
            }
            if (node.right != null) {
                parents.put(node.right, node);
                deque.add(node.right);
            }
            notFound = parents.get(p) == null || parents.get(q) == null;
        }

        Set<TreeNode> ancestors = new HashSet<TreeNode>();
        while (p != null) {
            ancestors.add(p);
            p = parents.get(p);
        }
        while (q != null) {
            if (ancestors.contains(q)) {
                return q;
            }
            q = parents.get(q);
        }
        return null;
    }
}

