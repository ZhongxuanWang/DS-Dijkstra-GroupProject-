class NodePair implements Comparable<NodePair>{

    int dis;
    String source;
    String target;

    NodePair(String source, String target, int dis) {
        this.source = source;
        this.target = target;
        this.dis = dis;
    }

    /**
     * Precondition: assume o is a pair
     * @param o another
     * @return another
     */
    public String another(String o) {
        return o.equals(source) ? target : source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NodePair)) return false;
        NodePair nodePair = (NodePair) o;
        return source.equals(nodePair.source) && target.equals(nodePair.target);
    }

    @Override
    public int hashCode() {
        // The multiple of 7 here just to help us generate a more unique hashcode,
        //  try to avoid hash collision in our hashmap.
        return this.source.hashCode() * 7  + this.target.hashCode() + this.dis * 11;
    }

    @Override
    public String toString() {
        return "NodePair{" +
                "dis=" + dis +
                ", source='" + source + '\'' +
                ", target='" + target + '\'' +
                '}';
    }

    @Override
    public int compareTo(NodePair o) {
        return Integer.compare(dis, o.dis);
    }
}