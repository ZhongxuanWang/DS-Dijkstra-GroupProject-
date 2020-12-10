/**
 * It's also called heap!
 *
 */
@Deprecated
public class PriorityQueue {

    /**
     * A priority Queue in Java, designed for Dijkstra.
     *
     * Despite its name contains the word "queue", its behavior is different than Queue. (also priorityQueue = Heap)
     *
     * It doesn't follow Queue's methods, and it doesn't follow FIFO Rule as well.
     *
     * - Under the scene, it uses a LinkedList, with the root represents the smallest value
     */

    Node root;

    PriorityQueue() {

    }

    public void push(int distance, String to, String from) {
        if (root == null) {
            root = new Node(distance, to, from);
            return;
        }

        Node newNode = new Node(distance, to, from);
        if (newNode.distance < root.distance) {
            if (newNode.equalPath(root)) {
                root.distance = distance;
                return;
            }
            newNode.next = new Node(root.distance, root.to, root.from, root.next);
            root = newNode;
            return;
        } else if (root.next == null) {
            root.setNext(newNode);
            return;
        }

        Node node = root;

        while (node.next != null && newNode.distance > node.next.distance && !newNode.equalPath(node)) {
            node = node.next;
        }
        // newNode<=thisNode.next && node.next == null
        if (node.equalPath(newNode)) {
            node.distance = newNode.distance;
        }
        if (node.next == null) {
            node.setNext(newNode);
            return;
        }
        newNode.setNext(node.next);
        // Avoid any kinds of memory add mess!
        node.setNext(newNode);
    }

    public Node pop() {
        if (root == null)
            return null;

        Node node = new Node(root.distance, root.to, root.from);
        root = root.next;
        return node;
    }

    public Node peek() {
        return root;
    }

    public void clear() {
        this.root = null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node node = root;
        while (node != null) {
            stringBuilder.append(node.toString()).append(" || ");
            node = node.next;
        }
        return stringBuilder.toString();
    }
}