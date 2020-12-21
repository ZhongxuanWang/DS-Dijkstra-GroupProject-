import org.jgrapht.graph.*;

class DistanceEdge extends DefaultWeightedEdge implements Comparable<DistanceEdge>{
    public final int dis;

    public DistanceEdge(int distance) {
        this.dis = distance;
    }

    @Override
    public String getSource() {
        return (String) super.getSource();
    }

    @Override
    public String getTarget() {
        return (String) super.getTarget();
    }

    @Override
    public String toString() {
        return "(" + getSource() + " : " + getTarget() + " : " + dis + ")";
    }

    public String getAnother(String ano) {
        if ( super.getSource().equals(ano) ) {
            return (String) super.getTarget();
        }
        if ( super.getTarget().equals(ano) ) {
            return (String) super.getSource();
        }
        return null;
    }

    @Override
    protected double getWeight() {
        return this.dis;
    }

    @Override
    public int compareTo(DistanceEdge o) {
        return Integer.compare(dis, o.dis);
    }
}
