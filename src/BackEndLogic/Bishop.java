package BackEndLogic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Bishop extends Piece
{
    public Bishop(boolean isWhite, Spot spot)
    {
        this.isWhite = isWhite;
        this.currentSpot = spot;
        ImportImage();
        setValue();
    }

    private void ImportImage(){
        try {
            if(isWhite){
                setImage(new ImageIcon(ImageIO.read(getClass().getResource("BishopWhite.png"))));
            }
            else {
                setImage(new ImageIcon(ImageIO.read(getClass().getResource("BishopBlack.png"))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Spot> calculateAllPossibleMovesWithoutModifying(){
        availableMoves.clear();
        if (getColor())
        {
            for (int row = currentSpot.row + 1,col = currentSpot.col + 1; row < 8 && col < 8; row++, col++)
            {
                if (board.positions[row][col] == null)
                    availableMoves.add(new Spot(row, col));
                else if (!board.positions[row][col].getColor()) {
                    availableMoves.add(new Spot(row,col));
                    break;
                }
                else break;
            }
            for (int row = currentSpot.row - 1,col = currentSpot.col - 1; row >= 0 && col >= 0; row--, col--)
            {
                if (board.positions[row][col] == null)
                    availableMoves.add(new Spot(row,col));
                else if (!board.positions[row][col].getColor()) {
                    availableMoves.add(new Spot(row, col));
                    break;
                }
                else
                    break;
            }
            for (int row = currentSpot.row + 1,col = currentSpot.col - 1; col >= 0 && row < 8; row++, col--)
            {
                if (board.positions[row][col] == null)
                    availableMoves.add(new Spot(row, col));
                else if (!board.positions[row][col].getColor()) {
                    availableMoves.add(new Spot(row, col));
                    break;
                }
                else
                    break;
            }
            for (int row = currentSpot.row - 1,col = currentSpot.col + 1; col < 8 && row >= 0; row--, col++)
            {
                if (board.positions[row][col] == null)
                    availableMoves.add(new Spot(row, col));
                else if (!board.positions[row][col].getColor()) {
                    availableMoves.add(new Spot(row, col));
                    break;
                }
                else
                    break;
            }
        }
        else
        {
            for (int row = currentSpot.row + 1,col = currentSpot.col + 1; row < 8 && col < 8; row++, col++)
            {
                if (board.positions[row][col] == null)
                    availableMoves.add(new Spot(row, col));
                else if (board.positions[row][col].getColor()) {
                    availableMoves.add(new Spot(row,col));
                    break;
                }
                else break;
            }
            for (int row = currentSpot.row - 1,col = currentSpot.col - 1; row >= 0 && col >= 0; row--, col--)
            {
                if (board.positions[row][col] == null)
                    availableMoves.add(new Spot(row,col));
                else if (board.positions[row][col].getColor()) {
                    availableMoves.add(new Spot(row, col));
                    break;
                }
                else
                    break;
            }
            for (int row = currentSpot.row + 1,col = currentSpot.col - 1; col >= 0 && row < 8; row++, col--)
            {
                if (board.positions[row][col] == null)
                    availableMoves.add(new Spot(row, col));
                else if (board.positions[row][col].getColor()) {
                    availableMoves.add(new Spot(row, col));
                    break;
                }
                else
                    break;
            }
            for (int row = currentSpot.row - 1,col = currentSpot.col + 1; col < 8 && row >= 0; row--, col++)
            {
                if (board.positions[row][col] == null)
                    availableMoves.add(new Spot(row, col));
                else if (board.positions[row][col].getColor()) {
                    availableMoves.add(new Spot(row, col));
                    break;
                }
                else
                    break;
            }
        }
        return  availableMoves;
    }

    public void setValue(){
        this.value = 30;
    }

    @Override
    public String toString() {
        String temp;
        if(isWhite) temp = " w";
        else temp = " b";
        return temp+"B ";
    }

}
