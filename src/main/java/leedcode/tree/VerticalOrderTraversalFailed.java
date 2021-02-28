package leedcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerticalOrderTraversalFailed {
    public static void main(String[] args) {
        TreeNode rightTree = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode rootTree = new TreeNode(3, new TreeNode(9), rightTree);
        System.out.println(verticalTraversal(rootTree));
        System.out.println(verticalTraversal(new TreeNode(15)));
        TreeNode leftTree = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        rightTree = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        rootTree = new TreeNode(1, leftTree, rightTree);
        System.out.println(verticalTraversal(rootTree));
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        return formOrder(zigzagVerticalTraversal(root));
    }

    public static List<List<Integer>> zigzagVerticalTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();

        ArrayList<List<Integer>> finalReport = new ArrayList();

        ArrayList<Integer> container = new ArrayList<Integer>();
        container.add(root.val);
        finalReport.add(container);

        if (root.left != null) {
            List<List<Integer>> leftResult = zigzagVerticalTraversal(root.left);
            aggregate(leftResult, finalReport, -1);
        }
        if (root.right != null) {
            List<List<Integer>> rightResult = zigzagVerticalTraversal(root.right);
            aggregate(rightResult, finalReport, 1);
        }
        return finalReport;
    }

    private static void aggregate(List<List<Integer>> nodeResults, ArrayList<List<Integer>> finalReport, int offset) {
        int i = 0;
        for (List<Integer> xCordResult : nodeResults) {
            int xCord = fromIndexToCordinate(i);
            set(finalReport, xCordResult, xCord + offset);
            i++;
        }
    }

    public static void set(List<List<Integer>> aggregated, List<Integer> result, int xCord) {
        int index = fromCordinateToIndex(xCord);
        if (aggregated.size() < index + 1) {
            int count = (index - aggregated.size()) + 1;
            while (count-- > 0) {
                aggregated.add(new ArrayList<Integer>());
            }
        }
        aggregated.get(index).addAll(result);
        Collections.sort(aggregated.get(index));
    }

    public static List<List<Integer>> formOrder(List<List<Integer>> result) {
        int i = 0;
        List<List<Integer>> orderedResult = new ArrayList<>();
        for (List<Integer> xCordResult : result) {
            if (!xCordResult.isEmpty()) {
                int xCord = fromIndexToCordinate(i);
                if (xCord < 0) {
                    orderedResult.add(0, xCordResult);
                } else {
                    orderedResult.add(xCordResult);
                }
            }
            i++;
        }
        return orderedResult;
    }

    public static int fromCordinateToIndex(int j) {
        int index = j < 0 ? Math.abs(j) * 2 - 1 : j * 2;
        return index;
    }

    public static int fromIndexToCordinate(int i) {
        if (i == 0) return 0;
        if (i == 1) return -1;
        return i % 2 == 0 ? i / 2 : (i / 2) * -1;
    }


}
