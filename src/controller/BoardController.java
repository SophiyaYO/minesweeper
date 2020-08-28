package controller;

import model.Cell;
import model.MaskedBoard;
import model.RealBoard;
import view.GameMessage;

public class BoardController {
    private RealBoard realBoard;
    private MaskedBoard maskedBoard;
    private boolean dead;

    public BoardController(int inputLevel) {
        this.maskedBoard = new MaskedBoard(inputLevel);
        this.realBoard = new RealBoard(inputLevel);
    }

    public Cell[][] getMaskedBoard() {
        return this.maskedBoard.getBoard();
    }

    public Cell[][] getRealBoard() {
        return this.realBoard.getBoard();
    }

    private void setDead() {
        this.dead = true;
    }

    public boolean getDead() {
        return this.dead;
    }

    public void initialStart(){
        GameMessage activeMsg = new GameMessage();
        activeMsg.getMsgMove();
    }

    public void play(int r, int c) {
//        System.out.println(this.gameBoard.getCellStatus(r,c));
//        if (this.gameBoard.getCellStatus(r,c)){
////            this.printGameBoard();
//            this.setDead();
//        }

        printBoard(getMaskedBoard());
        this.realBoard.setGameBoardMines(c,r);
        printBoard(getRealBoard());


    }
    public void printBoard(Cell[][] board) {
        int iterNumber = board.length;
        StringBuilder outputLine = new StringBuilder();

        System.out.println("Current Status of Board :");

        for (int i = 0; i < iterNumber; i++) {
            if (i == 0) {
                outputLine.append("    ");
                for (int k = 0; k < iterNumber; k++) {
                    outputLine.append(k).append(" ");
                }
                outputLine.append(System.getProperty("line.separator"));

            }
            for (int j = 0; j < iterNumber; j++) {
                if (j == 0) {
                    outputLine.append(i);
                    outputLine.append("   ");
                }
                outputLine.append(board[i][j].getValue()).append(" ");
            }

            outputLine.append(System.getProperty("line.separator"));
        }

        System.out.println(outputLine.toString().replaceFirst("\\s++$", ""));
    }

//    public void printGameBoard(){
//        int iterNumber = this.gameBoard.getGameBoard().length;
//
//        for (int i = 0; i < iterNumber; i++) {
//            System.out.println();
//            for (int j = 0; j < iterNumber; j++) {
//                System.out.print(getInitialGameBoard()[i][j].getValue() + " ");
//            }
//        }
//
//    }

}
