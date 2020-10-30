import Pieces.*;

import java.util.ArrayList;

public class Board {
    public Piece[][] positions = new Piece[8][8];
    ArrayList<Spot> emptySpots = new ArrayList<>();
//    boardGUI UI;

    Piece toMove;
    boolean makingMove = false;
    int prevX, prevY;


    boolean checkGameState(Piece[][] positions){
        return false;
    }

    boolean updateGameState(Piece[][] positions) {
        return false;
    }

//    Board(boardGUI UI){
//        this.UI = UI;
//        UI.setInternalBoard(this);
//        start();
//    }

    void start() {
        positions[1][0] = new Pawn(true, new Spot(6,1));
    }
    public void getEmptySpots(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(this.positions[i][j]==null)
                    emptySpots.add(new Spot(i,j));
            }
        }
    }
}
