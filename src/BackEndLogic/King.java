package BackEndLogic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class King extends Piece {

    public King(boolean isWhite, Spot inputSpot){
        this.isWhite = isWhite;
        this.currentSpot = inputSpot;
        importImage();
        setValue();
    }

    private void importImage(){
        try {
            if(isWhite){
                setImage(new ImageIcon(ImageIO.read(getClass().getResource("KingWhite.png"))));
            }
            else {
                setImage(new ImageIcon(ImageIO.read(getClass().getResource("KingBlack.png"))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void setValue() {
        value = 15;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public ArrayList<Spot> calculateAllPossibleMoves() {
        availableMoves.clear();
        int row = currentSpot.row;
        int col = currentSpot.col;
        if(row + 1 <= 7)
            availableMoves.add(new Spot(row+1, col));
        if(row - 1 >= 0)
            availableMoves.add(new Spot(row-1, col));
        if(col + 1 <= 7)
            availableMoves.add(new Spot(row, col+1));
        if(col - 1 >= 0)
            availableMoves.add(new Spot(row, col-1));

        if(row + 1 <= 7 && col + 1 <= 7)
            availableMoves.add(new Spot(row+1, col+1));
        if(row + 1 <= 7 && col - 1 >= 0)
            availableMoves.add(new Spot(row+1, col-1));
        if(row - 1 >= 0 && col + 1 <= 7)
            availableMoves.add(new Spot(row-1, col+1));
        if(row - 1 >= 0 && col - 1 >= 0)
            availableMoves.add(new Spot(row-1, col-1));


        return  availableMoves;
    }

    public void castling(){

    }
}
