
import org.jgrapht.*;
import org.jgrapht.graph.*;
// import org.jgrapht.nio.*;
// import org.jgrapht.nio.dot.*;
import org.jgrapht.traverse.*;

import java.io.*;
import java.net.*;
import java.rmi.server.ExportException;
import java.util.*;




/**
 * Just want to play with Gradle :)
 */

public class Main {
    public static boolean stop = false;
    public static boolean debug = false;

    public static void main(String[] args) throws IOException, ExportException, URISyntaxException {

        Graph<String, DefaultEdge> stringGraph = createStringGraph();

        System.out.println("-- toString output");
        System.out.println(stringGraph.toString());
        System.out.println();


        // while (!stop) {
        //     loop();
        //     System.out.println("-".repeat(70));
        // }
        //
        // Map map = new Map(debug);



        System.out.println("Finished. Thank you!");
    }

    public static void loop() {
        stop = true;
    }

    public static String getInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(">");
        try {
            return reader.readLine();
        } catch (final Exception e) {
            return "";
        }
    }

    private static Graph<String, DefaultEdge> createStringGraph()
    {
        Graph<String, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);

        String v = "THANKSGIVING";

        StringTokenizer st = new StringTokenizer(v);

        while (st.hasMoreTokens()) {
            g.addVertex(st.nextToken());
        }
        st = new StringTokenizer(v);
        while (st.hasMoreTokens()) {
            g.addEdge(st.nextToken());
        }

        // add the vertices
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);

        // add edges to create a circuit
        g.addEdge(v1, v2);
        g.addEdge(v2, v3);
        g.addEdge(v3, v4);
        g.addEdge(v4, v1);

        return g;
    }

}
