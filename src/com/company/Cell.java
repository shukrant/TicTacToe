package com.company;

public class Cell {
    public CellContent content;
    public int row,col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        clear();
    }

    public void clear() {
        this.content = content.EMPTY;
    }

    public void fill() {
        switch (content) {
            case CROSS:  System.out.print(" X "); break;
            case ZERO: System.out.print(" O "); break;
            case EMPTY:  System.out.print("   "); break;
        }
    }
}
