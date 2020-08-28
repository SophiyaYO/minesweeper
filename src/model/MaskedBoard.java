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

    public void updateStatusToMines(int r, int c){
            super.getBoard()[r][c] = new MineCell(); }


}
