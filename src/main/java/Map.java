import org.jgrapht.Graph;
import org.jgrapht.generate.GnmRandomGraphGenerator;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.util.SupplierUtil;

import java.util.Iterator;
import java.util.function.Supplier;

public class Map<T> {

    Supplier<T> vSupplier = new Supplier<>()
    {
        private int id = 0;

        @Override
        @SuppressWarnings("unchecked")
        public T get()
        {
            return (T) ("v" + id++);
        }
    };
    Graph<T, DefaultEdge> graph = new SimpleGraph<>(vSupplier, SupplierUtil.createDefaultEdgeSupplier(), false);


    Map (boolean random) {
        GnmRandomGraphGenerator<T, DefaultEdge> g;
        if (random) {
            g = new GnmRandomGraphGenerator<>(12,24);
        } else {
            g = new GnmRandomGraphGenerator<>(12,24,2);
        }
        g.generateGraph(graph);
    }

    void mapTraversalDepthFirst() {
        // Print out the graph to be sure it's really complete
        Iterator<T> iter = new DepthFirstIterator<>(graph);
        while (iter.hasNext()) {
            T vertex = iter.next();
            System.out.println(
                    "Vertex " + vertex + " is connected to: "
                            + graph.edgesOf(vertex).toString()
            );
        }
    }


    private static Graph<String, DefaultEdge> createGraph() {
        return null;
    }
}
