package model;

import repositories.CellRepository;

public class MineCell extends Cell {
    boolean hasMine;
    String cellValue;

    public MineCell(){
        this.hasMine = true;
        this.cellValue = "*";
    }

    @Override
    public boolean setIsMine() {
        return true;
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
