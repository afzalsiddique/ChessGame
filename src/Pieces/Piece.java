package Pieces;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Piece {
    Spot spot;
    ImageIcon image;
    JButton ReferredButton;
    protected boolean isWhite;
    public ArrayList<Spot> availableMoves = new ArrayList<>();

    public boolean makeMove(int[][] positions) {
        return false;
    }

    public ArrayList<Spot> calculateAvailableMoves() {
        availableMoves.clear();
        availableMoves.add(new Spot(0,0));
        return  availableMoves;
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