package Pieces;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class Pawn extends Piece {

    @Override
    public boolean makeMove(int[][] positions) {
        return false;
    }

    @Override
    public String[] checkAvailableMoves() {
        return new String[0];
    }


}
