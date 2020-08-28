package controller;

import model.Cell;
import model.GameBoard;

public class BoardController {
    private GameBoard gameBoard;
    private GameBoard maskedBoard;
    private int yRow;
    private int xCol;
    private boolean dead;

    //this board is what the client' ll see
    public BoardController(int inputLevel) {
        this.maskedBoard = new GameBoard(inputLevel);
    }

    //here is the generated with mines board
    public BoardController(int inputLevel, int colX, int rolY) {
        this.gameBoard = new GameBoard(inputLevel);
        this.yRow = rolY;
        this.xCol = colX;
        this.dead = false;
    }


    public Cell[][] getMaskedBoard() {
        return this.maskedBoard.createClientBoard();
    }

    private void setDead(){
        this.dead = true;
    }

    public boolean getDead(){
        return this.dead;
    }


    public void play(int r, int c){
        System.out.println(this.gameBoard.getCellStatus(r,c));
        if (this.gameBoard.getCellStatus(r,c)){
//            this.printGameBoard();
            this.setDead();
        }
    }


    public Cell[][] getInitialGameBoard() {
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
        int iterNumber = this.gameBoard.getGameBoard().length;

        for (int i = 0; i < iterNumber; i++) {
            System.out.println();
            for (int j = 0; j < iterNumber; j++) {
                System.out.print(getInitialGameBoard()[i][j].getValue() + " ");
            }
        }

    }

}
