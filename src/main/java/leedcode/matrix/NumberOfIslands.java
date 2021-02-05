package leedcode.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

public class NumberOfIslands {
    public static Function<Integer, BiFunction<Integer, Integer, Integer>> indexConverter = (Integer nColumns) -> (Integer row, Integer column) -> row * nColumns + column;
    public static Function<Integer, Function<Integer, Integer>> toRowConverter = (Integer nColumns) -> (Integer index) -> index / nColumns;
    public static Function<Integer, Function<Integer, Integer>> toColumnConverter = (Integer nColumns) -> (Integer index) -> index % nColumns;

    public static void main(String[] args) {
//        UnionDisjoint union = new UnionDisjoint(20);
//        union.join(2, 3);
//        union.join(5, 4);
//        union.join(12, 13);
//        union.join(15, 14);
//        union.join(12, 15);
//
//        System.out.println(union.connectedCompontens());
        char[][] items3 = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        System.out.println(numIslands(items3));

        char[][] items = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands(items));
        char[][] items2 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(items2));
    }

    public static int numIslands(char[][] grid) {
        int columns = grid[0].length;
        BiFunction<Integer, Integer, Integer> toIndex = indexConverter.apply(columns);
        int size = grid.length * grid[0].length;
        UnionDisjoint set = new UnionDisjoint(size);
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {

                int position = toIndex.apply(row, column);

                if (grid[row][column] == '1') {
                    if (row > 0 && grid[row - 1][column] == '1') {
                        int vert = toIndex.apply(row - 1, column);
                        set.join(vert, position);
                    }
                    if (column > 0 && grid[row][column - 1] == '1') {
                        int horizontal = toIndex.apply(row, column - 1);
                        set.join(horizontal, position);
                    } else {
                        set.join(position, position);
                    }
                }
            }
        }
        return set.connectedCompontens();
    }

    private static class UnionDisjoint {
        private final int[] ids;
        private int n = 0;

        public UnionDisjoint(int n) {
            this.n = n;
            ids = new int[n];
            Arrays.fill(ids, -1);
        }

        public int connectedCompontens() {
            Set<Integer> cc = new HashSet<>(ids.length);
            for (int item : ids) {
                if (item != -1) {
                    cc.add(item);
                }
            }
            return cc.size();
        }

        public void unSet(int i) {
            ids[i] = -1;
        }

        public void set(int i) {
            ids[i] = i;
        }

        public int join(int root, int newLeaf) {
            if (ids[root] == -1) set(root);
            if (ids[newLeaf] == -1) set(newLeaf);

            int newLeaftID = ids[newLeaf];   // needed for correctness
            int rootID = ids[root];   // to reduce the number of array accesses

            // p and q are already in the same component
            if (newLeaftID == rootID) return rootID;

            for (int i = 0; i < ids.length; i++)
                if (ids[i] == newLeaftID) ids[i] = rootID;
            return newLeaftID;
        }

        public int findRoot(int i) {
            int root = ids[i];
            while (root != ids[root])
                root = ids[root];
            return root;
        }

        @Override
        public String toString() {
            return "UnionDisjoint{" +
                    "ids=" + Arrays.toString(ids) +
                    ", n=" + n +
                    '}';
        }
    }
}
