package src;

import java.util.*;

public class Graph {
    private int numVertices;
    private final ArrayList<LinkedList<Vertex>> adjVertices;

    public Graph(Board initialBoard) {
        this.numVertices = 1;
        this.adjVertices = new ArrayList<>(numVertices);
        this.adjVertices.add(new LinkedList<>());
        this.adjVertices.getFirst().add(new Vertex(0, initialBoard, true));
    }

    public Vertex getVertex(int index) {
        return adjVertices.get(index).getFirst();
    }
    public void addEdge(Vertex u, Vertex v) {
        adjVertices.get(u.getIndex()).add(v);
        adjVertices.get(v.getIndex()).add(u);
    }

    public void addEdge(int index_u, int index_v) {
        adjVertices.get(index_u).add(getVertex(index_v));
        adjVertices.get(index_v).add(getVertex(index_u));
    }

    public void addVertex(Vertex v) {
        numVertices++;
        LinkedList<Vertex> newList = new LinkedList<>();
        newList.add(v);
        adjVertices.addLast(newList);
    }

    public void addVertex(Board board) {
        addVertex(new Vertex(this.numVertices, board, false));
    }

    public LinkedList<Vertex> getAdjVertices(Vertex vertex) {
        return adjVertices.get(vertex.getIndex());
    }
    public LinkedList<Vertex> getAdjVertices(int index) {
        return adjVertices.get(index);
    }
    public int getNumVertices() {
        return numVertices;
    }
}