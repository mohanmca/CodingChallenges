package leedcode.tree;

import java.util.*;
import java.util.stream.Collectors;

public class SerializeAndDerserialize {
    public static void main(String[] args) {
        SerializeAndDerserialize solution = new SerializeAndDerserialize();
        TreeNode left = new TreeNode(3, new TreeNode(2), new TreeNode(1));
        TreeNode right = new TreeNode(3, new TreeNode(2), new TreeNode(1));
        TreeNode root = new TreeNode(7, left, right);
        String treeInString = solution.serialize(root);
        TreeNode newRoot = solution.deserialize(treeInString);
        String newTreeInString = solution.serialize(newRoot);
        System.out.println("Awesome!" + newTreeInString);
        if (newTreeInString.equals(treeInString)) {
            System.out.println("Awesome!");
        } else {
            System.out.println("Failed!");
            throw new IllegalStateException("Worst!");
        }
    }

    public TreeNode deserialize(String treeInString) {
        String[] elements = treeInString.split("~");
        Queue<String> items = new LinkedList<>( Arrays.asList(elements));
        String rootVal = items.remove();
        Queue<TreeNode> queueNodes = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(rootVal));
        queueNodes.add(root);
        int depth = 0;
        while (!queueNodes.isEmpty()) {
            int numberOfNodes = (int) Math.pow(2, depth++);
            for (int i = 0; i < numberOfNodes; i++) {
                TreeNode node = queueNodes.remove();
                node.left = parseNode(items.remove());
                if (node.left != null)
                    queueNodes.add(node.left);
                node.right = parseNode(items.remove());
                if (node.right != null)
                    queueNodes.add(node.right);
            }
        }
        return root;
    }

    public TreeNode parseNode(String anItem) {
        if (!anItem.equals("null")) {
            return new TreeNode(Integer.parseInt(anItem));
        } else return null;
    }

    public String serialize(TreeNode root) {
        ArrayList<Integer> items = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node != null) {
                items.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                items.add(null);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer item : items) {
            sb.append(item);
            sb.append("~");
        }
        return sb.substring(0, sb.length() - 1);
    }


}
