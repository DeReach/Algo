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
            System.out.println("Could not find solution after creating " + nodesExpanded + " vertices. Searched for " + totalTime * 1E-6 + "ms.");
        } else {
//                Display out = new Display();
            System.out.println("Solution found after creating " + nodesExpanded + " vertices. Searched for " + totalTime * 1E-6 + "ms. Moves: " + currentBoard.getDepth());
//                System.out.println(out.solutionToString(currentBoard));
        }

    }
}
