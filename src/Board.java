import Pieces.Piece;
import Pieces.Rook;

public class Board {
    public Piece[][] positions;
    boolean checkGameState(Piece[][] positions){
        return false;
    }
    boolean updateGameState(Piece[][] positions) {
        return false;
    }
    void start(){
        positions[0][0] = new Rook();
        
    }
    boolean isKingChecked(){
        return false;
    }
}
