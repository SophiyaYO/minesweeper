package model;

import repositories.CellRepository;

public class EmptyCell extends Cell {
    boolean hasMine;
    String cellValue;

    public EmptyCell(){
        this.hasMine = setIsMine();
        this.cellValue = " ";
    }

    @Override
    public boolean setIsMine() {
        return false;
    }

    @Override
    public boolean getIsMine() {
        return this.hasMine;
    }

    @Override
    public String getValue() {
        return this.cellValue;
    }
}
