import BackEndLogic.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

public class TestAI_Agent {
    @Test
    public void test1(){
        Board board = new Board();
        Piece piece1 = new Pawn(true, new Spot(6,1));
        Piece piece2 = new Pawn(true, new Spot(6,2));
        board.addPiece(piece1);
        board.addPiece(piece2);
        AI_Agent ai_agent = new AI_Agent(board);
        ArrayList<Spot> actual = ai_agent.getAllAvailableMovesOfEveryPiece();
        Collections.sort(actual);

        ArrayList<Spot> expected = new ArrayList<>(){
            {
                add(new Spot(5,1));
                add(new Spot(5,2));
            }
        };
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void test2(){
        Board board = new Board();
        Piece piece1 = new Pawn(true, new Spot(6,1));
        Piece piece2 = new Pawn(true, new Spot(6,2));
        board.addPiece(piece1);
        board.addPiece(piece2);
        AI_Agent ai_agent = new AI_Agent(board);
        int actual = ai_agent.evaluate(board.positions);
        int expected = 20;
        Assert.assertEquals(expected, actual);
    }
}
