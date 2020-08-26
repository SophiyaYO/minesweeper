package model;

import repositories.GameLevelRepository;

public class GameBoard {
    private int level;
    private int rolls;
    private int cols;
    private int mines;

    public GameBoard(int numberLevel) {
        this.level = numberLevel;
    }

    private void setRolls() {
        switch (level) {
            case 0:
                this.rolls = 9;
                break;
            case 1:
                this.rolls = 16;
                break;
            case 2:
                this.rolls = 24;
                break;

        }
    }

    public void setCols() {
        this.cols = this.getRolls();
    }

    private int getRolls() {
        return this.rolls;
    }

    public void setMines(int mines) {
        this.mines = mines;
    }

    public int getLevel() {
        return this.level;
    }


}
