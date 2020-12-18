@Deprecated
class Node {
    Node next;
    int distance;

    String to;
    String from;

    Node (int distance, String to, String from) {
        this.distance = distance;
        this.from = from;
        this.to = to;
    }

    Node (int distance, String to, String from, Node next) {
        this.distance = distance;
        this.next = next;
        this.from = from;
        this.to = to;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node=" + distance + " hasNext=" + (next != null);
    }

    @Override
    public boolean equals(Object o) {
        return distance == ((Node) o).distance;
    }

    public boolean equalPath(Node node) {
        return this.to.equals(node.to) && this.from.equals(node.from);
    }

    public boolean equalPath(String from, String to) {
        return this.to.equals(to) && this.from.equals(from);
    }
}