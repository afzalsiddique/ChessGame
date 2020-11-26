package BackEndLogic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Pawn extends Piece {
    public Pawn(boolean isWhite, Spot spot){
        this.isWhite = isWhite;
        this.spot = spot;
        ImportImage();
    }

    public Pawn(boolean isWhite, int x, int y){
        this.isWhite = isWhite;
        this.spot = new Spot(x,y);
        ImportImage();
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
        int row = spot.row;
        int col = spot.col;
        if(isWhite) {
            if (row - 1 >= 0 && !board.isOccupied(new Spot(row-1, col)))
                availableMoves.add(new Spot(row - 1, col));
            if (row - 1 >= 0 && col - 1 >= 0  && board.isOpponent(this,positions[row-1][col-1]))
                availableMoves.add(new Spot(row - 1, col - 1));
            if (row - 1 >= 0 && col + 1 <= 7  && board.isOpponent(this,positions[row-1][col+1]))
                availableMoves.add(new Spot(row - 1, col + 1));
        }
        else {
            if (row + 1 <= 7 && !board.isOccupied(new Spot(row+1, col)))
                availableMoves.add(new Spot(row + 1, col));
            if (row + 1 <= 7 && col + 1 <= 7  && board.isOpponent(this,positions[row+1][col+1]))
                availableMoves.add(new Spot(row + 1, col + 1));
            if (row + 1 <= 7 && col - 1 >= 0  && board.isOpponent(this,positions[row+1][col-1]))
                availableMoves.add(new Spot(row + 1, col - 1));
        }
        return  availableMoves;
    }
    void setValue(){
        this.value = 10;
    }
}
