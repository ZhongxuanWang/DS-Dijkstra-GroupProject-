import java.io.*;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultUndirectedGraph;

public class Main {
    final public static boolean debug = true; // If the hw is under grading, please leave it as true!
    final public static boolean JUMP_TO_DIJKSTRA = true; // If you want to jump to dijkstra, set it as true

    public static boolean stop = false;
    public static Map map;

    public static Dijkstra dijkstra;

    public static void main(String[] args) {

        Graph<String, DistanceEdge> graph = new DefaultUndirectedGraph<>(DistanceEdge.class);
        for (String v : new String[] {
                "A", "B", "C", "D", "E",
                "F", "G", "H", "I", "J",
                "K", "L"
        }) {
            graph.addVertex(v);
        }

        dijkstra  = new Dijkstra(graph, !debug);
        map = dijkstra.map;

        System.out.println("Hello! Welcome to Dijkstra Project! ");
        System.out.println("This, is your map encoded with String! ");

        map.mapTraversalDepthFirst();
        System.out.println("Pretty amazing isn't ? \n" +
                "-".repeat(70));

        if (JUMP_TO_DIJKSTRA) {
            mode2();
        } else {
            System.out.println("Select Your Preferable Mode!\n" +
                    "1. Me-as-a-navigator mode (for PrepWork/being bored only)\n" +
                    "2. Dijkstra-shortest-pathfinding mode");
            if (getInput().equals("1")) {
                mode1();
            } else {
                mode2();
            }
        }

        System.out.println("Finished. Thank you!");
    }

    public static void mode1() {
        System.out.println("You are now in the 1st Mode!");
        while (!stop) {
            int liveDistance = 0;
            loop();
            while (!stop) {
                map.liveSummary();

                String stringSet = map.availableRoutesSet();
                System.out.printf("Where would you wanna go?! (%s) \n", stringSet);
                String dest = getInput();

                if (!stringSet.contains(dest)) {
                    System.out.println("No! Don't fool me!");
                    continue;
                }
                map.goTo(dest);
            }
        }
    }

    public static void mode2() {
        System.out.println("You are now in the 2nd Mode!");
        while (!stop) {
            loop();
            dijkstra.findShortestPath();
            map.summary();
            System.out.println("-".repeat(70));
        }
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
    }

    public static String getInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(">");
        try {
            String re = reader.readLine();
            if (re.isEmpty()) {
                System.out.println("Why?! Why give me a blank answer so my software would crash?!");
                System.exit(0);
                // return new String[] {"A", "B", "C", "D", "E"}[(int)(Math.random() * 5)];
            }
            return re;
        } catch (final Exception e) {
            return "";
        }
    }

}
