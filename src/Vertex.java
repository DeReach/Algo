package src;

public class Vertex {
    private final int index;
    private final Board board;
    private boolean visited;

    public Vertex(int index, Board board) {
        this.index = index;
        this.board = board;
        this.visited = false;
    }
    public Vertex(int index, Board board, boolean visited) {
        this.index = index;
        this.board = board;
        this.visited = visited;
    }

    public Board getBoard() {
        return board;
    }

    public int getIndex() {
        return index;
    }

    public boolean getVisited() {
        return this.visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
