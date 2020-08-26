package view;

public class GameMessage {
    static final String ENTER_MOVE = "Enter your move, (row, column)\n"+
            "->\n";

    static final String GAME_LOST = "You lost !";
    static final String GAME_WON = "You won !";

    private final String msgMove;
    private final String msgLost;
    private final String msgWon;

    private GameMessage() {
        this.msgMove = ENTER_MOVE;
        this.msgLost = GAME_LOST;
        this.msgWon = GAME_WON;
    }

    public String getMsgMove(){
        return this.msgMove;
    }

    public String getMsgWon(){
        return this.msgWon;
    }

    public String getMsgLost(){
        return this.msgLost;
    }
}
