package com.company;

public class Board {
    public static final int ROWS = 3;
    public static final int COLS = 3;

    Cell[][] cells;

    int currRow, currCol;

    public Board() {
        cells = new Cell[ROWS][COLS];
        for(int i=0;i<ROWS;i++) {
            for(int j=0;j<COLS;j++) {
                cells[i][j] = new Cell(i,j);
            }
        }
    }

    public void init() {
        for(int i=0;i<ROWS;i++) {
            for (int j = 0; j < COLS; j++) {
                cells[i][j].clear();
            }
        }
    }

    public boolean isDraw() {
        for(int i=0;i<ROWS;i++) {
            for(int j=0;j<COLS;j++) {
                if(cells[i][j].content == CellContent.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWon(CellContent content) {
        return ((cells[currRow][0].content == content
                && cells[currRow][1].content == content
                && cells[currRow][2].content == content)
                || (cells[0][currCol].content == content
                && cells[1][currCol].content == content
                && cells[2][currCol].content == content)
                || (currRow == currCol
                && cells[0][0].content == content
                && cells[1][1].content == content
                && cells[2][2].content == content)
                || (currRow + currCol == 2
                && cells[0][2].content == content
                && cells[1][1].content == content
                && cells[2][0].content == content));
    }

    public void fill() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                cells[i][j].fill();
                if (j < COLS - 1) System.out.print("|");
            }
            System.out.println();
            if (i < ROWS - 1) {
                System.out.println("-----------");
            }
        }
    }

}
