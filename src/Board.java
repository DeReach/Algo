package src;

import java.util.Arrays;

public class Board {
    private final int size;
    private final int[][] tiles;
    private final int[] zeroCoords;

    public Board(int size) {
        this.size = size;
        this.tiles = new int[size][size];
        this.zeroCoords = getZeroCoords(tiles);
    }

    Board(int[][] tiles) {
        this.size = tiles.length;
        this.tiles = tiles;
        this.zeroCoords = getZeroCoords(tiles);
    }

    public int getSize() {
        return this.size;
    }

    public int[][] getTiles() {
        return this.tiles;
    }

    public void printBoard() {
        for (int[] row: tiles) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    public boolean isEqual(Board b) {
        if (b.size != this.size) return false;
        int[][] compTiles = b.getTiles();

        for (int row = 0; row < this.tiles.length; row++) {
            for (int col = 0; col < this.tiles[row].length; col++) {
                if (this.tiles[row][col] != compTiles[row][col]) return false;
            }
        }

        return true;
    }

    public int[] getZeroCoords() {
        return this.zeroCoords;
    }

    static int[] getZeroCoords(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][i] == 0) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
}
