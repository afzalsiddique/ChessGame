package Pieces;

import java.util.ArrayList;

public class Rook extends Piece {
    @Override
    public boolean makeMove(Piece[][] positions) {
        return super.makeMove(positions);
    }

    @Override
    public ArrayList<Spot> calculateAllPossibleMoves() {
        availableMoves.clear();
        availableMoves.add(new Spot(0,0));
        return  availableMoves;
    }


    public void castling(){

    }
}
