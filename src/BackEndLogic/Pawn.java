package BackEndLogic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Pawn extends Piece {

    private boolean firstMove = true;

    private Spot prevSpot;

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

    public Pawn(boolean isWhite, Spot spot, Boolean firstMove){
        this.isWhite = isWhite;
        this.currentSpot = spot;
        ImportImage();
        setValue();
        setFirstMove(firstMove);
    }

    public boolean isFirstMove(){
        return firstMove;
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

    boolean didPawnDoubleMove(){
        if(prevSpot.col == currentSpot.col && Math.abs(prevSpot.row - prevSpot.row) == 2)
            return true;
        else
            return false;
    }

    boolean isEnPassantAvailableOnLeft(){
        Spot spotToCheck = new Spot(currentSpot.row, currentSpot.col-1);
        if(!board.isOccupied(spotToCheck))
            return false;

        if(!board.isOpponent(this, board.getPiece(spotToCheck)) || !(board.getPiece(spotToCheck) instanceof Pawn))
            return false;

        if(((Pawn) board.getPiece(spotToCheck)).didPawnDoubleMove())
            return true;

        return false;
    }

    boolean isEnPassantAvailableOnRight(){
        Spot spotToCheck = new Spot(currentSpot.row, currentSpot.col+1);
        if(!board.isOccupied(spotToCheck))
            return false;

        if(!board.isOpponent(this, board.getPiece(spotToCheck)) || !(board.getPiece(spotToCheck) instanceof Pawn))
            return false;

        if(((Pawn) board.getPiece(spotToCheck)).didPawnDoubleMove())
            return true;

        return false;
    }

    @Override
    public ArrayList<Spot> calculateAllPossibleMovesWithoutModifying() {
        prevSpot = currentSpot;

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
            if (firstMove && !board.isOccupied(currentRow-2, currentCol))
                availableMoves.add(new Spot(currentRow-2, currentCol));
            if(isEnPassantAvailableOnLeft())
                availableMoves.add(new Spot(currentRow-1, currentCol-1));
            if(isEnPassantAvailableOnRight())
                availableMoves.add(new Spot(currentRow-1, currentCol+1));

        }
        else {
            if (currentRow + 1 <= 7 && !board.isOccupied(new Spot(currentRow+1, currentCol)))
                availableMoves.add(new Spot(currentRow + 1, currentCol));
            if (currentRow + 1 <= 7 && currentCol + 1 <= 7  && board.isOpponent(this,positions[currentRow+1][currentCol+1]))
                availableMoves.add(new Spot(currentRow + 1, currentCol + 1));
            if (currentRow + 1 <= 7 && currentCol - 1 >= 0  && board.isOpponent(this,positions[currentRow+1][currentCol-1]))
                availableMoves.add(new Spot(currentRow + 1, currentCol - 1));
            if (firstMove && !board.isOccupied(currentRow+2, currentCol))
                availableMoves.add(new Spot(currentRow+2, currentCol));
            if(isEnPassantAvailableOnLeft())
                availableMoves.add(new Spot(currentRow+1, currentCol-1));
            if(isEnPassantAvailableOnRight())
                availableMoves.add(new Spot(currentRow+1, currentCol+1));
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
