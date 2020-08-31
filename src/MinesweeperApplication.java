import controller.BoardController;
import view.IntroMsg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinesweeperApplication {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        IntroMsg introMsg = new IntroMsg();
        introMsg.getIntroMsg();

        String input = reader.readLine();
        int selectedLevel = Integer.parseInt(input);

        BoardController game = new BoardController(selectedLevel);
        game.initialStart();

        String[] moveCoord = reader.readLine().split(" ");
        int col = Integer.parseInt(moveCoord[1]);
        int rol = Integer.parseInt(moveCoord[0]);

//        game.play(rol, col);
        game.firstCellChosen(rol,col);

        boolean hasLost = false;

        while (!hasLost){
            moveCoord = reader.readLine().split(" ");
            col = Integer.parseInt(moveCoord[1]);
            rol = Integer.parseInt(moveCoord[0]);

            game.play(rol,col);
            hasLost=game.getDead();

        }
    }
}
