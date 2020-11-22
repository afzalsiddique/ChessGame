import BackEndLogic.*;
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
        ArrayList<Spot> actual = piece1.calculateAllPossibleMoves();
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
        ArrayList<Spot> actual = piece1.calculateAllPossibleMoves();
        Collections.sort(actual);
        ArrayList<Spot> expected = new ArrayList<>(){
            {
                add(new Spot(5,0));
                add(new Spot(5,1));
            }
        };
        Collections.sort(expected);
        for(int i = 0; i < actual.size(); i++) {
            System.out.println(actual.get(i).row + " " + actual.get(i).col);
        }
        System.out.print("\n");
        for(int i = 0; i < expected.size(); i++) {
            System.out.println(expected.get(i).row + " " + expected.get(i).col);
        }
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
