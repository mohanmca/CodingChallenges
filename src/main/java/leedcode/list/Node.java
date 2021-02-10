package leedcode.list;

public class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + (next != null ? next.toString() : "null") +
                ", hashcode=" + this.hashCode() + ", " +
                ", random=" + (random != null ? random.hashCode() : "null") +
                '}';
    }
}
