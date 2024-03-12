import java.util.LinkedList;

public class Graph {
    private int V;
    private LinkedList<Integer>[] adj;

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void printGraph() {
        for (int i = 0; i < V; ++i) {
            System.out.println("Adjacency list of vertex " + i);
            System.out.print("head");
            for (Integer pCrawl : adj[i]) {
                System.out.print(" -> " + pCrawl);
            }
            System.out.println("\n");
        }
    }
}
