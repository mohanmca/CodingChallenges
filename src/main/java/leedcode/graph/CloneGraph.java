package leedcode.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public static void main(String[] args) {
        Node rootNode = new Node();
        rootNode.val = 40;
        rootNode.neighbors = new LinkedList<Node>();
        for (int i = 1; i < 6; i++) {
            Node parentNode = new Node();
            parentNode.val = i;
            parentNode.neighbors = new LinkedList<Node>();
            rootNode.neighbors.add(parentNode);
            parentNode.neighbors.addAll(childNodesForRow(i));
        }
//        System.out.println(rootNode.toString());
        rootNode.neighbors.add(rootNode);
        System.out.println(rootNode);
        System.out.println(cloneGraph(rootNode));
    }

    private static List<Node> childNodesForRow(int row) {
        List<Node> nodes = new LinkedList<Node>();
        for (int j = 1; j < 6; j++) {
            Node node = new Node();
            node.val = row * 5 + j;
        }
        return nodes;
    }

    public static Node cloneGraph(Node graph) {
        if (graph == null) return null;
        return cloneGraph(graph, new HashMap<Integer, Node>());
    }

    public static Node cloneGraph(Node graph, Map<Integer, Node> connections) {
        if (graph == null) return null;
        Node clonedGraph = new Node();
        clonedGraph.val = graph.val;
        connections.put(clonedGraph.val, clonedGraph);
        if (graph.neighbors != null) {
            clonedGraph.neighbors = new LinkedList<Node>();
            for (Node node : graph.neighbors) {
                if (connections.containsKey(node.val)) {
                    clonedGraph.neighbors.add(connections.get(node.val));
                } else {
                    clonedGraph.neighbors.add(cloneGraph(node, connections));
                }
            }
        }
        return clonedGraph;
    }
}
