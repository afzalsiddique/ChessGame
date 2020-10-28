package Pieces;

public class Queen extends Piece {
    @Override
    public boolean makeMove(int[][] positions) {
        return false;
    }

    @Override
    public void calculateAvailableMoves() {
        availableMoves.add(new Spot(0,0));
    }

    String promotion() {
        return "";
    }

    Piece selectPiece() {
        return new Piece() {
            @Override
            public boolean makeMove(int[][] positions) {
                return false;
            }

            @Override
            public void calculateAvailableMoves() {
                availableMoves.add(new Spot(0,0));
            }
        };
    }
}
