import java.util.*;

public class Graph {
    private int numVertices;
    private LinkedList<Integer>[] adj;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.adj = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public void addVertex() {
        numVertices++;
        LinkedList<Integer> newList = new LinkedList<>();
        adj[numVertices - 1] = newList;
    }

    public LinkedList<Integer> getAdjacentNodes(int vertex) {
        return adj[vertex];
    }

    public int getNumVertices() {
        return numVertices;
    }
}