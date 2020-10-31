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
        Assert.assertArrayEquals(actual.toArray(),expected.toArray());
    }
    @Test
    public void test2(){
        Assert.assertEquals(true, true);
    }
}
