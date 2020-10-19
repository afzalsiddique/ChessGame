package Pieces;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class Pawn implements Piece {
    ImageIcon WhiteImage, BlackImage;
    public Pawn(){
        try {
            WhiteImage = new ImageIcon(ImageIO.read(getClass().getResource("PawnWhite.png")));
            BlackImage = new ImageIcon(ImageIO.read(getClass().getResource("PawnBlack.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean makeMove(int[][] positions) {
        return false;
    }

    @Override
    public String[] checkAvailableMoves() {
        return new String[0];
    }


}
