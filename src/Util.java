package src;

import src.Algorithm.Direction;

import java.util.Random;

public final class Util {
    public static boolean isInbounds(int[][] matrix, int row, int col) {
        return (
                row >= 0 &&
                col >= 0 &&
                matrix.length - row > 0 &&
                matrix.length - col > 0
        );
    }

    public static int[][] cloneMatrix(int[][] matrix) {
        int[][] copy = new int[matrix.length][];
        for (byte i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            int rowLength = row.length;
            copy[i] = new int[rowLength];
            System.arraycopy(row, 0, copy[i], 0, rowLength);
        }

        return copy;
    }

    public static int[] zeroCoords(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) return new int[]{i, j};
            }
        }

        return new int[]{-1, -1};
    }

    public static Board generateBoard(Board solvedBoard, int n) {
        Board generatedBoard = solvedBoard.clone();
        Direction[] directions = Direction.values();
        Random randomizer = new Random();

        for (int i = 0; i < n; i++) {
            Direction dir = directions[randomizer.nextInt(directions.length)];
            generatedBoard.moveZero(dir);
        }

        return generatedBoard;
    }

    public static Board createSolvedBoard(int size) {
        int[][] tiles = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tiles[i][j] = (i * size) + j + 1;
            }
        }
        tiles[size - 1][size - 1] = 0;
        return new Board(tiles, size - 1, size - 1);
    }
}
