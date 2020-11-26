import BackEndLogic.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestAI_Agent {
    @Test
    public void test2(){
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
}
