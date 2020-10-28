package Pieces;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class Pawn extends Piece {

    public Pawn(boolean isWhite){
        this.isWhite = isWhite;
    }
    @Override
    public boolean makeMove(int[][] positions) {
        return false;
    }

    @Override
    public void calculateAvailableMoves() {
        availableMoves.add(new Spot(0,0));
    }


}
