import controller.BoardController;
import view.GameMessage;
import view.IntroMsg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinesweeperApplication {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException {
        IntroMsg introMsg = new IntroMsg();
        introMsg.getIntroMsg();
        int selectedLevel;
        String input = getInput();
        selectedLevel = parseStringToInt(input);

        if (selectedLevel < 0 || selectedLevel > 2) {
            while (selectedLevel < 0 || selectedLevel > 2) {
                introMsg.getIntroMsg();

                input = getInput();
                selectedLevel = parseStringToInt(input);
            }
        }


        BoardController game = new BoardController(selectedLevel);
        game.initialStart();
        String[] moveCoord;
        int rol;
        int col;
        try {
            moveCoord = readNextStringLine();
            col = parseStringToInt(moveCoord[1]);
            rol = parseStringToInt(moveCoord[0]);

            game.firstCellChosen(rol, col);
        } catch (Exception e) {
            System.out.printf("Invalid input!\nSelect number row and coll between 0 and %d, separated by single space.\n", game.getDimension());
        }

        boolean hasLost = false;
        int movesLeft;

        while (!hasLost) {
            try {
                moveCoord = getInput().split(" ");
                col = parseStringToInt(moveCoord[1]);
                rol = parseStringToInt(moveCoord[0]);

                game.play(rol, col);
                movesLeft = game.getMovesLeft();
                hasLost = game.getDead();

                if (movesLeft == 0) {
                    GameMessage gameMessage = new GameMessage();
                    gameMessage.getMsgWon();
                    return;
                }
            } catch (Exception e) {
                System.out.printf("Invalid input!\nSelect number row and coll between 0 and %d, separated by single space.\n", game.getDimension());
            }

        }

    }

    private static String getInput() throws IOException {
        return reader.readLine();
    }

    private static int parseStringToInt(String moveCoord) {
        return Integer.parseInt(moveCoord);
    }

    private static String[] readNextStringLine() throws IOException {
        return getInput().split(" ");
    }
}
