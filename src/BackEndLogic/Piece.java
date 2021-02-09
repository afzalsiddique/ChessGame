package BackEndLogic;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Piece {
    Spot currentSpot;
    private ImageIcon image;
    boolean isWhite;
    public ArrayList<Spot> availableMoves = new ArrayList<>();
    Board board;
    protected int value;
    public void setBoard(Board board){
        this.board = board;
    }

    public ArrayList<Spot> calculateAllPossibleMovesWithoutModifying() {
        availableMoves.clear();
        return availableMoves;
    }

    public ArrayList<Spot> calculateAllPossibleMoves() {
        calculateAllPossibleMovesWithoutModifying();
        this.availableMoves = board.modifyAvailableMoves(availableMoves, currentSpot, isWhite);
        return availableMoves;
    }

    public boolean getColor() {
        return isWhite;
    }

    public Spot getCurrentSpot() {
        return currentSpot;
    }

    public void setCurrentSpot(Spot currentSpot) {
        this.currentSpot = currentSpot;
    }

    public ImageIcon getImage(){
        return image;
    }

    protected void setImage(ImageIcon image) {
        this.image = image;
    }

    public void castling(){
    
    }
    public int getValue(){
        if(isWhite)
            return value;
        else
            return -value;
    }

    abstract void setValue();

    @Override
    abstract public String toString();
}