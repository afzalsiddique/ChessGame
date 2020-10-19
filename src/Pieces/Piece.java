package Pieces;

import javax.swing.*;

public abstract class Piece {

    ImageIcon image;

    public boolean makeMove(int[][] positions) {
        return false;
    }
    public String[] checkAvailableMoves() {
        return new String[0];
    }
    public ImageIcon getImage(){
        return image;
    }
    public void castling(){

    }
}