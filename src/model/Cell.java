package model;

import repositories.CellRepository;

public class Cell implements CellRepository {
    boolean hasMine;
    String cellValue;

    public Cell(){

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
        return null;
    }
}
