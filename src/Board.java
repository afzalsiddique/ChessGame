import Pieces.*;

public class Board {
    public Piece[][] positions = new Piece[8][8];
    boardGUI UI;

    boolean checkGameState(Piece[][] positions){
        return false;
    }

    boolean updateGameState(Piece[][] positions) {
        return false;
    }

    Board(boardGUI UI){
        this.UI = UI;
    }

    public void start(){
        positions[0][0] = new RookWhite();
        positions[0][7] = new RookWhite();

        positions[0][1] = new KnightWhite();
        positions[0][6] = new KnightWhite();

        positions[0][2] = new BishopWhite();
        positions[0][5] = new BishopWhite();

        positions[0][4] = new KingWhite();
        positions[0][3] = new QueenWhite();

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

        positions[7][4] = new KingBlack();
        positions[7][3] = new QueenBlack();
    }
    boolean isKingChecked(){
        return false;
    }

    void RemoveThisLater(){
        positions[0][0].setReferredButton(UI.button1);
        positions[1][0].setReferredButton(UI.button9);
        positions[2][0].setReferredButton(UI.button17);
        positions[3][0].setReferredButton(UI.button25);
        positions[4][0].setReferredButton(UI.button33);
        positions[5][0].setReferredButton(UI.button41);
        positions[6][0].setReferredButton(UI.button49);
        positions[7][0].setReferredButton(UI.button55);
    }
}
