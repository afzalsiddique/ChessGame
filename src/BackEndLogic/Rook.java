package BackEndLogic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Rook extends Piece
{
    public Rook(boolean isWhite, Spot spot)
    {
        this.isWhite = isWhite;
        this.spot = spot;
        ImportImage();
        setValue();
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
    public ArrayList<Spot> calculateAllPossibleMoves()
    {
        availableMoves.clear();
        if (getColor())
        {
            for (int row = spot.row + 1; row < 8; row++)
            {
                if (board.positions[row][spot.col] == null)
                    availableMoves.add(new Spot(row, spot.col));
                else if (!board.positions[row][spot.col].getColor()) {
                    availableMoves.add(new Spot(row, spot.col));
                    break;
                }
                else break;
            }
            for (int row = spot.row - 1; row >= 0; row--)
            {
                if (board.positions[row][spot.col] == null)
                    availableMoves.add(new Spot(row, spot.col));
                else if (!board.positions[row][spot.col].getColor()) {
                    availableMoves.add(new Spot(row, spot.col));
                    break;
                }
                else
                    break;
            }
            for (int col = spot.col + 1; col < 8; col++)
            {
                if (board.positions[spot.row][col] == null)
                    availableMoves.add(new Spot(spot.row, col));
                else if (!board.positions[spot.row][col].getColor()) {
                    availableMoves.add(new Spot(spot.row, col));
                    break;
                }
                else
                    break;
            }
            for (int col = spot.col - 1; col >= 0; col--)
            {
                if (board.positions[spot.row][col] == null)
                    availableMoves.add(new Spot(spot.row, col));
                else if (!board.positions[spot.row][col].getColor()) {
                    availableMoves.add(new Spot(spot.row, col));
                    break;
                }
                else
                    break;
            }
        }
        else {
            for (int row = spot.row + 1; row < 8; row++)
            {
                if (board.positions[row][spot.col] == null)
                    availableMoves.add(new Spot(row, spot.col));
                else if (board.positions[row][spot.col].getColor()) {
                    availableMoves.add(new Spot(row, spot.col));
                    break;
                }
                else break;
            }
            for (int row = spot.row - 1; row >= 0; row--)
            {
                if (board.positions[row][spot.col] == null)
                    availableMoves.add(new Spot(row, spot.col));
                else if (board.positions[row][spot.col].getColor()) {
                    availableMoves.add(new Spot(row, spot.col));
                    break;
                }
                else
                    break;
            }
            for (int col = spot.col + 1; col < 8; col++)
            {
                if (board.positions[spot.row][col] == null)
                    availableMoves.add(new Spot(spot.row, col));
                else if (board.positions[spot.row][col].getColor()) {
                    availableMoves.add(new Spot(spot.row, col));
                    break;
                }
                else
                    break;
            }
            for (int col = spot.col - 1; col >= 0; col--)
            {
                if (board.positions[spot.row][col] == null)
                    availableMoves.add(new Spot(spot.row, col));
                else if (board.positions[spot.row][col].getColor()) {
                    availableMoves.add(new Spot(spot.row, col));
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
    void setValue(){
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
