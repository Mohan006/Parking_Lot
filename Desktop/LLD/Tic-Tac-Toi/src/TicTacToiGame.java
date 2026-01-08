import models.*;

import java.util.Deque;
import java.util.LinkedList;
import models.PlayerPieceX;
import models.PlayerPieceO;
import java.util.List;
import java.util.Scanner;

public class TicTacToiGame {
    Deque<Player> players;
    Board gameBoard;
    Player winnder;
    public void initializeGame() {
        players = new LinkedList<>();
        PlayerPieceX pieceTypeX = new PlayerPieceX();
        Player player1 = new Player("Player1", pieceTypeX);
        PlayerPieceO pieceType0 = new PlayerPieceO();
        Player player2 = new Player("Player2", pieceType0);
        players.add(player1);
        players.add(player2);
        gameBoard = new Board(3);
    }

    public GameStatus startGame() {
        boolean noWinner = true;
        while (noWinner) {
            Player currentPlayer = players.removeFirst();
            gameBoard.printBoard();
            List<Pair<Integer,Integer>> freeSpaces = gameBoard.getFreeCells();
            if (freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }
            System.out.println("Player: "+ currentPlayer.name + "please enter [row,col]");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputCol = Integer.valueOf(values[1]);

            boolean validMove = gameBoard.addPiece(inputRow,inputCol,currentPlayer.playerPiece);
            if (!validMove) {
                System.out.println("Incorrect move : please try again");
                players.addFirst(currentPlayer);
                continue;
            }
            players.addLast(currentPlayer);

            boolean isWinner = checkForWinner(inputRow,inputCol,currentPlayer.playerPiece.pieceType);
            if (isWinner) {
                gameBoard.printBoard();
                winnder = currentPlayer;
                return GameStatus.WIN;
            }

        }
        return GameStatus.DRAW;
    }

    public boolean checkForWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // Check Row
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType) {
                rowMatch = false;
                break;
            }
        }

        // Check Column
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType) {
                columnMatch = false;
                break;
            }
        }

        // Check Diagonally
        for (int i = 0, j = 0; i < gameBoard.size; i++, j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
                break;
            }
        }

        // Check Anti-Diagonally
        for (int i = 0, j = gameBoard.size - 1; i < gameBoard.size; i++, j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
