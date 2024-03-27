package src;

import src.Algorithm.Direction;

import java.util.Arrays;

import static src.Util.cloneMatrix;

public class Board {
    private int[][] tiles;
    private int zeroCol;
    private int zeroRow;

    private int depth;

    private Board parent;

    public Board(int[][] tiles, int zeroRow, int zeroCol) {
        this.tiles = tiles;
        this.zeroCol = zeroCol;
        this.zeroRow = zeroRow;
        this.parent = null;
        this.depth = 0;
    }

    public Board(Board board, Direction dir) {
        this.tiles = cloneMatrix(board.getTiles());
        this.zeroRow = board.zeroRow;
        this.zeroCol = board.zeroCol;
        this.depth = board.depth;
        this.parent = board;
        this.moveZero(dir);
        this.depth++;
    }

    public int[][] getTiles() {
        return this.tiles;
    }

    public long getDepth() {
        return this.depth;
    }

    public Board getParent() {
        return this.parent;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Board other)) return false;

        int[][] otherTiles = other.getTiles();

        for (int row = 0; row < this.tiles.length; row++) {
            for (int col = 0; col < this.tiles[row].length; col++) {
                if (this.tiles[row][col] != otherTiles[row][col]) return false;
            }
        }

        return true;
    }

    public boolean moveZero(Direction dir) {

        switch (dir) {
            case UP -> {
                if (zeroRow > 0) {
                    tiles[zeroRow][zeroCol] = tiles[zeroRow - 1][zeroCol];
                    zeroRow--;
                    tiles[zeroRow][zeroCol] = 0;
                    return true;
                }
            }
            case DOWN -> {
                if (zeroRow < (tiles.length -1)) {
                    tiles[zeroRow][zeroCol] = tiles[zeroRow + 1][zeroCol];
                    zeroRow++;
                    tiles[zeroRow][zeroCol] = 0;
                    return true;
                }
            }
            case LEFT -> {
                if (zeroCol > 0) {
                    tiles[zeroRow][zeroCol] = tiles[zeroRow][zeroCol - 1];
                    zeroCol--;
                    tiles[zeroRow][zeroCol] = 0;
                    return true;
                }
            }
            case RIGHT -> {
                if (zeroCol < tiles.length - 1) {
                    tiles[zeroRow][zeroCol] = tiles[zeroRow][zeroCol + 1];
                    zeroCol++;
                    tiles[zeroRow][zeroCol] = 0;
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Board clone() {
        return new Board(cloneMatrix(tiles), zeroRow, zeroCol);
    }

    public void printBoard() {
        for (int[] row: tiles) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
