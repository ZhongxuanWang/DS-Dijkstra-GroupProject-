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
        if (newNode.distance < node.distance) {
            newNode.next = node;
            root = newNode;
        }

        while (node.next != null) {
            node = node.next;
            if (newNode.distance < node.distance) {
                
            }

        }

    }
}