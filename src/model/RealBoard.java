package model;

import repositories.BoardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RealBoard extends BoardRepository.GameBoard {
    private List<int[]> mineLocations;
    private List<int[]> recursionEmptyCells;

    public RealBoard(int numberLevel) {
        super(numberLevel);
        setBoard();
        this.mineLocations = new ArrayList<>();
        this.recursionEmptyCells = new ArrayList<>();
    }

    public Cell[][] getBoard() {
        return super.getBoard();
    }


    public boolean getCellStatus(int r, int c) {
        return this.getBoard()[r][c].getIsMine();
    }

    public List<int[]> getMineLocations() {
        return this.mineLocations;
    }

    public List<int[]> getRecursionEmptyCells() {
        return this.recursionEmptyCells;
    }

    public void setGameBoardMines(int colX, int rolY) {
        int counter = super.getMines();
        Random random = new Random();

        while (counter > 0) {
            int row = random.nextInt(super.getRolls());
            int col = random.nextInt(super.getRolls());

            if (isValidCell(row, col)) {
                if (row == rolY && col == colX) {
                    boolean continueRand = true;
                    while (continueRand) {
                        row = random.nextInt(super.getRolls());
                        col = random.nextInt(super.getRolls());
                        if (isValidCell(row, col)) {
                            if ((row != rolY || col != colX)) {
                                continueRand = false;
                            }
                        }
                    }
                }

                if (!getCellStatus(row,col)) {
                    this.getBoard()[row][col] = new MineCell();
                    mineLocations.add(new int[]{row, col});
                    counter--;
                }
            }
        }

        calculateAndSetOnPositionDigitCells();
    }

    private void calculateAndSetOnPositionDigitCells(){
        for (int[] mine : this.getMineLocations()) {

            if (isValidCell(mine[0], mine[1] - 1)) {
                this.updateTypeCell(mine[0], mine[1] - 1);
            }
            if (isValidCell(mine[0], mine[1] + 1)) {
                this.updateTypeCell(mine[0], mine[1] + 1);
            }
            if (isValidCell(mine[0] + 1, mine[1] + 1)) {
                this.updateTypeCell(mine[0]+ 1, mine[1] + 1);
            }
            if (isValidCell(mine[0] + 1, mine[1] - 1)) {
                this.updateTypeCell(mine[0]+ 1, mine[1] - 1);
            }
            if (isValidCell(mine[0] - 1, mine[1] + 1)) {
                this.updateTypeCell(mine[0]- 1, mine[1] + 1);
            }
            if (isValidCell(mine[0] - 1, mine[1] - 1)) {
                this.updateTypeCell(mine[0]- 1, mine[1] - 1);
            }
            if (isValidCell(mine[0] - 1, mine[1])) {
                this.updateTypeCell(mine[0]- 1, mine[1]);
            }
            if (isValidCell(mine[0] + 1, mine[1])) {
                this.updateTypeCell(mine[0] + 1, mine[1]);
            }
        }
    }

    private boolean isValidCell(int row, int col) {
        return (
                (row >= 0 && row < super.getRolls())
                        && (col >= 0 && col < super.getRolls()));
    }

    public void recursionEmptyCells(int r, int c) {
        if (isValidCell(r, c)) {
            if (!this.recursionEmptyCells.isEmpty()) {
                this.recursionEmptyCells.clear();
            }
            if (isValidCell(r, c - 1)) {
                if (!this.getBoard()[r][c - 1].getIsMine()) {
                    updateTypeCell(r, c - 1);
                }
            }
            if (isValidCell(r, c + 1)) {
                if (!this.getBoard()[r][c + 1].getIsMine()) {
                    updateTypeCell(r, c + 1);

                }
            }
            if (isValidCell(r + 1, c + 1)) {
                if (!this.getBoard()[r + 1][c + 1].getIsMine()) {
                    updateTypeCell(r + 1, c + 1);

                }
            }
            if (isValidCell(r + 1, c - 1)) {
                if (!this.getBoard()[r + 1][c - 1].getIsMine()) {
                    updateTypeCell(r + 1, c - 1);
                }
            }
            if (isValidCell(r - 1, c + 1)) {
                if (!this.getBoard()[r - 1][c + 1].getIsMine()) {
                    updateTypeCell(r - 1, c + 1);
                }
            }
            if (isValidCell(r - 1, c - 1)) {
                if (!this.getBoard()[r - 1][c - 1].getIsMine()) {
                    updateTypeCell(r - 1, c - 1);
                }
            }
            if (isValidCell(r - 1, c)) {
                if (!this.getBoard()[r - 1][c].getIsMine()) {
                    updateTypeCell(r - 1, c);
                }
            }
            if (isValidCell(r + 1, c)) {
                if (!this.getBoard()[r + 1][c].getIsMine()) {
                    updateTypeCell(r + 1, c);
                }
            }
        } else {
            //exception
        }
    }

    public void updateTypeCell(int r, int c) {
        if (isValidCell(r, c)) {
            int countMines = 0;

            if (isValidCell(r, c - 1)) {
                if (this.getBoard()[r][c - 1].getIsMine()) {
                    countMines++;
                }
            }
            if (isValidCell(r, c + 1)) {
                if (this.getBoard()[r][c + 1].getIsMine()) {
                    countMines++;
                }
            }
            if (isValidCell(r + 1, c + 1)) {
                if (this.getBoard()[r + 1][c + 1].getIsMine()) {
                    countMines++;
                }
            }
            if (isValidCell(r + 1, c - 1)) {
                if (this.getBoard()[r + 1][c - 1].getIsMine()) {
                    countMines++;
                }
            }
            if (isValidCell(r - 1, c + 1)) {
                if (this.getBoard()[r - 1][c + 1].getIsMine()) {
                    countMines++;
                }
            }
            if (isValidCell(r - 1, c - 1)) {
                if (this.getBoard()[r - 1][c - 1].getIsMine()) {
                    countMines++;
                }
            }
            if (isValidCell(r - 1, c)) {
                if (this.getBoard()[r - 1][c].getIsMine()) {
                    countMines++;
                }
            }
            if (isValidCell(r + 1, c)) {
                if (this.getBoard()[r + 1][c].getIsMine()) {
                    countMines++;
                }
            }

            if (countMines == 0) {
                return;
            }

            this.getBoard()[r][c] = new DigitCell(countMines);


        } else {
            //ADD EXCEPTION
        }
    }

}
