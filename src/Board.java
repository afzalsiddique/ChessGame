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

        for(int i=0;i<8;i++)
            positions[1][i] = new PawnWhite();

        for(int i=0;i<8;i++)
            positions[6][i] = new PawnBlack();

        positions[7][0] = new RookBlack();
        positions[7][7] = new RookBlack();

        positions[7][1] = new KnightBlack();
        positions[7][6] = new KnightBlack();

        positions[7][2] = new BishopBlack();
        positions[7][5] = new BishopBlack();

        positions[7][3] = new KingBlack();
        positions[7][4] = new QueenBlack();
    }
    boolean isKingChecked(){
        return false;
    }
}
