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
        while (knownPairs.size() != 12) {
            PriorityQueuePro tempQueue = new PriorityQueuePro();
            for (DistanceEdge edge: map.graph.edgesOf(placeNow)) {
                String thisNode = edge.getAnother(placeNow);
                if (knownPairs.contains(thisNode)) continue;
                int distance = edge.dis;

                NodePair pair = new NodePair(thisNode, distance + lastDis, placeNow);

                tempQueue.push(pair);


            }

            if (tempQueue.queue.isEmpty()) {
                for (String node : map.allNodes) {
                    if (!knownPairs.contains(node)) {
                        placeNow = node;
                        knownPairs.add(placeNow);
                        break;
                    }
                }
                System.out.println("Oops");
            } else {
                placeNow = tempQueue.peek().name;
                int distance = tempQueue.peek().dis;

                // update the big map
                if (cmap.getOrDefault(placeNow, -1) == -1) {
                    cmap.put(placeNow, distance);
                } else if (cmap.get(placeNow) > distance + lastDis) {
                    cmap.put(placeNow, distance + lastDis);
                }

                lastDis = distance;

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
