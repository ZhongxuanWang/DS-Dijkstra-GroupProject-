class NodePair implements Comparable<Integer>{

    int dis;
    String source;
    String target;

    NodePair(String source, String target, int dis) {
        this.source = source;
        this.target = null;
        this.dis = dis;
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
        return this.source.hashCode() * 7  + this.target.hashCode();
    }

    @Override
    public int compareTo(Integer o) {
        return Integer.compare(dis, o);
    }
}