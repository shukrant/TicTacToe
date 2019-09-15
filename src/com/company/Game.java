package com.company;
import java.util.Scanner;

public class Game {
    private Board board;
    private GameState currentState;
    private CellContent currentPlayer;

    private static Scanner in = new Scanner(System.in);

    public Game() {
        board = new Board();

        initGame();

        do {
            playerMove(currentPlayer);
            board.fill();
            updateGame(currentPlayer);
            if (currentState == GameState.CROSS_WIN) {
                System.out.println("'X' won!");
            } else if (currentState == GameState.ZERO_WIN) {
                System.out.println("'O' won!");
            } else if (currentState == GameState.DRAW) {
                System.out.println("It's Draw!");
            }
            currentPlayer = (currentPlayer == CellContent.CROSS) ? CellContent.ZERO : CellContent.CROSS;
        } while (currentState == GameState.PLAYING);

    }

    public void initGame() {
        board.init();
        currentPlayer = CellContent.CROSS;
        currentState = GameState.PLAYING;
    }

    public void playerMove(CellContent move) {
        if (move == CellContent.CROSS) {
            System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
        } else {
            System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
        }
        int row = in.nextInt() - 1;
        int col = in.nextInt() - 1;
        board.cells[row][col].content = move;
        board.currRow = row;
        board.currCol = col;
    }

    void updateGame(CellContent move) {
        if(board.hasWon(move)) {
            currentState = (move == CellContent.CROSS) ? GameState.CROSS_WIN : GameState.ZERO_WIN;
        } else if(board.isDraw()) {
            currentState = GameState.DRAW;
        }
    }
}
