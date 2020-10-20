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
        positions[1][3] = new PawnWhite();
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

    boolean isKingChecked(){
        return false;
    }

    boolean isOccupied(int x, int y){
        System.out.println("This is " + x + " " + y);
        if(positions[x][y] == null)
            return false;
        return true;
    }

    boolean checkIfValid(int x, int y){
        if(y == prevY && x == prevX + 1)
            return true;
        return false;
    }

    void makeMove(int x, int y){
        System.out.println("Internal:\n" + x + " " + y + "\nMakingMove=" + makingMove);
        if(makingMove){
            positions[x][y] = toMove;
            positions[prevX][prevY] = null;
            makingMove = false;
            toMove = null;
        }
        else{
            toMove = positions[x][y];
            prevX = x;
            prevY = y;
            makingMove = true;
        }
    }

    void RemoveThisLater(){
        positions[0][0].setReferredButton(UI.button1);
        positions[1][0].setReferredButton(UI.button9);
        positions[2][0].setReferredButton(UI.button17);
        positions[3][0].setReferredButton(UI.button25);
        positions[4][0].setReferredButton(UI.button33);
        positions[5][0].setReferredButton(UI.button41);
        positions[6][0].setReferredButton(UI.button49);
        positions[7][0].setReferredButton(UI.button57);
    }
}
