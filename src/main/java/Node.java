import java.util.Objects;

class Node {
    Node next;
    int distance;

    Node (int distance, Node next) {
        this.distance = distance;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node=" + distance + " hasNext=" + (next != null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return distance == node.distance &&
                Objects.equals(next, node.next);
    }
}