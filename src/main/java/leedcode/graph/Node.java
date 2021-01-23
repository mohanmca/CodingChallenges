package leedcode.graph;

import java.util.*;

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        neighbors = Collections.emptyList();
    }

    @Override
    public String toString() {
        HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
        visited.put(val, val);
//        return "Node{val=" + val + neighbourToString(visited) + ",hash=" + this.hashCode() + "}";
        return "Node{val=" + val + neighbourToString(visited) +"}";
    }

    public String neighbourToString(Map<Integer, Integer> visited) {
        if (neighbors.isEmpty()) return "";


        StringBuilder sb = new StringBuilder();

        for (Node node : neighbors) {
            if (!visited.containsKey(node.val)) {
                sb.append(node.toString());
                visited.put(node.val, node.val);
            }
        }
        return sb.toString();

    }

}
