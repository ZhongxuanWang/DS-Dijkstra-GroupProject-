import org.jgrapht.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Dijkstra {
    Map map;

    public Dijkstra(Graph<String, DistanceEdge> graph) {
        map = new Map(graph, false);
    }

    public Dijkstra(Graph<String, DistanceEdge> graph, boolean randomized) {
        map = new Map(graph, randomized);
    }


    /**
     * Our unique solution, with neither reliance nor reference on outer codes on much others, except about what is dijkstra,
     * and this: https://www.cs.usfca.edu/~galles/visualization/Dijkstra.html
     */
    public void findShortestPath(String origin, String target) {
        map.dijkstraSwitch = true;
        // PriorityQueuePro queue = new PriorityQueuePro();
        String placeNow = origin;

        HashSet<String> knownPairs = new HashSet<>(12,2);
        HashMap<String, Integer> lastDistances = new HashMap<>(12,2);
        // knownPairs.add(placeNow);

        HashMap<String, Integer> cmap = new HashMap<>(12, 2);

        boolean c = true; // continue
        String lastNode = "";
        int lastDis = 0;

        PriorityQueuePro[] adjacentQueues = new PriorityQueuePro[12];

        for (int i = 0; i < 12; i ++) {
            adjacentQueues[i] = new PriorityQueuePro();
        }
        boolean test = false;
        a:
        while (knownPairs.size() != 12) {
            test = true;

            PriorityQueuePro adjacentQueue = adjacentQueues[str2Ind(placeNow)];
            knownPairs.add(placeNow);

            PriorityQueuePro thisQueue = new PriorityQueuePro();

            for (DistanceEdge edge: map.graph.edgesOf(placeNow)) {

                String another = edge.getAnother(placeNow);

                if (knownPairs.contains(another))
                    continue;

                test = false;

                int cost = edge.dis;

                NodePair pair = new NodePair(another, cost + lastDis, placeNow);

                thisQueue.push(pair);

                if (cmap.getOrDefault(another, 1) == 1 || cmap.get(another) > cost + lastDis)
                    cmap.put(another, cost + lastDis);

            }

            if (test) {
                for (String vertex : map.allNodes) {
                    if (!knownPairs.contains(vertex)) {
                        // lastDis = adjacentQueues[str2Ind(vertex)].peek().dis;
                        lastDis = 0;
                        placeNow = vertex;
                        // knownPairs.add(placeNow);
                        continue a;
                    }
                }
            }
            if (!thisQueue.queue.isEmpty()) {
                adjacentQueues[str2Ind(placeNow)].push(thisQueue.peek());
                lastDis = thisQueue.peek().dis;
                placeNow = thisQueue.peek().name;
                knownPairs.add(placeNow);
            }
        }

        System.out.printf("Cmap: %s\n", cmap);



    }
    public void findShortestPath() {
        findShortestPath(map.start, map.end);
        map.dijkstraSwitch = true;
    }

    // /**
    //  * Use backtracking to determine the minimum adjacent node
    //  */
    // @Deprecated
    // NodePair minAdjNode(PriorityQueuePro queue, HashSet<String> s) {
    //     if (queue.queue.isEmpty()) {
    //         return null;
    //     }
    //     NodePair n = queue.poll();
    //     if (s.contains(n.name)) {
    //         NodePair p = minAdjNode(queue, s);
    //         queue.push(n);
    //         return p;
    //     }
    //     queue.push(n);
    //     return n;
    //
    //
    // }

    int str2Ind(String str) {
        return str.charAt(0)-'A';
    }


}
