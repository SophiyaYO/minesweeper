package model;

public class MaskedCell extends Cell {
    boolean hasMine;
    String cellValue;

    public MaskedCell() {
        this.hasMine = setIsMine();
        this.cellValue = "-";
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
