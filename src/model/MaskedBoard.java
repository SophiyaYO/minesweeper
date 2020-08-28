package model;

import repositories.BoardRepository;

public class MaskedBoard extends BoardRepository.GameBoard {

    public MaskedBoard(int numberLevel) {
        super(numberLevel);
        setBoard();
    }

    public Cell[][] getBoard() {
        return super.getBoard();
    }

//    public Cell[][] generateGameBoard(int size, int colX, int rolY, int mines) {
//
//        for (int y = 0; y < size; y++) {
//            for (int x = 0; x < size; x++) {
////                gameBoard[y][x] = new MaskedCell();
//            }
//        }
//
//        setGameBoardMines(size, colX, rolY, mines);
//
//        return gameBoard;
//    }

//    public Cell[][] getGameBoard() {
//        return this.gameBoard;
//    }

//    public boolean getCellStatus(int r, int c) {
//        return this.gameBoard[r][c].getIsMine();
//    }

//    private void setGameBoardMines(int size, int colX, int rolY, int mines) {
//        int counter = mines;
//        Random random = new Random();
//        while (counter > 0) {
//            int row = random.nextInt(size);
//            int col = random.nextInt(size);
//
//            if (row == rolY && col == colX) {
//                while (row == rolY || col == colX) {
//                    row = random.nextInt(size);
//                    col = random.nextInt(size);
//                }
//            }
//
//            if (!gameBoard[row][col].hasMine) {
//                gameBoard[row][col] = new MineCell();
//                counter--;
//            }
//        }
//    }


}
