import java.util.PriorityQueue;

public class PriorityQueuePro {
    PriorityQueue<NodePair> queue = new PriorityQueue<>();

    public PriorityQueuePro() {

    }

    public void push(NodePair pair) {
        final boolean[] updated = new boolean[1];
        queue.forEach((nodePair -> {
            if (nodePair.equals(pair)) {
                nodePair.dis = Math.min(pair.dis, nodePair.dis);
                updated[0] = true;
            }
        }));
        if (!updated[0])
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
