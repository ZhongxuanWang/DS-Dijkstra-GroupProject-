import java.util.PriorityQueue;

public class PriorityQueuePro {
    PriorityQueue<NodePair> queue = new PriorityQueue<>();

    public PriorityQueuePro() {}

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

    public boolean remove(NodePair pair) {
        return queue.remove(pair);
    }

    public void clear() {queue.clear();}

    public NodePair peek() {return queue.peek();}

    public NodePair poll() {return queue.poll();}

    @Override
    public String toString() {
        return queue.toString();
    }
}
