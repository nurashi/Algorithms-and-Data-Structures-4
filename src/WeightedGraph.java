import java.util.*;

public class WeightedGraph<V> {
    private Set<Vertex<V>> vertices = new HashSet<>();

    public void addVertex(Vertex<V> v) {
        vertices.add(v);
    }

    public void addEdge(Vertex<V> from, Vertex<V> to, double weight) {
        from.addAdjacentVertex(to, weight);
        addVertex(from);
        addVertex(to);
    }


    public Set<Vertex<V>> getVertices() {
        return vertices;
    }
}
