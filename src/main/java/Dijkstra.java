import org.jgrapht.Graph;

import java.util.HashSet;

public class Dijkstra {
    Map map;
    HashSet<String> knownPairs;

    public Dijkstra(Graph<String, DistanceEdge> graph) {
        map = new Map(graph, false);
    }

    public Dijkstra(Graph<String, DistanceEdge> graph, boolean randomized) {
        map = new Map(graph, randomized);
    }


    public void findShortestPath(String origin, String target) {
        if (map.total_dis != 0) map.total_dis = 0;
        map.dijkstraSwitch = true;

        PriorityQueuePro bigQueue = new PriorityQueuePro();
        knownPairs = new HashSet<>(12,2);

        // Initialization for the big queue
        for (String node : map.allNodes) {
            if (!node.equals(origin))
                bigQueue.add(new NodePair(node, Integer.MAX_VALUE, null));
        }

        NodePair placeNow = new NodePair(origin, 0, null);

        while (knownPairs.size() != 11) {
            knownPairs.add(placeNow.name);
            System.out.print("\nA New Loop! My Place: \"" + placeNow.name + "\" Unknown Nodes To Be Examined: ");
            printUnknowns();
            System.out.println();

            // Find the last distance for this node
            for (DistanceEdge edge : map.graph.edgesOf(placeNow.name)) {
                String thisNode = edge.getAnother(placeNow.name);
                if (knownPairs.contains(thisNode)) continue;
                System.out.println("Unknown Neighbor Node Examining: " + thisNode);

                NodePair newPair = new NodePair(thisNode, edge.dis, placeNow);
                refreshQueue(bigQueue, newPair, newPair.from.dis);
            }

            placeNow = nextPair(bigQueue, placeNow);
        }
        NodePair targetPair = getNode(bigQueue, target);
        map.total_dis = targetPair.dis;
        System.out.print("\nShortest Distance: ");
        printShortestPath(targetPair);
        System.out.print("\b\b\b \n\n");
    }

    public void findShortestPath() {
        findShortestPath(map.start, map.end);
        map.dijkstraSwitch = true;
    }

    public void printUnknowns() {
        for (String s : map.allNodes) {
            if (!knownPairs.contains(s)) {
                System.out.print(s + " ");
            }
        }
    }

                /*
                 *  -  HELPER FUNCTIONS ZONE  -
                 *
                 * Bear me used backtracking or recursion for all.. That just made our life easier
                 */

    public void printShortestPath(NodePair target) {
        if (target != null) {
            printShortestPath(target.from);
            System.out.print(target.name + " -> ");
        }
    }

    public NodePair nextPair(PriorityQueuePro q, NodePair placeNow) {
        if (q.isEmpty()) return null; // All Consumed
        if (knownPairs.contains(placeNow.name)) {
            NodePair polled = q.poll();
            NodePair ret = nextPair(q, polled);
            q.add(polled);
            return ret;
        } else {
            return placeNow;
        }
    }

    public void refreshQueue(PriorityQueuePro q, NodePair pairToBeInserted, int lastDis) {
        if (q.isEmpty()) return; // It's never possible
        NodePair polled = q.poll();
        if (polled.name.equals(pairToBeInserted.name)) {
            if (polled.dis > pairToBeInserted.dis + lastDis) {
                polled.dis = pairToBeInserted.dis + lastDis;
                polled.from = pairToBeInserted.from;
            }
        } else {
            refreshQueue(q, pairToBeInserted, lastDis);
        }
        q.add(polled);
    }


    public NodePair getNode(PriorityQueuePro q, String name) {
        if (q.isEmpty()) return null;

        NodePair polled = q.poll();
        if (polled.name.equals(name)) {
            q.add(polled);
            return polled;
        } else {
            final NodePair p = getNode(q, name);
            q.add(polled);
            return p;
        }
    }

                /*
                 *  -  DEPRECATED FUNCTIONS ZONE  -
                 */
    /**
     * No Use
     */
    @Deprecated
    public int getLastDis(NodePair newPair) {
        if (newPair.from != null) {
            return newPair.from.dis + getLastDis(newPair.from);
        }
        return 0;
    }

    @Deprecated
    int str2Ind(String str) {
        return str.charAt(0)-'A';
    }
}
