import java.util.PriorityQueue;

public class PriorityQueuePro {
    PriorityQueue<NodePair> queue = new PriorityQueue<>();

    public PriorityQueuePro() {}

    public void push(NodePair pair) {
        // Java lambda + final array to exchange result
        final boolean[] updated = new boolean[1];
        queue.forEach((nodePair -> {
            if (nodePair.equals(pair)) {
                nodePair.dis = Math.min(pair.dis, nodePair.dis);
                updated[0] = true;
            }
        }));

        if (!updated[0])
            queue.add(pair);

        if (Main.debug) {
            System.out.println("A Pushing operation just executed: " + pair);
            display();
        }
    }

    public void display() {
        System.out.println(queue);
    }

    public boolean remove(NodePair pair) {
        boolean r = queue.remove(pair);
        if (Main.debug) {
            System.out.println("A Removal operation just executed: " + pair);
            display();
        }
        return r;
    }

    public void clear() {
        System.out.println("A Clear operation just executed.\nnull");
        queue.clear();
    }

    public NodePair peek() {return queue.peek();}

    public NodePair poll() {
        NodePair polled = queue.poll();
        if (Main.debug) {
            System.out.println("A Poll operation just executed: " + polled);
            display();
        }
        return polled;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
