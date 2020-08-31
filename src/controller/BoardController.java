package controller;

import model.*;
import view.GameMessage;

public class BoardController {
    private final RealBoard realBoard;
    private final MaskedBoard maskedBoard;
    private final GameMessage activeMsg;
    private boolean dead;

    public BoardController(int inputLevel) {
        this.maskedBoard = new MaskedBoard(inputLevel);
        this.realBoard = new RealBoard(inputLevel);
        this.activeMsg = new GameMessage();
    }

    private Cell[][] getMaskedBoard() {
        return this.maskedBoard.getBoard();
    }

    private Cell[][] getRealBoard() {
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

    public void firstCellChosen(int r, int c) {
        if (isValidCell(r, c)) {
            this.realBoard.setGameBoardMines(c, r);

            if (this.getRealBoard()[r][c].getValue().equals("-")) {
                this.getMaskedBoard()[r][c] = new EmptyCell(r, c);
                this.getRealBoard()[r][c] = new EmptyCell(r, c);
            }

//            printBoard(this.getRealBoard());//todo: delete this row later
            this.getMaskedBoard()[r][c] = this.getRealBoard()[r][c];

            if (checkIfCellIsEmpty(r, c)) {
                openAdjacentEmptyCells(r, c);
            }
            printBoard(this.maskedBoard.getBoard());
            this.activeMsg.getMsgMove();
        } else {
            //todo: exceptions
        }

    }

    public void play(int r, int c) {
        if (isValidCell(r, c)) {
            //dead statement- if chosen cell is mine
            if (this.realBoard.getCellStatus(r, c)) {

                for (int[] mine : this.realBoard.getMineLocations()) {
                    this.maskedBoard.updateStatusToMines((mine)[0], (mine)[1]);
                }

                this.setDead();
                printCurrentClientBoardAndMsgs();
            } else {

                if (checkIfCellIsEmpty(r, c)) {
                    //recursive
                    this.getMaskedBoard()[r][c] = this.getRealBoard()[r][c];
                    openAdjacentEmptyCells(r, c);

                    printBoard(this.maskedBoard.getBoard());
                    this.activeMsg.getMsgMove();

                } else {
                    this.getMaskedBoard()[r][c] = this.getRealBoard()[r][c];
                    printBoard(this.maskedBoard.getBoard());
                    this.activeMsg.getMsgMove();
                }
            }
        } else {
            //todo: exceptions
        }
    }

    private boolean isValidCell(int row, int col) {
        return (
                (row >= 0 && row < this.realBoard.getRolls())
                        && (col >= 0 && col < this.realBoard.getRolls()));
    }

    private boolean checkIfCellIsEmpty(int r, int c) {
        boolean isEmpty = false;
        if ((this.getRealBoard()[r][c] instanceof EmptyCell) || this.getRealBoard()[r][c] instanceof MaskedCell) {
            this.getRealBoard()[r][c] = new EmptyCell(r, c);
            isEmpty = true;
        }

        return isEmpty;
    }

    private void openAdjacentEmptyCells(int r, int c) {
        this.realBoard.recursionEmptyCells(r, c);

        for (Cell mine : this.realBoard.getRecursionEmptyCellsCollection()) {
            int row = mine.getRow();
            int col = mine.getCol();
            this.maskedBoard.updateStatusToEmpty(row, col);
        }
        this.realBoard.getRecursionEmptyCellsCollection().clear();
    }

    private void printCurrentClientBoardAndMsgs() {
        this.activeMsg.getMsgStatus();
        printBoard(this.getMaskedBoard());
        this.activeMsg.getMsgLost();
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
