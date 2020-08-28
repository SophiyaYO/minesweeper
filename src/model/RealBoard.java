package model;

import repositories.BoardRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RealBoard extends BoardRepository.GameBoard {
    private Map<Integer, int[]> mineLocations;
    private Map<int[],Integer> adjacentCells;

    public RealBoard(int numberLevel) {
        super(numberLevel);
        setBoard();
        this.mineLocations = new HashMap<>();
        this.adjacentCells = new HashMap<>();
    }

    public Cell[][] getBoard() {
        return super.getBoard();
    }


    public boolean getCellStatus(int r, int c) {
        return this.getBoard()[r][c].getIsMine();
    }

    public Map<Integer, int[]> getMineLocations() {
        return this.mineLocations;
    }

    public void setGameBoardMines(int colX, int rolY) {
        int counter = super.getMines();
        Random random = new Random();

        while (counter > 0) {
            int row = random.nextInt(super.getRolls());
            int col = random.nextInt(super.getRolls());

            if (row == rolY && col == colX) {
                while (row == rolY || col == colX) {
                    row = random.nextInt(super.getRolls());
                    col = random.nextInt(super.getRolls());
                }
            }

            if (!getBoard()[row][col].hasMine) {
                getBoard()[row][col] = new MineCell();

                if (!mineLocations.containsKey(counter)) {
                    mineLocations.put(counter, new int[]{row, col});
                }

                counter--;
            }
        }
    }

    private boolean isValidCell(int row, int col) {
        return (
                (row >= 0 && row < super.getRolls())
                        && (col >= 0 && col < super.getRolls()));
    }


    public void updateTypeCell(int r, int c) {
        if (isValidCell(r, c)) {
            int countMines = 0;
                //check north
            if (isValidCell(r, c - 1)) {
                if (this.getBoard()[r][c - 1].getIsMine()){
                    countMines++;
                }
            }
            if (isValidCell(r, c + 1)) {
                if (this.getBoard()[r][c + 1].getIsMine()){
                    countMines++;
                }
            }
            if (isValidCell(r+1, c + 1)) {
                if (this.getBoard()[r+1][c + 1].getIsMine()){
                    countMines++;
                }
            }
            if (isValidCell(r+1, c - 1)) {
                if (this.getBoard()[r+1][c - 1].getIsMine()){
                    countMines++;
                }
            }
            if (isValidCell(r-1, c + 1)) {
                if (this.getBoard()[r-1][c + 1].getIsMine()){
                    countMines++;
                }
            }
            if (isValidCell(r-1, c - 1)) {
                if (this.getBoard()[r-1][c - 1].getIsMine()){
                    countMines++;
                }
            }
            if (isValidCell(r-1, c )) {
                if (this.getBoard()[r-1][c ].getIsMine()){
                    countMines++;
                }
            }
            if (isValidCell(r+1, c )) {
                if (this.getBoard()[r+1][c ].getIsMine()){
                    countMines++;
                }
            }

            this.getBoard()[r][c] = new DigitCell(countMines);


        } else {
            //ADD EXCEPTION
        }
    }

}
