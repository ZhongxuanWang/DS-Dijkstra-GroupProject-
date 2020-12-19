import java.util.PriorityQueue;

public class PriorityQueuePro {
    PriorityQueue<NodePair> queue = new PriorityQueue<>();

    public PriorityQueuePro() {}

    // O(3N...)
    public void push(NodePair pair) {
        // That's old --> // Java lambda + final array to exchange result
        final boolean[] updated = new boolean[2];
        queue.forEach((nodePair -> {
            if (nodePair.equals(pair)) {
                updated[1] = true;
                if (pair.dis < nodePair.dis) {
                    updated[0] = true;
                }
            }
        }));

        if (updated[0]) {
            queue.remove(pair);
            queue.add(pair);
        } else if (!updated[1]){
            queue.add(pair);
        }

        if (Main.debug) {
            System.out.println("A Pushing operation just executed: " + pair);
            // display();
        }
    }

    public synchronized void display() {
        // System.out.println(queue);
        displayUsingBackTracking();
    }

    public synchronized void displayUsingBackTracking() {
        if (queue.isEmpty()) return;

        NodePair pair = queue.poll();
        System.out.println(pair);
        displayUsingBackTracking();
        queue.add(pair);
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
