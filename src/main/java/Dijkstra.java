import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.ConnectivityInspector;

public class Dijkstra {
    Map map;

    public Dijkstra(Graph<String, DistanceEdge> graph) {
        map = new Map(graph, false);
    }

    public Dijkstra(Graph<String, DistanceEdge> graph, boolean randomized) {
        map = new Map(graph, randomized);
    }

    public void findShortestPath(String origin, String target) {
        PriorityQueue queue = new PriorityQueue();
        String placeNow = origin;

        for (DistanceEdge edge: map.graph.edgesOf(placeNow)) {

            String another = edge.getAnother(placeNow);


        }

    }


}
