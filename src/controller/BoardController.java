package controller;

import model.Cell;
import model.MaskedBoard;
import model.RealBoard;
import view.GameMessage;

import java.util.Iterator;
import java.util.Map;

public class BoardController {
    private RealBoard realBoard;
    private MaskedBoard maskedBoard;
    private GameMessage activeMsg;
    private boolean dead;

    public BoardController(int inputLevel) {
        this.maskedBoard = new MaskedBoard(inputLevel);
        this.realBoard = new RealBoard(inputLevel);
        this.activeMsg = new GameMessage();
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

    public void initialStart() {
        this.activeMsg.getMsgMove();
        printBoard(getMaskedBoard());
        this.activeMsg.getMsgMove();
    }

    public void firstCellChosen(int r, int c){
        this.realBoard.setGameBoardMines(c, r);
        this.activeMsg.getMsgStatus();
        printBoard(getRealBoard());
        this.activeMsg.getMsgMove();
    }

    public void play(int r, int c) {
        if (this.realBoard.getCellStatus(r, c)) {

            for (Integer mine : this.realBoard.getMineLocations().keySet()) {
                int x = this.realBoard.getMineLocations().get(mine)[0];
                int z = this.realBoard.getMineLocations().get(mine)[1];

                this.maskedBoard.updateStatusToMines(x,z);
            }

            this.setDead();
            this.activeMsg.getMsgStatus();
            printBoard(this.getMaskedBoard());
            this.activeMsg.getMsgLost();
        } else {
            this.realBoard.updateTypeCell(r,c);

        }

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

}
