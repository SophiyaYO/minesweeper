package model;

import repositories.CellRepository;

public class GameBoard {
    private int level;
    private int rolls;
    private int mines;
    private Cell[][] maskedBoard;
    private Cell[][] gameBoard;

    public GameBoard(int numberLevel) {
        this.level = numberLevel;
        setRolls();
        setMines();
        this.maskedBoard = new Cell[getRolls()][getRolls()];
        this.gameBoard = new Cell[0][];
    }

    public void setRolls() {
        switch (getLevel()) {
            case 0:
                this.rolls =9;
                break;
            case 1:
                this.rolls= 16;
                break;
            case 2:
                this.rolls = 24;
                break;
        }
    }

    public void setMines() {
        switch (getLevel()) {
            case 0:
                this.mines = 10;
                break;
            case 1:
                this.mines = 40;
                break;
            case 2:
                this.mines = 99;
                break;
        }
    }

    private int getLevel() {
        return this.level;
    }

    private int getRolls() {
        return this.rolls;
    }

    private int getMines(){
        return  this.mines;
    }

    public Cell[][] createClientBoard(){

        for (int y = 0; y < getRolls(); y++) {
            for (int x = 0; x < getRolls(); x++) {
                maskedBoard[y][x] = new MaskedCell();
            }
        }

        return maskedBoard;
    }


}
