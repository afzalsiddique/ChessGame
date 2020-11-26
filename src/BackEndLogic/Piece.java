package BackEndLogic;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Piece {
    Spot spot;
    private ImageIcon image;
    boolean isWhite;
    public ArrayList<Spot> availableMoves = new ArrayList<>();
    Board board;
    public String color;
    static int value;
    public void setBoard(Board board){
        this.board = board;
    }


    public ArrayList<Spot> calculateAllPossibleMoves() {
        availableMoves.clear();
        availableMoves.add(new Spot(0,0));
        return availableMoves;
    }

    public boolean getColor() {
        return isWhite;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public ImageIcon getImage(){
        return image;
    }

    public void setImage(ImageIcon image) {
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
}