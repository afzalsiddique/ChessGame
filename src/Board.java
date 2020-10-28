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

    void start(){

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                positions[i][j] = null;
            }
        }


//        positions[1][3] = new PawnWhite();
//        positions[0][0] = new RookWhite();
//        positions[0][7] = new RookWhite();
//
//        positions[0][1] = new KnightWhite();
//        positions[0][6] = new KnightWhite();
//
//        positions[0][2] = new BishopWhite();
//        positions[0][5] = new BishopWhite();
//
//        positions[0][4] = new KingWhite();
//        positions[0][3] = new QueenWhite();
//
//        for(int i=0;i<8;i++)
//            positions[1][i] = new PawnWhite();

//        for(int i=0;i<8;i++)
//            positions[6][i] = new PawnBlack();
//
//        positions[7][0] = new RookBlack();
//        positions[7][7] = new RookBlack();
//
//        positions[7][1] = new KnightBlack();
//        positions[7][6] = new KnightBlack();
//
//        positions[7][2] = new BishopBlack();
//        positions[7][5] = new BishopBlack();
//
//        positions[7][4] = new KingBlack();
//        positions[7][3] = new QueenBlack();
    }


}
