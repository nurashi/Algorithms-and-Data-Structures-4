import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");
        Vertex<String> E = new Vertex<>("E");

        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        graph.addVertex(E);

        graph.addEdge(A, B, 4);
        graph.addEdge(A, C, 2);
        graph.addEdge(B, D, 5);
        graph.addEdge(C, D, 8);
        graph.addEdge(C, E, 10);
        graph.addEdge(D, E, 2);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, A);
        printPath(bfs.getPathTo(E));

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, A);
        printPath(dijkstra.getPathTo(E));
    }

    private static void printPath(List<Vertex<String>> path) {
        if (path == null) {
            System.out.println("No path foud");
            return;
        }
        for (Vertex<String> vertex : path) {
            System.out.print(vertex + " - ");
        }
        System.out.println();
    }
}
