package BackEndLogic;

import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(boolean isWhite, Spot spot){
        this.isWhite = isWhite;
        this.spot = spot;
    }
    @Override
    public boolean makeMove(Piece[][] positions) {
        return super.makeMove(positions);
    }

    @Override
    public ArrayList<Spot> calculateAllPossibleMoves(Board board) {
        availableMoves.clear();
        for(int row = 0;row<8;row++){
            if(spot.row == row)
                continue;
            availableMoves.add(new Spot(row,spot.col));
        }
        for(int col = 0;col<8;col++){
            if(spot.row == col)
                continue;
            availableMoves.add(new Spot(spot.row,col));
        }
        return  availableMoves;
    }


    public void castling(){

    }
}
