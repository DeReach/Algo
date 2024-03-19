package src.Algorithm;

import src.Board;

import static src.Algorithm.BFS.BFS_Solve;
import static src.Algorithm.Dijkstra.Dijkstra_Solve;
import static src.Algorithm.AStar.AStar_Solve;

public class Algorithm {
    private final AlgorithmType algorithm;
    private final Board solvedBoard;

    public Algorithm(AlgorithmType algorithm, Board solvedBoard) {
        this.algorithm = algorithm;
        this.solvedBoard = solvedBoard;
    }

    public void solve(Board initialBoard) {
        switch(this.algorithm) {
            case BFS -> BFS_Solve(initialBoard, this.solvedBoard);
            case DIJKSTRA -> Dijkstra_Solve(initialBoard, this.solvedBoard);
            case ASTAR -> AStar_Solve(initialBoard, this.solvedBoard);
        }
    }
}
