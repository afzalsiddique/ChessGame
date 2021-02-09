package BackEndLogic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Pawn extends Piece {

    private boolean firstMove = true;

    private Spot prevSpot;

    private Pawn enPassantPawnOpponent;

    public Pawn(boolean isWhite, Spot spot){
        this.isWhite = isWhite;
        this.currentSpot = spot;
        ImportImage();
        setValue();
        setPrevSpot(currentSpot);
    }

    public Pawn(boolean isWhite, int x, int y){
        this.isWhite = isWhite;
        this.currentSpot = new Spot(x,y);
        ImportImage();
        setValue();
        setPrevSpot(currentSpot);
    }

    public Pawn(boolean isWhite, Spot spot, Boolean firstMove){
        this.isWhite = isWhite;
        this.currentSpot = spot;
        ImportImage();
        setValue();
        setFirstMove(firstMove);
        setPrevSpot(currentSpot);
    }

    public boolean isFirstMove(){
        return firstMove;
    }

    public void setFirstMove(boolean thisBoolean){
        firstMove = thisBoolean;
    }

    public void setPrevSpot(Spot prevSpot) {
        this.prevSpot = prevSpot;
    }

    public Spot getPrevSpot(){
        return prevSpot;
    }

    public boolean isEnPassantMove(){
        if(prevSpot.col == currentSpot.col)
            return false;
        if(isWhite) {
            if(board.getPiece(new Spot(currentSpot.row + 1, currentSpot.col)) instanceof Pawn) {
                Pawn pawnToCheck = (Pawn) board.getPiece(new Spot(currentSpot.row + 1, currentSpot.col));
                if(pawnToCheck.didPawnDoubleMove()){
                    enPassantPawnOpponent = pawnToCheck;
                    return true;
                }

            }
            return false;
        }

        else{
            if(board.getPiece(new Spot(currentSpot.row-1, currentSpot.col)) instanceof Pawn) {
                Pawn pawnToCheck = (Pawn) board.getPiece(new Spot(currentSpot.row + 1, currentSpot.col));
                if(pawnToCheck.didPawnDoubleMove()){
                    enPassantPawnOpponent = pawnToCheck;
                    return true;
                }
            }
            return false;
        }
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
        System.out.println("Check double move for Pawn on " + currentSpot);
        System.out.println("CurrentSpot=" + currentSpot);
        System.out.println("prevSpot=" + prevSpot);

        if(prevSpot.col == currentSpot.col && Math.abs(prevSpot.row - currentSpot.row) == 2){
            System.out.println("true");
            return true;
        }

        System.out.println("false");
        return false;
    }

    boolean isEnPassantAvailableOnLeft(){
        System.out.println("Checking left Pawn on " + currentSpot);

        Spot spotToCheck = new Spot(currentSpot.row, currentSpot.col-1);

        if(spotToCheck.row >= 8 || spotToCheck.row < 0 || spotToCheck.col >= 8 || spotToCheck.col < 0)
            return false;

        if(!board.isOccupied(spotToCheck)){
            System.out.println("1");
            return false;
        }


        if(!board.isOpponent(this, board.getPiece(spotToCheck)) || !(board.getPiece(spotToCheck) instanceof Pawn)){
            System.out.println("2");
            return false;
        }


        if(!((Pawn) board.getPiece(spotToCheck)).didPawnDoubleMove()){
            System.out.println("3");
            return false;
        }


        System.out.println("left");
        return true;
    }

    boolean isEnPassantAvailableOnRight(){
        System.out.println("Checking right Pawn on " + currentSpot);
        Spot spotToCheck = new Spot(currentSpot.row, currentSpot.col+1);

        if(spotToCheck.row >= 8 || spotToCheck.row < 0 || spotToCheck.col >= 8 || spotToCheck.col < 0)
            return false;

        if(!board.isOccupied(spotToCheck))
            return false;

        if(!board.isOpponent(this, board.getPiece(spotToCheck)) || !(board.getPiece(spotToCheck) instanceof Pawn))
            return false;

        if(!((Pawn) board.getPiece(spotToCheck)).didPawnDoubleMove())
            return false;

//        System.out.println("right");
        return true;
    }

    public void executeEnPassant(){
        board.removePiece(enPassantPawnOpponent.currentSpot);
    }

    @Override
    public ArrayList<Spot> calculateAllPossibleMovesWithoutModifying() {

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
