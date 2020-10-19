package Pieces;

public abstract class Piece {
    public boolean makeMove(int[][] positions) {
        return false;
    }
    public String[] checkAvailableMoves() {
        return new String[0];
    }

    public void castling(){

    }
}