class NodePair implements Comparable<NodePair>{

    int dis;
    String name;
    NodePair from;

    NodePair(String name, int dis, NodePair from) {
        this.name = name;
        this.dis = dis;
        this.from = from;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NodePair)) return false;
        NodePair nodePair = (NodePair) o;
        return name.equals(nodePair.name);
    }

    @Override
    public int hashCode() {
        // The multiple of 7 here just to help us generate a more unique hashcode,
        //  try to avoid hash collision in our hashmap.
        return this.name.hashCode() * 7 + this.dis * 11;
    }

    @Override
    public String toString() {
        String from;
        if (this.from == null)
            from = "null";
        else
            from = this.from.name;
        return  PriorityQueuePro.ANSI_YELLOW + "NodePair{" +
                "from:" + from +
                ", to:" + name +
                ", dis=" + dis +
                '}' + PriorityQueuePro.ANSI_RESET;
    }

    @Override
    public int compareTo(NodePair o) {
        return Integer.compare(dis, o.dis);
    }
}