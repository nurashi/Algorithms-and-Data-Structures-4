#  Graph Algorithms: BFS & Dijkstra

This assignment implements graph algorithms like Breadth-First Search and Dijkstra using a custom `Vertex` class.

---

##  Assignment

implemented:
- `Vertex<V>`
- `WeightedGraph<V>`
- `Search<V>`
- `BreadthFirstSearch<V>`
- `DijkstraSearch<V>`
- and demonstrate it all in `Main`

##  Structure

```java
Vertex<V> {
    V data;
    Map<Vertex<V>, Double> adjacentVertices;
}

WeightedGraph<V> {
    Set<Vertex<V>> vertices;
    void addEdge(Vertex from, Vertex to, double weight);
}

BreadthFirstSearch<V> extends Search<V>
DijkstraSearch<V> extends Search<V>
