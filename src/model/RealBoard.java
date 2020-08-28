package model;

import repositories.BoardRepository;

import java.util.Random;

public class RealBoard extends BoardRepository.GameBoard {

    public RealBoard(int numberLevel) {
        super(numberLevel);
        setBoard();
    }

    public Cell[][] getBoard() {
        return super.getBoard();
    }


//    public boolean getCellStatus(int r, int c) {
//        return this.gameBoard[r][c].getIsMine();
//    }

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
                counter--;
            }
        }
    }


}
