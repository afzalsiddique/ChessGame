package Pieces;

public class Rook extends Piece {

    @Override
    public boolean makeMove(int[][] positions) {
        return false;
    }

    @Override
    public String[] checkAvailableMoves() {
        return new String[0];
    }
    public void castling(){

    }
}
