import BackEndLogic.*;
import org.junit.jupiter.api.Test;

public class HistoryTest {
    Game game = new Game();
    Board currentBoard = game.getBackEndBoard();
    History moveHistory = new History();

    @Test
    public void Test1(){
        System.out.println("Adding a Move");
        moveHistory.addRecord(currentBoard);
        moveHistory.getLastRecord();

        System.out.println("Adding a Move");
        currentBoard.addPiece(new Pawn(false, new Spot(0,7)));
        moveHistory.addRecord(currentBoard);
        moveHistory.getLastRecord();

        System.out.println("Removing a move");
        moveHistory.removeLastRecord();
        moveHistory.getLastRecord();

        System.out.println("Adding a move");
        currentBoard.addPiece(new Rook(true, new Spot(5,4)));
        moveHistory.addRecord(currentBoard);
        moveHistory.getLastRecord();
    }
}
