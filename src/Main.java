package src;

import src.Algorithm.Algorithm;
import src.Algorithm.AlgorithmType;
import src.Algorithm.BFS;

import java.util.Arrays;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        int[][] initialTiles = {
                {0, 1, 8, 7},
                {6, 14, 10, 9},
                {2, 12, 15, 3},
                {5, 13, 4, 11}
        };
        int[][] solvedTiles = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
        };

        Board initialBoard = new Board(initialTiles);
        Board solvedBoard = new Board(solvedTiles);

        Algorithm bfs = new Algorithm(AlgorithmType.BFS, solvedBoard);
        Algorithm dijkstra = new Algorithm(AlgorithmType.DIJKSTRA, solvedBoard);
        Algorithm astar = new Algorithm(AlgorithmType.ASTAR, solvedBoard);

        bfs.solve(initialBoard);
    }
}
