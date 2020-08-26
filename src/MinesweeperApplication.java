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

        System.out.println(selectedLevel);

    }
}
