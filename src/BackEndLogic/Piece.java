package BackEndLogic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Piece {
    Spot spot;
    private ImageIcon image;
    boolean isWhite;
    public ArrayList<Spot> availableMoves = new ArrayList<>();
    Board board;
    public String color;
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
}