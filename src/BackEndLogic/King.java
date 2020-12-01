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
        value = 900;
    }

    @Override
    public String toString() {
        return null;
    }

    ArrayList<Spot> getThisPiecesMoves(Piece somePiece){
        return somePiece.calculateAllPossibleMoves();
    }

    ArrayList<Spot> RemoveCommonElements(ArrayList<Spot> kingMoves, ArrayList<Spot> pieceMoves){
        ArrayList<Spot> finalMoves = new ArrayList<>();
        ArrayList<Spot> commonMoves = new ArrayList<>();
        finalMoves.clear();
        for(int i=0; i<kingMoves.size(); i++){
            for(int j=0; j<pieceMoves.size(); j++){
                if(kingMoves.get(i).equals(pieceMoves.get(j)))
                    commonMoves.add(kingMoves.get(i));
            }
        }

        for(int i=0; i<kingMoves.size(); i++){
            if(!commonMoves.contains(kingMoves.get(i)))
                finalMoves.add(kingMoves.get(i));
        }

        return finalMoves;
    }

    @Override
    public ArrayList<Spot> calculateAllPossibleMovesWithoutModifying() {
        availableMoves.clear();
        int thisRow = currentSpot.row;
        int thisCol = currentSpot.col;
        if(thisRow + 1 <= 7 && (board.isOpponent(this, board.getPiece(thisRow+1, thisCol)) || !board.isOccupied(thisRow+1, thisCol)))
            availableMoves.add(new Spot(thisRow+1, thisCol));
        if(thisRow - 1 >= 0 && (board.isOpponent(this, board.getPiece(thisRow-1, thisCol)) || !board.isOccupied(thisRow-1, thisCol)))
            availableMoves.add(new Spot(thisRow-1, thisCol));
        if(thisCol + 1 <= 7 && (board.isOpponent(this, board.getPiece(thisRow, thisCol+1)) || !board.isOccupied(thisRow, thisCol+1)))
            availableMoves.add(new Spot(thisRow, thisCol+1));
        if(thisCol - 1 >= 0 && (board.isOpponent(this, board.getPiece(thisRow, thisCol-1)) || !board.isOccupied(thisRow, thisCol-1)))
            availableMoves.add(new Spot(thisRow, thisCol-1));

        if(thisRow + 1 <= 7 && thisCol + 1 <= 7 && (board.isOpponent(this, board.getPiece(thisRow+1, thisCol+1)) || !board.isOccupied(thisRow+1, thisCol+1)))
            availableMoves.add(new Spot(thisRow+1, thisCol+1));
        if(thisRow + 1 <= 7 && thisCol - 1 >= 0 && (board.isOpponent(this, board.getPiece(thisRow+1, thisCol-1)) || !board.isOccupied(thisRow+1, thisCol-1)))
            availableMoves.add(new Spot(thisRow+1, thisCol-1));
        if(thisRow - 1 >= 0 && thisCol + 1 <= 7 && (board.isOpponent(this, board.getPiece(thisRow-1, thisCol+1)) || !board.isOccupied(thisRow-1, thisCol+1)))
            availableMoves.add(new Spot(thisRow-1, thisCol+1));
        if(thisRow - 1 >= 0 && thisCol - 1 >= 0 && (board.isOpponent(this, board.getPiece(thisRow-1, thisCol-1)) || !board.isOccupied(thisRow-1, thisCol-1)))
            availableMoves.add(new Spot(thisRow-1, thisCol-1));

        return  availableMoves;
    }

    @Override
    public ArrayList<Spot> calculateAllPossibleMoves() {

        calculateAllPossibleMovesWithoutModifying();

        this.availableMoves = board.modifyAvailableMoves(availableMoves, currentSpot, isWhite);

        return  availableMoves;
    }

    public void castling(){

    }
}
