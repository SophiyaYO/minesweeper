package model;

import java.util.Random;

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
        this.gameBoard = new Cell[getRolls()][getRolls()];
    }

    private void setRolls() {
        switch (getLevel()) {
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

    private void setMines() {
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

    public int getRolls() {
        return this.rolls;
    }

    public int getMines() {
        return this.mines;
    }

    public Cell[][] createClientBoard() {

        for (int y = 0; y < getRolls(); y++) {
            for (int x = 0; x < getRolls(); x++) {
                maskedBoard[y][x] = new MaskedCell();
            }
        }

        return maskedBoard;
    }

    public Cell[][] generateGameBoard(int size, int colX, int rolY, int mines) {
        for (int y = 0; y < getRolls(); y++) {
            for (int x = 0; x < getRolls(); x++) {
                gameBoard[y][x] = new MaskedCell();
            }
        }

        setGameBoardMines(size, colX, rolY,mines);

        return gameBoard;
    }

    private void setGameBoardMines(int size, int colX, int rolY, int mines) {
        int counter = mines;
        Random random = new Random();
        while (counter > 0) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);

            if (row == rolY && col == colX) {
                while (row == rolY || col == colX) {
                    row = random.nextInt(size);
                    col = random.nextInt(size);
                }
            }

            if (!gameBoard[row][col].hasMine) {
                gameBoard[row][col] = new MineCell();
                counter--;
            }
        }
    }


}
