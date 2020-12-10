import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;
import org.jgrapht.traverse.DepthFirstIterator;

import java.util.*;

/**
 * 12 nodes
 * 21 connections
 */
public class Map {
    // By default 'SimpleGraph' is undirected
    int total_dis = 0;
    Graph<String, DistanceEdge> graph = new DefaultUndirectedGraph<>(DistanceEdge.class);
    ConnectivityInspector<String, DistanceEdge> inspector = new ConnectivityInspector<>(graph);
    String start = "";
    String end = "";
    String now = "";

    boolean dijkstraSwitch = false;

    Map (Graph<String, DistanceEdge> g, boolean random) {
        graph = g;
        int[] arr;
        if (!random) {
            arr = new int[] {
                3, 5, 10, 1, 6, 3, 7, 2, 9, 11,
                4, 9, 3, 7, 10, 2, 5, 8, 6, 4, 5, 1
            };
        } else {
            arr = new int[22];
            for (int i = 0; i <= 21; i++)
                arr[i] = (int) (Math.random() * 11 + 1);
        }

        graph.addEdge("A", "B", new DistanceEdge(arr[0]));
        graph.addEdge("A", "G", new DistanceEdge(arr[1]));
        graph.addEdge("A", "J", new DistanceEdge(arr[2]));
        graph.addEdge("B", "C", new DistanceEdge(arr[3]));
        graph.addEdge("B", "E", new DistanceEdge(arr[4]));
        graph.addEdge("C", "E", new DistanceEdge(arr[5]));
        graph.addEdge("C", "D", new DistanceEdge(arr[6]));
        graph.addEdge("C", "F", new DistanceEdge(arr[7]));
        graph.addEdge("D", "F", new DistanceEdge(arr[8]));
        graph.addEdge("D", "I", new DistanceEdge(arr[9]));
        graph.addEdge("E", "G", new DistanceEdge(arr[10]));
        graph.addEdge("E", "H", new DistanceEdge(arr[11]));
        graph.addEdge("F", "H", new DistanceEdge(arr[12]));
        graph.addEdge("F", "I", new DistanceEdge(arr[13]));
        graph.addEdge("G", "J", new DistanceEdge(arr[14]));
        graph.addEdge("G", "K", new DistanceEdge(arr[15]));
        graph.addEdge("H", "I", new DistanceEdge(arr[16]));
        graph.addEdge("H", "K", new DistanceEdge(arr[17]));
        graph.addEdge("H", "L", new DistanceEdge(arr[18]));
        graph.addEdge("I", "L", new DistanceEdge(arr[19]));
        graph.addEdge("J", "K", new DistanceEdge(arr[20]));
        graph.addEdge("K", "L", new DistanceEdge(arr[21]));


    }

    public void setStart(String start) {
        this.start = start;
        setNow(start);
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public void summary() {
        if (start.isEmpty() || end.isEmpty()) {
            System.out.println("HEY! Why would you want a summary if you haven't told your starting or ending " +
                    "point yet ?! ");
            return;
        }
        if (!dijkstraSwitch) {
            System.out.println("Hey! Haven't ran our Dijkstra yet, why would you want our summary!? ");
            return;
        }
        DijkstraShortestPath<String, DistanceEdge> dijkstraAlg = new DijkstraShortestPath<>(graph);

        int total_dis_jgrapht = 0;

        for (DistanceEdge edge : dijkstraAlg.getPaths(start).getPath(end).getEdgeList()) {
            total_dis_jgrapht += edge.dis;
        }
        System.out.println("-".repeat(70));
        System.out.printf("Summary!\n" +
                "Our Dijkstra Min Distance: %s \n" +
                "JGraphT Dijkstra Min Distance: %s\n", total_dis, total_dis_jgrapht);
        if (total_dis_jgrapht != total_dis) {
            System.out.println("HOLD ON!! What just happened!?");
        }
        System.out.println("-".repeat(70));
        dijkstraSwitch = false;
    }

    void mapTraversalDepthFirst() {
        Iterator<String> iter = new DepthFirstIterator<>(graph);
        while (iter.hasNext()) {
            String vertex = iter.next();
            System.out.println(
                    "Vertex " + vertex + " is connected to: "
                            + graph.edgesOf(vertex).toString()
            );
        }
    }

    @Deprecated
    void dijkstraFind() {
        // Initialize
        HashSet<String> unvisitedNodes = new HashSet<>(13,1);
        unvisitedNodes.addAll(
                Arrays.asList(
                        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"
                )
        );

        unvisitedNodes.remove(start);
        //      Node    Cost
        HashMap<NodePair, Integer> nodeTable = new HashMap<>(13,1);

        for (String e : unvisitedNodes) {
            // nodeTable.put(new NodePair(e), Integer.MAX_VALUE);
        }

        // nodeTable.put(new NodePair(start), 0);

        // Begin!

        PriorityQueue queue = new PriorityQueue();

        String nowTemp = now;
        boolean stop = false;

        while (!stop) {
            for (DistanceEdge edge : graph.edgesOf(nowTemp)) {
                String target = edge.getTarget();
                if (edge.dis > nodeTable.get(target)) {
                    // nodeTable.put(target)
                }
            }
            stop = true;
        }





        ArrayList<String> arrayList = new ArrayList<>();
        dijkstraSwitch = true;


        System.out.println(graph.getAllEdges(start, end));
        // arrayList.add();
    }

    String availableRoutesSet() {
        HashMap<String, Integer> hashMap = new HashMap<>(5,1);
        for (String str : Graphs.neighborListOf(graph, now)) {
            hashMap.put(str, graph.getEdge(now, str).dis);
        }
        return hashMap.toString();
    }


    /**
     * For mode 1
     *
     * Prerequisite: Valid direct connection
     */
    void goTo(String dest) {
        total_dis += graph.getEdge(now, dest).dis;
        now = dest;
        if (now.equals(end)) {
            System.out.println("What?! You have reached your destination?!! You are so unbelievable! ");
            liveSummary();
            Main.stop = true;
        }
    }

    void liveSummary() {
        System.out.printf("You are now at: %s (aim:%s) \n", now, end);
        System.out.printf("Distance covered: %s \n", total_dis);
    }
}
