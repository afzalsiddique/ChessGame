package BackEndLogic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Rook extends Piece {

    private boolean firstMove = true;

    public Rook(boolean isWhite, Spot spot)
    {
        this.isWhite = isWhite;
        this.currentSpot = spot;
        ImportImage();
        setValue();
    }

    public void setFirstMove(boolean thisBoolean){
        firstMove = thisBoolean;
    }

    private void ImportImage(){
        try {
            if(isWhite){
                setImage(new ImageIcon(ImageIO.read(getClass().getResource("RookWhite.png"))));
            }
            else {
                setImage(new ImageIcon(ImageIO.read(getClass().getResource("RookBlack.png"))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Spot> calculateAllPossibleMovesWithoutModifying()
    {
        availableMoves.clear();
        if (getColor())
        {
            for (int row = currentSpot.row + 1; row < 8; row++)
            {
                if (board.positions[row][currentSpot.col] == null)
                    availableMoves.add(new Spot(row, currentSpot.col));
                else if (!board.positions[row][currentSpot.col].getColor()) {
                    availableMoves.add(new Spot(row, currentSpot.col));
                    break;
                }
                else break;
            }
            for (int row = currentSpot.row - 1; row >= 0; row--)
            {
                if (board.positions[row][currentSpot.col] == null)
                    availableMoves.add(new Spot(row, currentSpot.col));
                else if (!board.positions[row][currentSpot.col].getColor()) {
                    availableMoves.add(new Spot(row, currentSpot.col));
                    break;
                }
                else
                    break;
            }
            for (int col = currentSpot.col + 1; col < 8; col++)
            {
                if (board.positions[currentSpot.row][col] == null)
                    availableMoves.add(new Spot(currentSpot.row, col));
                else if (!board.positions[currentSpot.row][col].getColor()) {
                    availableMoves.add(new Spot(currentSpot.row, col));
                    break;
                }
                else
                    break;
            }
            for (int col = currentSpot.col - 1; col >= 0; col--)
            {
                if (board.positions[currentSpot.row][col] == null)
                    availableMoves.add(new Spot(currentSpot.row, col));
                else if (!board.positions[currentSpot.row][col].getColor()) {
                    availableMoves.add(new Spot(currentSpot.row, col));
                    break;
                }
                else
                    break;
            }
        }
        else {
            for (int row = currentSpot.row + 1; row < 8; row++)
            {
                if (board.positions[row][currentSpot.col] == null)
                    availableMoves.add(new Spot(row, currentSpot.col));
                else if (board.positions[row][currentSpot.col].getColor()) {
                    availableMoves.add(new Spot(row, currentSpot.col));
                    break;
                }
                else break;
            }
            for (int row = currentSpot.row - 1; row >= 0; row--)
            {
                if (board.positions[row][currentSpot.col] == null)
                    availableMoves.add(new Spot(row, currentSpot.col));
                else if (board.positions[row][currentSpot.col].getColor()) {
                    availableMoves.add(new Spot(row, currentSpot.col));
                    break;
                }
                else
                    break;
            }
            for (int col = currentSpot.col + 1; col < 8; col++)
            {
                if (board.positions[currentSpot.row][col] == null)
                    availableMoves.add(new Spot(currentSpot.row, col));
                else if (board.positions[currentSpot.row][col].getColor()) {
                    availableMoves.add(new Spot(currentSpot.row, col));
                    break;
                }
                else
                    break;
            }
            for (int col = currentSpot.col - 1; col >= 0; col--)
            {
                if (board.positions[currentSpot.row][col] == null)
                    availableMoves.add(new Spot(currentSpot.row, col));
                else if (board.positions[currentSpot.row][col].getColor()) {
                    availableMoves.add(new Spot(currentSpot.row, col));
                    break;
                }
                else
                    break;
            }
        }
        return  availableMoves;
    }

    public void castling()
    {

    }
    public void setValue(){
        this.value = 50;
    }
    @Override
    public String toString() {
        String temp;
        if(isWhite) temp = "w";
        else temp = "b";
        return temp+"R";
    }
}
