package Pieces;

import java.util.ArrayList;

public class Pawn extends Piece {
    public Pawn(boolean isWhite, Spot spot){
        this.isWhite = isWhite;
        this.spot = spot;
    }
    @Override
    public boolean makeMove(Piece[][] positions) {
        return false;
    }

    @Override
    public ArrayList<Spot> calculateAllPossibleMoves() {

        availableMoves.clear();
        if (spot.row >=0 && spot.row <=7 && spot.col >=0 && spot.col <=7)
            availableMoves.add(new Spot(spot.row -1, spot.col));
        if (spot.row >=0 && spot.row <=7 && spot.col >=0 && spot.col <=7)
            availableMoves.add(new Spot(spot.row -1, spot.col -1));
        if (spot.row >=0 && spot.row <=7 && spot.col >=0 && spot.col <=7)
            availableMoves.add(new Spot(spot.row -1, spot.col +1));
        return  availableMoves;
    }



}
