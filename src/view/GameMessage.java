package view;

public class GameMessage {
    static final String ENTER_MOVE = "Enter your move, (row, column)\n"+
            "->";
    static final String CURR_STATUS_BOARD = "Current Status of Board :";

    static final String GAME_LOST = "You lost !";
    static final String GAME_WON = "You won !";

    private final String msgMove;
    private final String msgStatus;
    private final String msgLost;
    private final String msgWon;

    public GameMessage() {
        this.msgMove = ENTER_MOVE;
        this.msgLost = GAME_LOST;
        this.msgWon = GAME_WON;
        this.msgStatus = CURR_STATUS_BOARD;
    }

    public String getMsgMove(){
        return this.msgMove;
    }

    public String getMsgStatus(){
        return this.msgStatus;
    }

    public String getMsgWon(){
        return this.msgWon;
    }

    public String getMsgLost(){
        return this.msgLost;
    }
}
