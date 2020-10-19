package Pieces;

public class Queen extends Piece {
    @Override
    public boolean makeMove(int[][] positions) {
        return false;
    }

    @Override
    public String[] checkAvailableMoves() {
        return new String[0];
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
            public String[] checkAvailableMoves() {
                return new String[0];
            }
        };
    }
}
