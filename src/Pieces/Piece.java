package Pieces;

public interface Piece {
    boolean makeMove(int[][] positions);
    String[] checkAvailableMoves();
}
