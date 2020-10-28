package Pieces;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Piece {

    ImageIcon image;
    JButton ReferredButton;
    protected boolean isWhite;
    public ArrayList<Spot> availableMoves;

    public boolean makeMove(int[][] positions) {
        return false;
    }

    public void calculateAvailableMoves() {
        availableMoves.add(new Spot(0,0));
    }

    public void setReferredButton(JButton referredButton) {
        ReferredButton = referredButton;
    }

    public JButton getReferredButton() {
        return ReferredButton;
    }

    public ImageIcon getImage(){
        return image;
    }

    public void castling(){
    
    }
}