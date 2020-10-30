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
    public ArrayList<Spot> calculateAvailableMoves() {
        availableMoves.clear();
        availableMoves.add(new Spot(0,0));
        return  availableMoves;
    }



}
