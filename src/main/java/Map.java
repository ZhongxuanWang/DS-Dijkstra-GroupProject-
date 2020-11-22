import org.jgrapht.Graph;
import org.jgrapht.generate.GnmRandomGraphGenerator;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.DepthFirstIterator;

import java.util.Iterator;
import java.util.Random;
import java.util.function.Supplier;

/**
 * 12 nodes
 * 21 connections
 */
public class Map {
    // By default 'SimpleGraph' is undirected
    Graph<String, DistanceEdge> graph = new SimpleGraph<>(DistanceEdge.class);

    Map (boolean random) {
        graph.addVertex();
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

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        graph.addVertex("J");
        graph.addVertex("K");
        graph.addVertex("L");

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

    void mapTraversalDepthFirst() {
        // Print out the graph to be sure it's really complete
        Iterator<String> iter = new DepthFirstIterator<>(graph);
        while (iter.hasNext()) {
            String vertex = iter.next();
            System.out.println(
                    "Vertex " + vertex + " is connected to: "
                            + graph.edgesOf(vertex).toString()
            );
        }
    }

    static class DistanceEdge extends DefaultEdge {
        public final int dis;

        public DistanceEdge(int distance) {
            this.dis = distance;
        }

        @Override
        public String toString() {
            return "(" + getSource() + " : " + getTarget() + " : " + dis + ")";
        }
    }
}
