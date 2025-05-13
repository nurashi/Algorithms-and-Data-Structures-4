import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private Set<Vertex<V>> visited = new HashSet<>();
    private Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();
    private Vertex<V> start;

    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> start) {
        this.start = start;
        bfs(graph, start);
    }

    private void bfs(WeightedGraph<V> graph, Vertex<V> start) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            for (Vertex<V> neighbor : current.getNeighbors().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    edgeTo.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(Vertex<V> destination) {
        return visited.contains(destination);
    }

    @Override
    public List<Vertex<V>> getPathTo(Vertex<V> destination) {
        if (!hasPathTo(destination)) return null;
        LinkedList<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> x = destination; x != start; x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(start);
        return path;
    }
}
