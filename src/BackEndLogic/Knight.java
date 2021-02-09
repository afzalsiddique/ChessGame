package BackEndLogic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(boolean isWhite, Spot spot)
    {
        this.isWhite = isWhite;
        this.currentSpot = spot;
        ImportImage();
        setValue();
    }

    private void ImportImage(){
        try {
            if(isWhite){
                setImage(new ImageIcon(ImageIO.read(getClass().getResource("KnightWhite.png"))));
            }
            else {
                setImage(new ImageIcon(ImageIO.read(getClass().getResource("KnightBlack.png"))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Spot> calculateAllPossibleMovesWithoutModifying() {
        availableMoves.clear();
        if (getColor())
        {
            if (currentSpot.row < 7 && currentSpot.col < 6)
            {
                if (board.positions[currentSpot.row + 1][currentSpot.col + 2] == null)
                    availableMoves.add(new Spot(currentSpot.row + 1, currentSpot.col + 2));
                else if (!board.positions[currentSpot.row + 1][currentSpot.col + 2].getColor())
                {
                    availableMoves.add(new Spot(currentSpot.row + 1, currentSpot.col + 2));
                }
            }
            if(currentSpot.row < 7 && currentSpot.col > 1)
            {
                if (board.positions[currentSpot.row + 1][currentSpot.col - 2] == null)
                    availableMoves.add(new Spot(currentSpot.row + 1, currentSpot.col - 2));
                else if (!board.positions[currentSpot.row + 1][currentSpot.col - 2].getColor())
                {
                    availableMoves.add(new Spot(currentSpot.row + 1, currentSpot.col - 2));
                }
            }
            if (currentSpot.row < 6 && currentSpot.col > 0)
            {
                if (board.positions[currentSpot.row + 2][currentSpot.col - 1] == null)
                    availableMoves.add(new Spot(currentSpot.row + 2, currentSpot.col - 1));
                else if (!board.positions[currentSpot.row + 2][currentSpot.col - 1].getColor())
                {
                    availableMoves.add(new Spot(currentSpot.row + 2, currentSpot.col - 1));
                }
            }
            if(currentSpot.row < 6 && currentSpot.col < 7)
            {
                if (board.positions[currentSpot.row + 2][currentSpot.col + 1] == null)
                    availableMoves.add(new Spot(currentSpot.row + 2, currentSpot.col + 1));
                else if (!board.positions[currentSpot.row + 2][currentSpot.col + 1].getColor())
                {
                    availableMoves.add(new Spot(currentSpot.row + 2, currentSpot.col + 1));
                }
            }
            if (currentSpot.row > 0 && currentSpot.col > 1)
            {
                if (board.positions[currentSpot.row - 1][currentSpot.col - 2] == null)
                    availableMoves.add(new Spot(currentSpot.row - 1, currentSpot.col - 2));
                else if (!board.positions[currentSpot.row - 1][currentSpot.col - 2].getColor())
                {
                    availableMoves.add(new Spot(currentSpot.row - 1, currentSpot.col - 2));
                }
            }
            if(currentSpot.row > 1 && currentSpot.col > 0)
            {
                if (board.positions[currentSpot.row - 2][currentSpot.col - 1] == null)
                    availableMoves.add(new Spot(currentSpot.row - 2, currentSpot.col - 1));
                else if (!board.positions[currentSpot.row - 2][currentSpot.col - 1].getColor())
                {
                    availableMoves.add(new Spot(currentSpot.row - 2, currentSpot.col - 1));
                }
            }
            if (currentSpot.row > 1 && currentSpot.col < 7)
            {
                if (board.positions[currentSpot.row - 2][currentSpot.col + 1] == null)
                    availableMoves.add(new Spot(currentSpot.row - 2, currentSpot.col + 1));
                else if (!board.positions[currentSpot.row - 2][currentSpot.col + 1].getColor())
                {
                    availableMoves.add(new Spot(currentSpot.row - 2, currentSpot.col + 1));
                }
            }
            if(currentSpot.row > 0 && currentSpot.col < 6)
            {
                if (board.positions[currentSpot.row - 1][currentSpot.col + 2] == null)
                    availableMoves.add(new Spot(currentSpot.row - 1, currentSpot.col + 2));
                else if (!board.positions[currentSpot.row - 1][currentSpot.col + 2].getColor())
                {
                    availableMoves.add(new Spot(currentSpot.row - 1, currentSpot.col + 2));
                }
            }
        }
        else
        {
            if (currentSpot.row < 7 && currentSpot.col < 6)
            {
                if (board.positions[currentSpot.row + 1][currentSpot.col + 2] == null)
                    availableMoves.add(new Spot(currentSpot.row + 1, currentSpot.col + 2));
                else if (board.positions[currentSpot.row + 1][currentSpot.col + 2].getColor())
                {
                    availableMoves.add(new Spot(currentSpot.row + 1, currentSpot.col + 2));
                }
            }
            if(currentSpot.row < 7 && currentSpot.col > 1)
            {
                if (board.positions[currentSpot.row + 1][currentSpot.col - 2] == null)
                    availableMoves.add(new Spot(currentSpot.row + 1, currentSpot.col - 2));
                else if (board.positions[currentSpot.row + 1][currentSpot.col - 2].getColor())
                {
                    availableMoves.add(new Spot(currentSpot.row + 1, currentSpot.col - 2));
                }
            }
            if (currentSpot.row < 6 && currentSpot.col > 0)
            {
                if (board.positions[currentSpot.row + 2][currentSpot.col - 1] == null)
                    availableMoves.add(new Spot(currentSpot.row + 2, currentSpot.col - 1));
                else if (board.positions[currentSpot.row + 2][currentSpot.col - 1].getColor())
                {
                    availableMoves.add(new Spot(currentSpot.row + 2, currentSpot.col - 1));
                }
            }
            if(currentSpot.row < 6 && currentSpot.col < 7)
            {
                if (board.positions[currentSpot.row + 2][currentSpot.col + 1] == null)
                    availableMoves.add(new Spot(currentSpot.row + 2, currentSpot.col + 1));
                else if (board.positions[currentSpot.row + 2][currentSpot.col + 1].getColor())
                {
                    availableMoves.add(new Spot(currentSpot.row + 2, currentSpot.col + 1));
                }
            }
            if (currentSpot.row > 0 && currentSpot.col > 1)
            {
                if (board.positions[currentSpot.row - 1][currentSpot.col - 2] == null)
                    availableMoves.add(new Spot(currentSpot.row - 1, currentSpot.col - 2));
                else if (board.positions[currentSpot.row - 1][currentSpot.col - 2].getColor())
                {
                    availableMoves.add(new Spot(currentSpot.row - 1, currentSpot.col - 2));
                }
            }
            if(currentSpot.row > 1 && currentSpot.col > 0)
            {
                if (board.positions[currentSpot.row - 2][currentSpot.col - 1] == null)
                    availableMoves.add(new Spot(currentSpot.row - 2, currentSpot.col - 1));
                else if (board.positions[currentSpot.row - 2][currentSpot.col - 1].getColor())
                {
                    availableMoves.add(new Spot(currentSpot.row - 2, currentSpot.col - 1));
                }
            }
            if (currentSpot.row > 1 && currentSpot.col < 7)
            {
                if (board.positions[currentSpot.row - 2][currentSpot.col + 1] == null)
                    availableMoves.add(new Spot(currentSpot.row - 2, currentSpot.col + 1));
                else if (board.positions[currentSpot.row - 2][currentSpot.col + 1].getColor())
                {
                    availableMoves.add(new Spot(currentSpot.row - 2, currentSpot.col + 1));
                }
            }
            if(currentSpot.row > 0 && currentSpot.col < 6)
            {
                if (board.positions[currentSpot.row - 1][currentSpot.col + 2] == null)
                    availableMoves.add(new Spot(currentSpot.row - 1, currentSpot.col + 2));
                else if (board.positions[currentSpot.row - 1][currentSpot.col + 2].getColor())
                {
                    availableMoves.add(new Spot(currentSpot.row - 1, currentSpot.col + 2));
                }
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
        return temp+"K ";
    }

}
