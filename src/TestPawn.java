import Pieces.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

public class TestPawn {
    @Test
    public void test1(){
        Board board = new Board();
        Piece piece1 = new Pawn(true, new Spot(6,1));
        board.addPiece(piece1);
        ArrayList<Spot> actual = piece1.calculateAllPossibleMoves(board.positions);
        Collections.sort(actual);
        ArrayList<Spot> expected = new ArrayList<>(){
            {
                add(new Spot(5,1));
            }
        };
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
    @Test
    public void test3(){
        Board board = new Board();
        Piece piece1 = new Pawn(true, new Spot(6,1));
        board.addPiece(piece1);
        Piece piece2 = new Pawn(false, new Spot(5,0));
        board.addPiece(piece2);
        ArrayList<Spot> actual = piece1.calculateAllPossibleMoves(board.positions);
        Collections.sort(actual);
        ArrayList<Spot> expected = new ArrayList<>(){
            {
                add(new Spot(5,0));
            }
        };
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
