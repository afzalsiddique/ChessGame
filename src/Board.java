import Pieces.*;

public class Board {
    public Piece[][] positions;
    boolean checkGameState(Piece[][] positions){
        return false;
    }
    boolean updateGameState(Piece[][] positions) {
        return false;
    }
    void start(){
        positions[0][0] = new RookWhite();
        positions[0][7] = new RookWhite();

        positions[0][1] = new KnightWhite();
        positions[0][6] = new KnightWhite();

        positions[0][2] = new BishopWhite();
        positions[0][5] = new BishopWhite();

        positions[0][3] = new KingWhite();
        positions[0][4] = new QueenWhite();

    }
    boolean isKingChecked(){
        return false;
    }
}
