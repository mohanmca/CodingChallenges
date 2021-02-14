package leedcode.matrix;

import java.util.*;

public class BinaryShortestPath {

    public static void main(String[] args) {
        BinaryShortestPath sol = new BinaryShortestPath();

//        BinaryShortestPath bsp = new BinaryShortestPath();
//        int[][] items = {{0, 1}, {1, 0}};
//        System.out.println(sol.shortestPathBinaryMatrix(items));
//        int[][] items2 = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
//        System.out.println(sol.shortestPathBinaryMatrix(items2));
        int[][] items3 = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(sol.shortestPathBinaryMatrix(items3));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length * grid.length;
        Graph g = new Graph(n);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    int u = i * grid.length + j;
                    getNeighbours(grid, i, j)
                            .stream().filter(k -> {
                        int row = toRow(k, grid.length);
                        int column = toColumn(k, grid.length);
                        return grid[row][column] == 0;
                    }).forEach(v -> g.addEdge(u, v));
                }
            }
        }
        BFS bfs = new BFS(g);
        bfs.bfs(0);
        int length = bfs.shortestLength(n - 1);
        return length == Integer.MAX_VALUE ? -1 : length + 1;
    }

    public int toRow(int id, int n) {
        return id / n;
    }

    public int toColumn(int id, int n) {
        return id % n;
    }

    private Set<Integer> getNeighbours(int[][] grid, int row, int col) {
        int[] rows = {row - 1, row, row + 1};
        int[] columns = {col - 1, col, col + 1};
        Set<Integer> neighbours = new HashSet<>();
        for (int r : rows) {
            for (int c : columns) {
                if (r >= 0 && r < grid.length
                        && c >= 0 && c < grid.length
                ) {
                    if (!(row == r && col == c) && grid[r][c] == 0) {
                        neighbours.add(r * grid.length + c);
                    }
                }
            }
        }
        return neighbours;
    }

    private static class BFS {
        Graph g;
        int[] edgeTo;
        int[] seen;
        int[] length;

        public BFS(Graph g) {
            this.g = g;
            seen = new int[g.n];
            length = new int[g.n];
            edgeTo = new int[g.n];
            for (int i = 0; i < g.n; i++) {
                seen[i] = -1;
            }
            for (int i = 0; i < g.n; i++) {
                length[i] = Integer.MAX_VALUE;
            }
        }

        public void bfs(int u) {
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(u);
            edgeTo[u] = u;
            length[u] = 0;
            seen[u] = u;
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int k : g.neighbours(v)) {
                    if (seen[k] == -1) {
                        seen[k] = k;
                        queue.add(k);
                        length[k] = length[v] + 1;
                        edgeTo[k] = v;
                    } else if (seen[k] != -1 && length[k] > length[v] + 1) {
                        length[k] = length[v] + 1;
                        edgeTo[k] = v;
                    }
                }
            }
        }

        public int shortestLength(int v) {
            return length[v];
        }
    }

    public static class Graph {
        private final List[] vertices;
        private final int n;

        public Graph(int n) {
            this.n = n;
            vertices = new LinkedList[n];
        }

        public void addEdge(int u, int v) {
            validate(u);
            validate(v);
            if (vertices[u] == null) {
                vertices[u] = new LinkedList<Integer>();
            }
            if (vertices[v] == null) {
                vertices[v] = new LinkedList<Integer>();
            }
            if (u == v) {
                String formatted = String.format("Loop is not allowed! {u: %1$2d, v: %2$2d}", u, v);
                throw new IllegalStateException(formatted);
            }
            if (!vertices[u].contains(v))
                vertices[u].add(v);
            if (!vertices[v].contains(u))
                vertices[v].add(u);
        }

        public List<Integer> neighbours(int u) {
            return vertices[u] == null ? Collections.emptyList() : vertices[u];
        }

        private void validate(int u) {
            if (u < 0 || u > vertices.length) throw new IllegalStateException();
        }

        @Override
        public String toString() {
            return "Graph{" +
                    "vertices=" + Arrays.deepToString(vertices) +
                    ", n=" + n +
                    '}';
        }
    }
}
