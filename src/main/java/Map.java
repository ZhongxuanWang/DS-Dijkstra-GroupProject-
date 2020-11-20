import org.jgrapht.Graph;
import org.jgrapht.generate.GnmRandomGraphGenerator;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.HashMap;

public class Map {

    Graph<String, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);


    Map (boolean random) {
        GnmRandomGraphGenerator<String, DefaultEdge> g;
        if (random) {
            g = new GnmRandomGraphGenerator<>(12,24);
        } else {
            g = new GnmRandomGraphGenerator<>(12,24,1);
        }
        g.generateGraph(graph);
    }


    private static Graph<String, DefaultEdge> createStringGraph()
    {
        return null;
    }
}
