import java.util.Queue;

public class PriorityQueue {

    /**
     * A priority Queue in Java, designed for Dijkstra.
     *
     * - Under the scene, it uses a LinkedList, with the root represents the smallest value
     */

    Node root;
    int size;

    PriorityQueue() {
        this.size = 0;
    }

    public void add(int distance) {
        if (root == null) {
            root = new Node(distance, null);
            size ++;
            return;
        }

        Node node = root;
        Node newNode = new Node(distance, null);
        if (node.next == null) {
            if (newNode.distance < node.distance) {
                newNode.next = node;
                root = newNode;
            }
            return;
        }

        while (node.next != null) {
            node = node.next;
        }
    }
}