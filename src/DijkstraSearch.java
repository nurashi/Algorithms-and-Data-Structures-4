import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private Map<Vertex<V>, Double> distance = new HashMap<>();
    private Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();
    private Vertex<V> start;

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> start) {
        this.start = start;
        for (Vertex<V> v : graph.getVertices()) {
            distance.put(v, Double.POSITIVE_INFINITY);
        }
        distance.put(start, 0.0);

        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(distance::get));
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();

            for (Map.Entry<Vertex<V>, Double> entry : current.getNeighbors().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDist = distance.get(current) + weight;

                if (newDist < distance.get(neighbor)) {
                    distance.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(Vertex<V> destination) {
        return distance.get(destination) < Double.POSITIVE_INFINITY;
    }

    @Override
    public List<Vertex<V>> getPathTo(Vertex<V> destination) {
        if (!hasPathTo(destination)) return null;
        LinkedList<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> at = destination; at != null; at = previous.get(at)) {
            path.addFirst(at);
        }
        return path;
    }
}
