package leedcode.tree;

import java.util.*;

public class LevelOrderedTree {
    public static void main(String[] args) {
        Integer[] nums = {4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2};
        layerTheTree(nums);
        TreeNode tree = buildTree(nums);
        printLevelOrder(tree);
        TreeNode tree2 = buildTreeV1(nums);
        printLevelOrder(tree2);
    }

    public static int log2(int n) {
        return (int) (Math.log(n) / Math.log(2));
    }

    public static boolean isPowerOf2(int n) {
        return Math.ceil(Math.log(n) / Math.log(2)) == Math.floor(Math.log(n) / Math.log(2));
    }

    public static TreeNode buildTree(Integer[] nums) {
        int i = 0;
        TreeNode root = (nums[i] == null ? null : new TreeNode(nums[i++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty() && i < nums.length) {
            TreeNode node = queue.poll();
            TreeNode leftChild = (nums[i] == null ? null : new TreeNode(nums[i]));
            if (leftChild != null) {
                node.left = leftChild;
                queue.add(leftChild);
            }
            if (++i < nums.length) {
                TreeNode rightChild = (nums[i] == null ? null : new TreeNode(nums[i]));
                i++;
                if (rightChild != null) {
                    node.right = rightChild;
                    queue.add(rightChild);
                }
            }
        }
        return root;
    }

    public static List<List<Integer>> layerTheTree(Integer[] levelOrdered) {
        List<List<Integer>> tree = new ArrayList<>();
        int treeHeight = log2(levelOrdered.length);
        treeHeight += isPowerOf2(levelOrdered.length) ? 1 : 2;

        for (int height = 1; height < treeHeight; height++) {
            int fromIndex = (int) Math.pow(2, height - 1) - 1;
            int toIndex = (int) Math.pow(2, height) - 1;
            toIndex = Math.min(toIndex, levelOrdered.length);
            List<Integer> nodesAtLevel = new ArrayList<>(toIndex - fromIndex);
            nodesAtLevel.addAll(Arrays.asList(levelOrdered).subList(fromIndex, toIndex));
            tree.add(nodesAtLevel);
        }
        tree.forEach(li -> System.out.println(Arrays.deepToString(li.toArray(new Integer[li.size()]))));
        return tree;
    }

    public static TreeNode buildTreeV1(Integer[] arr) {
        TreeNode root = null;
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        TreeNode t = arr[i] == null ? null : new TreeNode(arr[i]);
        root = t;
        q.add(root);
        i++;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode t1 = q.poll();
            if (t1 != null) {
                t1.left = arr[i] == null ? null : new TreeNode(arr[i]);
                q.add(t1.left);
                i++;
                if (i >= arr.length) {
                    break;
                }
                t1.right = arr[i] == null ? null : new TreeNode(arr[i]);
                q.add(t1.right);
                i++;
            }
        }
        return root;
    }

    private static void printLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            sb.append(t == null ? "null" : t.val).append(", ");
            if (t != null) {
                q.add(t.left);
                q.add(t.right);
            }
        }
        System.out.println(sb.toString());
    }


}
