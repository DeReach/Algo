package src.Algorithm;

import src.Board;
import src.Graph;
import src.Vertex;

import java.util.*;

public class BFS {
    public static void BFS_Solve(Board initialBoard, Board solvedBoard) {
        int[][] dirMatrix = Directions.getDirectionsMatrix();
        Graph graph = new Graph(initialBoard);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()) {
            Vertex currentVertex = graph.getVertex(queue.poll());
            Board currentBoard = currentVertex.getBoard();
            currentBoard.printBoard();
            if (currentBoard.isEqual(solvedBoard)) {
                System.out.println("---------------------\n       Solved!       \n---------------------");
                return;
            }

            for (int[] dir: dirMatrix) {
                int checkRow = currentBoard.getZeroCoords()[0] + dir[0];
                int checkCol = currentBoard.getZeroCoords()[1] + dir[1];
                if (isInbounds(currentBoard.getTiles(), checkRow, checkCol)) {
                    //TODO: create a new board where zero swapped with [checkRow, checkCol]
                    //TODO: add new vertex and edge to graph
                }

                //TODO: iterate currenVertex adj and add to queue
            }
        }
    }

    static boolean isInbounds(int[][] matrix, int row, int col) {
        return (matrix.length - row > 0 && matrix.length - col > 0);
    }
}
