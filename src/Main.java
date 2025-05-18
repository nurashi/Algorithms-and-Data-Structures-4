import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");

        Vertex<String> D = new Vertex<>("D");
        Vertex<String> E = new Vertex<>("E");

        graph.addEdge(A, B, 4.0);
        
        graph.addEdge(A, C, 2.0);

        graph.addEdge(B, C, 5.0);
        graph.addEdge(B, D, 10.0);

        graph.addEdge(C, E, 3.0);
        graph.addEdge(E, D, 4.0);


        for (Vertex<String> v : graph.getVertices()) {
            System.out.print(v.getData() + " -> ");
            for (var entry : v.getAdjacentVertices().entrySet()) {
                System.out.print(entry.getKey().getData() + entry.getValue());

            }
            System.out.println();
        }

        Search<String> bfs = new BreadthFirstSearch<>(graph, A);
        List<Vertex<String>> pathBFS = bfs.getPathTo(D);
        for (Vertex<String> v : pathBFS) {
            System.out.print(v.getData() + " ");

        }

        Search<String> dijkstra = new DijkstraSearch<>(graph, A);
        List<Vertex<String>> pathDijkstra = dijkstra.getPathTo(D);
        for (Vertex<String> v : pathDijkstra) {

            System.out.print(v.getData() + " ");
        }

        System.out.println();
    }
}
