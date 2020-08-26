package controller;

import model.Cell;
import model.GameBoard;

public class BoardController {
    private GameBoard gameBoard;
    private GameBoard maskedBoard;
    private int yRow;
    private int xCol;

    public BoardController(int inputLevel) {
        this.maskedBoard = new GameBoard(inputLevel);
    }

    public BoardController(int inputLevel, int colX, int rolY) {
        this.gameBoard = new GameBoard(inputLevel);
        this.yRow = rolY;
        this.xCol = colX;
    }

    public Cell[][] getMaskedBoard() {

        return this.maskedBoard.createClientBoard();
    }

    public Cell[][] getGameBoard() {
        int mines = this.gameBoard.getMines();
        int size = this.gameBoard.getRolls();

        return this.gameBoard.generateGameBoard(size,this.xCol, this.yRow,mines);
    }

    public void printMaskedBoard() {
        int iterNumber = getMaskedBoard().length;
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
                outputLine.append(getMaskedBoard()[i][j].getValue()).append(" ");
            }

            outputLine.append(System.getProperty("line.separator"));
        }

        System.out.println(outputLine.toString().replaceFirst("\\s++$", ""));
    }

    public void printGameBoard(){
        int iterNumber = getGameBoard().length;

        for (int i = 0; i < iterNumber; i++) {
            System.out.println();
            for (int j = 0; j < iterNumber; j++) {
                System.out.print(getGameBoard()[i][j].getValue() + " ");
            }
        }

    }

}
