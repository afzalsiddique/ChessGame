import BackEndLogic.Board;
import BackEndLogic.Pawn;
import BackEndLogic.Piece;
import BackEndLogic.Spot;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

public class TestPawn {
    @Test
    public void test1(){
        Board board = new Board();
        Pawn piece1 = new Pawn(true, new Spot(6,2));
        board.addPiece(piece1);
        ArrayList<Spot> actual = piece1.calculateAllPossibleMoves();
        Collections.sort(actual);
        ArrayList<Spot> expected = new ArrayList<>(){
            {
                add(new Spot(5,2));
                add(new Spot(4,2));
            }
        };
        Collections.sort(expected);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void test2(){
        Board board = new Board();
        Pawn piece1 = new Pawn(true, new Spot(6,2));
        piece1.setFirstMove(false);
        board.addPiece(piece1);
        ArrayList<Spot> actual = piece1.calculateAllPossibleMoves();
        Collections.sort(actual);
        ArrayList<Spot> expected = new ArrayList<>(){
            {
                add(new Spot(5,2));
            }
        };
        Collections.sort(expected);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void test3(){
        Board board = new Board();
        Pawn piece1 = new Pawn(true, new Spot(6,1));
        board.addPiece(piece1);
        Pawn piece2 = new Pawn(false, new Spot(5,0));
        board.addPiece(piece2);
        ArrayList<Spot> actual = piece1.calculateAllPossibleMoves();
        Collections.sort(actual);
        ArrayList<Spot> expected = new ArrayList<>(){
            {
                add(new Spot(5,0));
                add(new Spot(5,1));
                add(new Spot(4,1));
            }
        };
        Collections.sort(expected);
//        for(int i = 0; i < actual.size(); i++) {
//            System.out.println(actual.get(i).row + " " + actual.get(i).col);
//        }
//        System.out.print("\n");
//        for(int i = 0; i < expected.size(); i++) {
//            System.out.println(expected.get(i).row + " " + expected.get(i).col);
//        }
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

}
