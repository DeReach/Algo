package src;

import src.Algorithm.BFS;
import static src.Util.generateBoard;
import static src.Util.createSolvedBoard;

public class Main {
    public static void main(String[] args) {

        String algorithm = "bfs";
        int size = 4;
        int n = 10;

        Board solvedBoard = createSolvedBoard(size);
        Board initialBoard = generateBoard(solvedBoard, n);
        initialBoard.printBoard();

        BFS bfs = new BFS(initialBoard, solvedBoard);
        bfs.solve();
    }
}
