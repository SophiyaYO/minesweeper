import controller.BoardController;
import view.GameMessage;
import view.IntroMsg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinesweeperApplication {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int selectedLevel;
        IntroMsg introMsg = new IntroMsg();
        introMsg.getIntroMsg();

        String input = getInput();
        selectedLevel = parseStringToInt(input);

        BoardController game = new BoardController(selectedLevel);
        game.initialStart();

        String[] moveCoord = readNextStringLine();
        int col = parseStringToInt(moveCoord[1]);
        int rol = parseStringToInt(moveCoord[0]);

        game.firstCellChosen(rol, col);

        boolean hasLost = false;
        int movesLeft;

        while (!hasLost) {
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
