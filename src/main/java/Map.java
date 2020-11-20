import java.util.HashMap;

public class Map {

    /**
     * Map information:
     * - Total Node: 14
     * - Max Connection of each node: 5
     */

    // Starting point
    Node root = new Node();
    int distanceSum = 0;


    public Map(boolean random_distance) {
        int[] distances = {
                3, 1, 12, 14, 10, 5, 3, 9, 7, 2, 6, 11, 13, 2, 4,
                // must be more...
        };
        if (random_distance) {
            for (int i = 0; i < 14; i ++) {
                distances[i] = (int) (Math.random() * 15 + 1);
            }
        }
        Node[] nodes = new Node[14];

        for (int i = 0; i < 14; i ++) {
            nodes[i] = new Node();
        }
    }

    public void summary() {
        System.out.println("Distance Covered so far:\t" + distanceSum);
    }



    static class Node {
        HashMap<Node, Integer> linkedNodes = new HashMap<>(5,1); // Max 5 connections
        String name;

        Node () {

        }

        @Override
        public String toString() {
            return "Node";
        }

        // @Override
        // public int compareTo(Node o) {
        //     int distance = linkedNodes.get(o);
        //     if ()
        //     return 0;
        // }
    }
}
