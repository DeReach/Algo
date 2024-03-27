package src.Algorithm;

import src.Board;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.*;

public class BFS {

    private Board initialBoard, solvedBoard;
    private ArrayList<Board> visitedList;
    private LinkedBlockingQueue<Board> queue;
    private long nodesExpanded = 0;

    public BFS(Board initialBoard, Board solvedBoard) {
        this.initialBoard = initialBoard;
        this.solvedBoard = solvedBoard;
    }

    public void solve() {
        Board currentBoard = initialBoard;
        visitedList = new ArrayList<Board>();
        queue = new LinkedBlockingQueue<Board>();

        long startTime, endTime, totalTime;
        startTime = System.nanoTime();

        while (currentBoard != null && !currentBoard.equals(solvedBoard)) {
//            currentBoard.printBoard();
            System.out.println(nodesExpanded);
            if (!visitedList.contains(currentBoard)) {
                for (Direction d : Direction.values()) {
                    queue.add(new Board(currentBoard, d));
                }
                visitedList.add(currentBoard);
                nodesExpanded++;
            }
            currentBoard = queue.poll();
        }
        endTime = System.nanoTime();
        totalTime = endTime - startTime;
        if (currentBoard == null) {
            System.out.println("Could not find solution after expanding " + nodesExpanded + " nodes. Searched for " + totalTime * 1E-6 + "ms.");
        } else {
//                Display out = new Display();
            System.out.println("Solution found after expanding " + nodesExpanded + " nodes. Searched for " + totalTime * 1E-6 + "ms. Depth: " + currentBoard.getDepth());
//                System.out.println(out.solutionToString(currentBoard));
        }

    }
}
//        Graph graph = new Graph(initialBoard);
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(0);
//
//        while(!queue.isEmpty()) {
//            Vertex currentVertex = graph.getVertex(queue.poll());
////            Board currentBoard = currentVertex.getBoard();
//            currentBoard.printBoard();
//            if (currentBoard.equals(solvedBoard)) {
//                System.out.println("---------------------\n       Solved!       \n---------------------");
//                return;
//            }
//
//            for (int[] dir: dirMatrix) {
//                int checkRow = currentBoard.getZeroCoords()[0] + dir[0];
//                int checkCol = currentBoard.getZeroCoords()[1] + dir[1];
//                if (isInbounds(currentBoard.getTiles(), checkRow, checkCol)) {
//                    Board newBoard = new Board(cloneMatrix(currentBoard.getTiles()));
//                    newBoard.moveZero(dir);
//
//                    Vertex v = graph.addVertex(newBoard);
//                    graph.addEdge(currentVertex, v);
//                }
//            }
//
//            graph.getAdjVertices(currentVertex).forEach((vertex -> {
//                if (!vertex.getVisited()) {
//                    vertex.setVisited(true);
//                    queue.add(vertex.getIndex());
//                }
//            }));
//        }
