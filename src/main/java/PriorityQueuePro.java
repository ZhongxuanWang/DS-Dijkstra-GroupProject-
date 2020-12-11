import java.util.PriorityQueue;

public class PriorityQueuePro {
    PriorityQueue<NodePair> queue = new PriorityQueue<>();

    public PriorityQueuePro() {

    }

    public void push(NodePair pair) {
        queue.add(pair);
    }

    public void display() {
        System.out.println(queue);
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
