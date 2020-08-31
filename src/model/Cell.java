package model;

import repositories.CellRepository;

public class Cell implements CellRepository {
    private String cellValue;
    private final int row;
    private final int col;

    public Cell(int r, int col){
        this.row= r;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    @Override
    public boolean setIsMine() {
        return false;
    }

    @Override
    public boolean getIsMine() {
        return false;
    }

    @Override
    public String getValue() {
        return this.cellValue;
    }
}
