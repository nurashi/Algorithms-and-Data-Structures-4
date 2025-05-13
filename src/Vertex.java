import java.util.*;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> neighbors;

    public Vertex(V data) {
        this.data = data;
        this.neighbors = new HashMap<>();
    }

    public void addNeighbor(Vertex<V> vertex, double weight) {
        neighbors.put(vertex, weight);
    }

    public V getData() {
        return data;
    }

    public Map<Vertex<V>, Double> getNeighbors() {
        return neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
