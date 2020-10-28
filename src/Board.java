import Pieces.*;

public class Board {
    public Piece[][] positions = new Piece[8][8];
    boardGUI UI;

    Piece toMove;
    boolean makingMove = false;
    int prevX, prevY;


    boolean checkGameState(Piece[][] positions){
        return false;
    }

    boolean updateGameState(Piece[][] positions) {
        return false;
    }

    Board(boardGUI UI){
        this.UI = UI;
        UI.setInternalBoard(this);
        start();
    }

    void start() {
        positions[1][0] = new Pawn(true);
    }
}
