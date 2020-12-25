import java.util.PriorityQueue;

public class PriorityQueuePro {
    PriorityQueue<NodePair> queue = new PriorityQueue<>();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[32m";
    public static final String ANSI_GREEN = "\u001B[36m";
    public static final String ANSI_WHITE = "\033[0;37m";   // WHITE

    public PriorityQueuePro() {}

    // O(3N...)
    public void add(NodePair pair) {
        // // That's old --> // Java lambda + final array to exchange result
        // final boolean[] updated = new boolean[2];
        // queue.forEach((nodePair -> {
        //     if (nodePair.equals(pair)) {
        //         updated[1] = true;
        //         if (pair.dis < nodePair.dis) {
        //             updated[0] = true;
        //         }
        //     }
        // }));
        //
        // if (updated[0]) {
        //     queue.remove(pair);
        //     queue.add(pair);
        // } else if (!updated[1]){
        //     queue.add(pair);
        // }
        queue.add(pair);

        if (Main.debug) {
            System.out.println(ANSI_GREEN + "A Pushing operation just executed: "+ ANSI_RESET + pair);
            display();
        }
    }

    public synchronized void display() {
        if (queue.isEmpty()) {
            System.out.print(ANSI_YELLOW + "EMPTY\n" + ANSI_RESET);
            return;
        }
        displayUsingBackTracking();
        System.out.println("\b\b\b\b");
        // System.out.println(ANSI_RESET);
    }

    public synchronized void displayUsingBackTracking() {
        if (queue.isEmpty()) return;

        NodePair pair = queue.poll();
        System.out.print(pair + " -> ");
        displayUsingBackTracking();
        queue.add(pair);
    }

    public boolean remove(NodePair pair) {
        boolean r = queue.remove(pair);
        if (Main.debug) {
            System.out.println(ANSI_GREEN + "\\u001B[31mA Removal operation just executed: " + ANSI_RESET + pair);
            display();
        }
        return r;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void clear() {
        System.out.println(ANSI_GREEN + "A Clear operation just executed." + ANSI_RESET);
        queue.clear();
    }

    public NodePair peek() {return queue.peek();}

    public NodePair poll() {
        NodePair polled = queue.poll();
        if (Main.debug) {
            System.out.println(ANSI_GREEN + "A Poll operation just executed: " + ANSI_RESET + polled);
            display();
        }
        return polled;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
