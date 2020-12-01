package BackEndLogic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Pawn extends Piece {

    private boolean firstMove = true;

    public Pawn(boolean isWhite, Spot spot){
        this.isWhite = isWhite;
        this.currentSpot = spot;
        ImportImage();
        setValue();
    }

    public Pawn(boolean isWhite, int x, int y){
        this.isWhite = isWhite;
        this.currentSpot = new Spot(x,y);
        ImportImage();
        setValue();
    }

    public void setFirstMove(boolean thisBoolean){
        firstMove = thisBoolean;
    }

    private void ImportImage(){
        try {
            if(isWhite){
                setImage(new ImageIcon(ImageIO.read(getClass().getResource("PawnWhite.png"))));
            }
            else {
                setImage(new ImageIcon(ImageIO.read(getClass().getResource("PawnBlack.png"))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Spot> calculateAllPossibleMoves() {
        Piece[][] positions = board.positions;
        availableMoves.clear();
        int currentRow = currentSpot.row;
        int currentCol = currentSpot.col;
        if(isWhite) {
            if (currentRow - 1 >= 0 && !board.isOccupied(new Spot(currentRow-1, currentCol)))
                availableMoves.add(new Spot(currentRow - 1, currentCol));
            if (currentRow - 1 >= 0 && currentCol - 1 >= 0  && board.isOpponent(this,positions[currentRow-1][currentCol-1]))
                availableMoves.add(new Spot(currentRow - 1, currentCol - 1));
            if (currentRow - 1 >= 0 && currentCol + 1 <= 7  && board.isOpponent(this,positions[currentRow-1][currentCol+1]))
                availableMoves.add(new Spot(currentRow - 1, currentCol + 1));
            if (firstMove)
                availableMoves.add(new Spot(currentRow-2, currentCol));
        }
        else {
            if (currentRow + 1 <= 7 && !board.isOccupied(new Spot(currentRow+1, currentCol)))
                availableMoves.add(new Spot(currentRow + 1, currentCol));
            if (currentRow + 1 <= 7 && currentCol + 1 <= 7  && board.isOpponent(this,positions[currentRow+1][currentCol+1]))
                availableMoves.add(new Spot(currentRow + 1, currentCol + 1));
            if (currentRow + 1 <= 7 && currentCol - 1 >= 0  && board.isOpponent(this,positions[currentRow+1][currentCol-1]))
                availableMoves.add(new Spot(currentRow + 1, currentCol - 1));
            if (firstMove)
                availableMoves.add(new Spot(currentRow+2, currentCol));
        }
        return  availableMoves;
    }


    public void setValue() {
        value = 10;
    }

    @Override
    public String toString() {
        String temp;
        if(isWhite) temp = "w";
        else temp = "b";
        return temp+"P";
    }
}
