package Pieces;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
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
        if (spot.x >=0 && spot.x <=7 && spot.y >=0 && spot.y <=7)
            availableMoves.add(new Spot(spot.x-1, spot.y));
        if (spot.x >=0 && spot.x <=7 && spot.y >=0 && spot.y <=7)
            availableMoves.add(new Spot(spot.x-1, spot.y-1));
        if (spot.x >=0 && spot.x <=7 && spot.y >=0 && spot.y <=7)
            availableMoves.add(new Spot(spot.x-1, spot.y+1));
        return  availableMoves;
    }



}
