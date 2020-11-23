import org.jgrapht.Graph;
import org.jgrapht.generate.GnmRandomGraphGenerator;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.util.SupplierUtil;

import java.util.Iterator;
import java.util.Queue;
import java.util.function.Supplier;

public class PriorityQueue {

    /**
     * A priority Queue in Java, designed for Dijkstra.
     *
     * - Under the scene, it uses a LinkedList, with the root represents the smallest value
     */

    Node root;

    PriorityQueue() {

    }

    public void add(int distance, String to, String from) {
        if (root == null) {
            root = new Node(distance, to, from);
            return;
        }

        Node node = root;
        Node newNode = new Node(distance, to, from);
        if (newNode.distance < node.distance) {
            newNode.next = node;
            root = newNode;
        }

        while (node.next != null) {
            if (newNode.distance > node.next.distance) {
                Node temp = node.next;
                newNode.setNext(node.next.next);
                // Avoid any kinds of memory add mess!
                node.setNext(new Node(temp.distance, temp.to, temp.from, newNode));
            }
        }

    }

    public void clear() {
        this.root = null;
    }

}