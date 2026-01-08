package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;
    public PlayerPiece[][] board;

    public Board(int size) {
        this.board = new PlayerPiece[size][size];
        this.size = size;
    }
    public boolean addPiece(int row,int col,PlayerPiece playerPiece) {
        if (board[row][col] != null) {
            return false;
        }
        board[row][col] = playerPiece;
        return true;
    }

    public List<Pair<Integer,Integer>> getFreeCells() {
        List<Pair<Integer,Integer>> freeCells = new ArrayList<>();
        for (int i=0;i<size;i++) {
            for (int j=0;j<size;j++) {
                if (board[i][j] == null) {
                    Pair<Integer,Integer> rowCol = new Pair<>(i, j);
                    freeCells.add(rowCol);
                }
            }
        }
        return freeCells;

    }

    public void printBoard() {
        for (int i=0;i<size;i++) {
            for (int j=0;j<size;j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "  ");
                }
                else {
                    System.out.print("  ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

}
