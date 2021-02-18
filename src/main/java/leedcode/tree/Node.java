package leedcode.tree;

import java.util.stream.IntStream;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {

    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    @Override
    public String toString() {
        return toString(2);
    }

    public String toString(int indentations) {
        String space = new String(new char[indentations]).replace("\0", " ");

        return space + "N{" +
                "V=" + val +
                ", L=" + (left == null ? "" : left.toString(indentations + 2)) +
                ", R=" + (right == null ? "" : right.toString(indentations + 2)) +
                ", H=" + hashCode() +
                ", N=" + (next == null ? "" : next.hashCode())  +
                "}\n";
    }
}
