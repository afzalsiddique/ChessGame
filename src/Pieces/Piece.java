package Pieces;

import javax.swing.*;

public interface Piece {
    boolean makeMove(int[][] positions);
    String[] checkAvailableMoves();
}
