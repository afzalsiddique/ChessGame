import BackEndLogic.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestAI_Agent {
    @Test
    public void test1(){
        Board board = new Board();
        Piece piece1 = new Pawn(true, new Spot(6,1));
        Piece piece2 = new Pawn(true, new Spot(6,2));
        board.addPiece(piece1);
        board.addPiece(piece2);
        AI_Agent ai_agent = new AI_Agent(board);
        int actual = ai_agent.evaluate(board);
        int expected = 20;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2(){
        Board board = new Board();
//        Piece piece1 = new Pawn(true, new Spot(7,0));
        Piece piece3 = new Pawn(true, new Spot(7,1));
        Piece piece2 = new Pawn(false, new Spot(0,0));
//        board.addPiece(piece1);
        board.addPiece(piece2);
        board.addPiece(piece3);
        AI_Agent ai_agent = new AI_Agent(board);
        int actual = ai_agent.minimax(board,2, false);
        int expected = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test3(){
        Board board = new Board();
        Piece piece1 = new Pawn(true, new Spot(7,0));
        Piece piece2 = new Pawn(true, new Spot(7,1));
        Piece piece3 = new Pawn(false, new Spot(0,0));
        board.addPiece(piece1);
        board.addPiece(piece2);
        board.addPiece(piece3);
        AI_Agent ai_agent = new AI_Agent(board);
        int actual = ai_agent.minimax(board,2, false);
        int expected = 10;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test4(){
        Board board = new Board();
        Piece piece1 = new Pawn(false, new Spot(0,0));
        Piece piece2 = new Pawn(false, new Spot(0,1));
        Piece piece3 = new Pawn(true, new Spot(7,0));
        Piece piece4 = new Rook(true, new Spot(7,1));
        board.addPiece(piece1);
        board.addPiece(piece2);
        board.addPiece(piece3);
        board.addPiece(piece4);
        AI_Agent ai_agent = new AI_Agent(board);
        int actual = ai_agent.minimax(board,2, false);
        int expected = 50;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test5(){
        Board board = new Board();
        Piece piece1 = new Pawn(false, new Spot(0,2));
        Piece piece2 = new Pawn(false, new Spot(0,3));
        Piece piece3 = new Pawn(true, new Spot(1,2));
        Piece piece4 = new Pawn(true, new Spot(1,5));
        board.addPiece(piece1);
        board.addPiece(piece2);
        board.addPiece(piece3);
        board.addPiece(piece4);
        AI_Agent ai_agent = new AI_Agent(board);
        Spot actual = ai_agent.findBestMove(board);
        Spot expected = new Spot(0,3); // this is actually returning which spot has the best move
        Assert.assertEquals(expected, actual);
    }
}
