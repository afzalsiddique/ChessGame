package BackEndLogic;

import java.util.ArrayList;

public class Rook extends Piece
{
    public Rook(boolean isWhite, Spot spot)
    {
        this.isWhite = isWhite;
        this.spot = spot;
    }
    @Override
    public boolean makeMove(Piece[][] positions)
    {
        return super.makeMove(positions);
    }

    @Override
    public ArrayList<Spot> calculateAllPossibleMoves(Board board)
    {
        availableMoves.clear();
        if (isWhite)
        {
            for (int row = spot.row + 1; row < 8; row++)
            {
                if (board.positions[row][spot.col] != null) //Enemy piece not implemented
                    availableMoves.add(new Spot(row, spot.col));
                else if (!board.positions[row][spot.col].isWhite)
                    availableMoves.add(new Spot(row, spot.col));
                else
                    break;
            }
            for (int row = spot.row - 1; row >= 0; row--)
            {
                if (board.positions[row][spot.col] != null)
                    availableMoves.add(new Spot(row, spot.col));
                else if (!board.positions[row][spot.col].isWhite)
                    availableMoves.add(new Spot(row, spot.col));
                else
                    break;
            }
            for (int col = spot.col + 1; col < 8; col++)
            {
                if (board.positions[spot.row][col] != null)
                    availableMoves.add(new Spot(spot.row, col));
                else if (!board.positions[spot.row][col].isWhite)
                    availableMoves.add(new Spot(spot.row, col));
                else
                    break;
            }
            for (int col = spot.col - 1; col >= 0; col--)
            {
                if (board.positions[spot.row][col] != null)
                    availableMoves.add(new Spot(spot.row, col));
                else if (!board.positions[spot.row][col].isWhite)
                    availableMoves.add(new Spot(spot.row, col));
                else
                    break;
            }
        }
        return  availableMoves;
    }


    public void castling()
    {

    }
}
