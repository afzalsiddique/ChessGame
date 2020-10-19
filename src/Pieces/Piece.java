package Pieces;

import javax.swing.*;

public abstract class Piece {

    ImageIcon image;
    JButton ReferredButton;

    public boolean makeMove(int[][] positions) {
        return false;
    }
    public String[] checkAvailableMoves() {
        return new String[0];
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