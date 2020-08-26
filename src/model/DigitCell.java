package model;

public class DigitCell extends Cell {
    private boolean hasMine;
    private String cellValue;
    private int value;

    public DigitCell(String cellValue) {
        this.hasMine = setIsMine();
        this.value = Integer.parseInt(cellValue);
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
        return null;
    }

    public int getNumberValue() {
        return this.value;
    }
}
