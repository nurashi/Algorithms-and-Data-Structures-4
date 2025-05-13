import java.util.*;

public class WeightedGraph<V> {
    private Set<Vertex<V>> vertices = new HashSet<>();

    public void addVertex(Vertex<V> vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Vertex<V> from, Vertex<V> to, double weight) {
        from.addNeighbor(to, weight);
    }

    public Set<Vertex<V>> getVertices() {
        return vertices;
    }
}
