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
        // PriorityQueuePro queue = new PriorityQueuePro();
        String placeNow = origin;

        HashSet<String> knownPairs = new HashSet<>(12,2);
        HashMap<String, Integer> lastDistances = new HashMap<>(12,2);
        knownPairs.add(placeNow);

        HashMap<String, Integer> cmap = new HashMap<>(12, 2);

        boolean c = true; // continue
        String lastNode = "";
        int lastDis = 0;

        while (knownPairs.size() != 12) {

            PriorityQueuePro adjacentQueue = new PriorityQueuePro();

            for (DistanceEdge edge: map.graph.edgesOf(placeNow)) {

                String another = edge.getAnother(placeNow);

                if (knownPairs.contains(another))
                    continue;

                int cost = edge.dis;

                NodePair pair = new NodePair(another, cost + lastDis);

                adjacentQueue.push(pair);

                if (cmap.getOrDefault(placeNow, 1) == 1 || cmap.get(placeNow) > cost) {
                    cmap.put(placeNow, cost);
                }
            }

            if (adjacentQueue.queue.isEmpty()) continue;
            // TODO I Should expect to change lastDis, when nodes information is modified
            System.out.println(placeNow);
            knownPairs.add(placeNow);
            lastDis += adjacentQueue.peek().dis;
            placeNow = adjacentQueue.peek().name;
            System.out.println(cmap);
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
