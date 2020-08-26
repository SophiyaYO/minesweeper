package controller;

import model.GameBoard;
import repositories.CellRepository;

public class BoardController {
    private GameBoard gameBoard;
    private GameBoard maskedBoard;

    public BoardController(int inputLevel){
        this.gameBoard = new GameBoard(inputLevel);
        this.maskedBoard = new GameBoard(inputLevel);
    }

    public CellRepository[][] getMaskedBoard() {

        return this.maskedBoard.createClientBoard();
    }

    public void printMaskedBoard() {
        int iterNumber = getMaskedBoard().length;
        StringBuilder outputLine = new StringBuilder();

        System.out.println("Current Status of Board :");

        for (int i = 0; i < iterNumber; i++) {
            if (i==0){
                outputLine.append("    ");
                for (int k = 0; k < iterNumber; k++) {
                    outputLine.append(k).append(" ");
                }
                outputLine.append(System.getProperty("line.separator"));

            }
            for (int j = 0; j < iterNumber; j++) {
                if (j==0){
                    outputLine.append(i);
                    outputLine.append("   ");
                }
                outputLine.append(getMaskedBoard()[i][j].getValue()).append(" ");
            }

            outputLine.append(System.getProperty("line.separator"));
        }

        System.out.println(outputLine.toString().replaceFirst("\\s++$", ""));
    }
}
