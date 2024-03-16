package src;

import java.util.Arrays;

public class Board {
    private int size;
    private int[][] tiles;

    Board(int size) {
        this.size = size;
        this.tiles = new int[size][size];
    }

    Board(int[][] tiles) {
        this.size = tiles.length;
        this.tiles = tiles;
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
    }
}
