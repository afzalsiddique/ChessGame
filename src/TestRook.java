import BackEndLogic.Board;
import BackEndLogic.Piece;
import BackEndLogic.Rook;
import BackEndLogic.Spot;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

public class TestRook {
    @Test
    public void test1(){
        Board board = new Board();
        Piece piece1 = new Rook(true, new Spot(4,4));
        board.addPiece(piece1);
        Piece piece2 = new Rook(false, new Spot(4,5));
        Piece piece3 = new Rook(false, new Spot(4,2));
        Piece piece4 = new Rook(false, new Spot(3,4));
        Piece piece5 = new Rook(false, new Spot(5,4));
        board.addPiece(piece2);
        board.addPiece(piece3);
        board.addPiece(piece4);
        board.addPiece(piece5);
        ArrayList<Spot> actual = piece1.calculateAllPossibleMoves(board);
        Collections.sort(actual);
        ArrayList<Spot> expected = new ArrayList<>(){
            {
                new Spot(4,5);
                new Spot(4,2);
                new Spot(3,4);
                new Spot(5,4);
                new Spot(4,3);
            }
        };
        Collections.sort(expected);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
