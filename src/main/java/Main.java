
import org.jgrapht.*;
import org.jgrapht.generate.*;
import org.jgrapht.graph.*;
// import org.jgrapht.nio.*;
// import org.jgrapht.nio.dot.*;
import org.jgrapht.traverse.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class Main {
    public static boolean stop = false;
    public static Map map = new Map(false);

    public static void main(String[] args) throws IOException {
        System.out.println("Hello! Welcome to Dijkstra Crazy Turkey Project! ");
        System.out.println("This, is your map encoded with String! ");

        map.mapTraversalDepthFirst();
        System.out.println("Pretty amazing isn't ? \n" +
                "-".repeat(70));








        while (!stop) {
            loop();
            map.summary();
            System.out.println("-".repeat(70));
        }
        //
        // Map map = new Map(debug);



        System.out.println("Finished. Thank you!");
    }

    public static void loop() {

        System.out.println("Give us your Starting point! (eg.A)");
        String start = "";
        while (start.length() != 1) {
            start = getInput().toUpperCase();
        }
        map.setStart(start);

        System.out.println("Give us your Ending point! (eg.L)");
        String end = "";
        while (end.length() != 1) {
            end = getInput().toUpperCase();
        }
        map.setEnd(end);

        stop = true;
    }

    public static String getInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(">");
        try {
            String re = reader.readLine();
            if (re.isEmpty()) {
                System.out.println("Why?! Why give me a blank answer so my software would crash?!");
            }
            return re;
        } catch (final Exception e) {
            return "";
        }
    }

}
