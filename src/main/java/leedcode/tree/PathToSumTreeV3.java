package leedcode.tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/path-sum-iii/
 */
public class PathToSumTreeV3 {


    public static void main(String[] args) {
        PathToSumTreeV3 solution = new PathToSumTreeV3();
        TreeNode root = LevelOrderedTree.buildTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        System.out.println("Total - count" + solution.pathSum(root, 8));
        solution = new PathToSumTreeV3();
        root = LevelOrderedTree.buildTree(new Integer[]{1, null, 2, null, 3, null, 4, null, 5});
        System.out.println("Total - count" + solution.pathSum(root, 3));
    }


    public int pathSum(TreeNode root, int targetSum) {
        Pair result = permutations(root);
        int count = (int) result.left.stream().filter(list -> list.stream().reduce(0, Integer::sum) == targetSum).count();
        count += (int) result.right.stream().filter(list -> list.stream().reduce(0, Integer::sum) == targetSum).count();
        return count;
    }


    public Pair permutations(TreeNode root) {
        if (root == null) return Pair.of(Collections.emptyList(), Collections.emptyList());
        Pair lp = permutations(root.left);
        Pair rp = permutations(root.right);
        List<List<Integer>> output = new ArrayList<>();
        for (List<Integer> perm : lp.left) {
            output.add(new ArrayList<>(perm) {{
                add(root.val);
            }});
        }
        for (List<Integer> perm : rp.left) {
            output.add(new ArrayList<>(perm) {{
                add(root.val);
            }});
        }
        output.add(Collections.singletonList(root.val));

        List<List<Integer>> output2 = new ArrayList<>();
        output2.addAll(lp.left);
        output2.addAll(lp.right);
        output2.addAll(rp.right);
        output2.addAll(rp.left);
        return Pair.of(output, output2);
    }


    public void printList(List<Integer> nodes, int finalSum, int revisedSum) {
        System.out.printf("FinalSum :: %1$d - RevisedSum :: %2$d - Printing Path %3$s  \n", finalSum, revisedSum, Arrays.deepToString(nodes.toArray()));
    }

    static class Pair {
        public List<List<Integer>> left;
        public List<List<Integer>> right;

        public static Pair of(List<List<Integer>> left, List<List<Integer>> right) {
            Pair p = new Pair();
            p.left = left;
            p.right = right;
            return p;
        }
    }


}
