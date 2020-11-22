
import org.jgrapht.*;
import org.jgrapht.generate.*;
import org.jgrapht.graph.*;
// import org.jgrapht.nio.*;
// import org.jgrapht.nio.dot.*;
import org.jgrapht.traverse.*;

import java.io.*;
import java.net.*;
import java.rmi.server.ExportException;
import java.util.*;

public class Main {
    public static boolean stop = false;
    public static boolean debug = true;

    public static void main(String[] args) throws IOException, ExportException, URISyntaxException {
        Map<String> map = new Map<>(debug);
        map.mapTraversalDepthFirst();
        System.out.println("-- toString output");
        // System.out.println(stringGraph.toString());
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
}
