import org.jgrapht.Graph;

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
        PriorityQueuePro queue = new PriorityQueuePro();
        String placeNow = origin;

        HashSet<String> knownPairs = new HashSet<>(12,2);
        knownPairs.add(placeNow);

        for (DistanceEdge edge: map.graph.edgesOf(placeNow)) {

            String another = edge.getAnother(placeNow);
            if (knownPairs.contains(another))
                continue;

            PriorityQueuePro adjacentQueue = new PriorityQueuePro();
            // TODO ABOVE IS WHAT I LEFT OFF

            NodePair pair = new NodePair(placeNow, another, edge.dis);

            queue.push(pair);
        }
        placeNow = queue.peek().another(placeNow);
        knownPairs.add(placeNow);


    }
    public void findShortestPath() {
        findShortestPath(map.start, map.end);
    }


}
