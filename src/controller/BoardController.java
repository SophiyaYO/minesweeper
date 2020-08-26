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

        System.out.println("Current Status of Board :");

        for (int i = 0; i < iterNumber; i++) {
            if (i==0){
                System.out.println();

            }
            for (int j = 0; j < iterNumber; j++) {
                System.out.print(getMaskedBoard()[i][j].getValue() + " ");
            }
            System.out.println();
        }
    }
}
