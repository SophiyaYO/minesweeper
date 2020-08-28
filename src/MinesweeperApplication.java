import controller.BoardController;
import view.GameMessage;
import view.IntroMsg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinesweeperApplication {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        IntroMsg msg = new IntroMsg();
        System.out.println(msg.getIntroMsg());

        String input = reader.readLine();
        int selectedLevel = Integer.parseInt(input);


        String[] moveCoord = reader.readLine().split(" ");
        int col = Integer.parseInt(moveCoord[1]);
        int rol = Integer.parseInt(moveCoord[0]);

        BoardController game = new BoardController(selectedLevel);
        game.play(rol,col);

        boolean hasLost = false;

//        while (!hasLost){
//            System.out.println(activeMsg.getMsgMove());
//            moveCoord = reader.readLine().split(" ");
//            col = Integer.parseInt(moveCoord[1]);
//            rol = Integer.parseInt(moveCoord[0]);
//
////            gameBoard.play(rol, col);
////            hasLost = gameBoard.getDead();
////            System.out.println(activeMsg.getMsgStatus());
//        }
    }
}
