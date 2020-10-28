package Pieces;

import java.util.ArrayList;

public class Knight extends Piece {
    @Override
    public boolean makeMove(int[][] positions) {
        return false;
    }

    @Override
    public ArrayList<Spot> calculateAvailableMoves() {
        availableMoves.clear();
        availableMoves.add(new Spot(0,0));
        return  availableMoves;
    }

}
