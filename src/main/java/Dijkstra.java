import org.jgrapht.Graph;

import java.util.HashMap;
import java.util.HashSet;

public class Dijkstra {
    Map map;

    public Dijkstra(Graph<String, DistanceEdge> graph) {
        map = new Map(graph, false);
    }

    public Dijkstra(Graph<String, DistanceEdge> graph, boolean randomized) {
        map = new Map(graph, randomized);
    }

    public void findShortestPath(String origin, String target) {
        map.dijkstraSwitch = true;
        PriorityQueuePro queue = new PriorityQueuePro();
        String placeNow = origin;

        HashSet<String> knownPairs = new HashSet<>(12,2);
        knownPairs.add(placeNow);

        // HashMap<String, Integer> cost = new HashMap<>(12, 2);

        boolean c = true; // continue
        String lastNode = "";
        int lastDis = 0;

        while (c) {
            c = false;

            // PriorityQueuePro adjacentQueue = new PriorityQueuePro();

            for (DistanceEdge edge: map.graph.edgesOf(placeNow)) {

                String another = edge.getAnother(placeNow);

                int cost = edge.dis;

                if (knownPairs.contains(another))
                    continue;

                c = true;

                NodePair pair = new NodePair(another, cost + lastDis);

                queue.push(pair);
            }
            // select the smallest distance
            NodePair n = minAdjNode(queue, knownPairs);
            if (n == null) break;
            placeNow = n.name;
            knownPairs.add(placeNow);

            lastDis = queue.peek().dis;

        }



    }
    public void findShortestPath() {
        findShortestPath(map.start, map.end);
        map.dijkstraSwitch = true;
    }

    /**
     * Use backtracking to determine the minimum adjacent node
     */
    NodePair minAdjNode(PriorityQueuePro queue, HashSet<String> s) {
        if (queue.queue.isEmpty()) {
            return null;
        }
        NodePair n = queue.poll();
        if (s.contains(n.name)) {
            NodePair p = minAdjNode(queue, s);
            queue.push(n);
            return p;
        }
        queue.push(n);
        return n;

    }


}
