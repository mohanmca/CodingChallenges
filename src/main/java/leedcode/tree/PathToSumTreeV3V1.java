package leedcode.tree;

import java.util.*;

/**
 * https://leetcode.com/problems/path-sum-iii/
 */
public class PathToSumTreeV3V1 {

    int count = 0;
    Map<TreeNode, Set<Integer>> callEnding = new HashMap<>();

    public static void main(String[] args) {
        PathToSumTreeV3V1 solution = new PathToSumTreeV3V1();
        TreeNode root = LevelOrderedTree.buildTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        System.out.println("Total - count" + solution.pathSum(root, 8));
        solution = new PathToSumTreeV3V1();
        root = LevelOrderedTree.buildTree(new Integer[]{1, null, 2, null, 3, null, 4, null, 5});
        System.out.println("Total - count" + solution.pathSum(root, 3));
    }


    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return count;

        return pathSumV1(root, targetSum, targetSum, new ArrayList<>());
//        return pathSum(root, targetSum, targetSum);
    }

    public int pathSum(TreeNode root, final int finalSum, final int revisedSum) {
        if (root == null)
            return count;

        if (revisedSum - root.val == 0) {
            if(!callEnding.getOrDefault(root, new HashSet<>()).contains(revisedSum)) {
                callEnding.getOrDefault(root, new HashSet<>()).add(revisedSum);
                count++;
            }
            pathSum(root.left, finalSum, finalSum);
            pathSum(root.right, finalSum, finalSum);
            return count;
        } else {
            pathSum(root.left, finalSum, revisedSum - root.val);
            pathSum(root.right, finalSum, revisedSum - root.val);
            pathSum(root.left, finalSum, finalSum);
            pathSum(root.right, finalSum, finalSum);
        }

        return count;
    }

    public int pathSumV1(TreeNode root, final int finalSum, final int revisedSum, List<Integer> nodes) {
        if (root == null)
            return count;

        List<Integer> currentList = new ArrayList<>(nodes);
        currentList.add(root.val);
        if (revisedSum - root.val == 0) {
            count++;
            printList(currentList, finalSum, revisedSum);
//            if (revisedSum != finalSum) {
//                pathSumV1(root.left, finalSum, finalSum, new ArrayList<Integer>());
//                pathSumV1(root.right, finalSum, finalSum, new ArrayList<Integer>());
//            }
//            return count;
        } else {
            pathSumV1(root.left, finalSum, revisedSum - root.val, currentList);
            pathSumV1(root.right, finalSum, revisedSum - root.val, currentList);
            pathSumV1(root.left, finalSum, finalSum, new ArrayList<Integer>());
            pathSumV1(root.right, finalSum, finalSum, new ArrayList<Integer>());
        }

        return count;
    }

    public void printList(List<Integer> nodes, int finalSum, int revisedSum) {
        System.out.printf("FinalSum :: %1$d - RevisedSum :: %2$d - Printing Path %3$s  \n", finalSum, revisedSum, Arrays.deepToString(nodes.toArray()));
    }


}
