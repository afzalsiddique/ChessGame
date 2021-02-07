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

        System.out.println("Adding a Move on 0,7");
        currentBoard.addPiece(new Pawn(false, new Spot(0,7)));



        moveHistory.addRecord(currentBoard);
        moveHistory.printEntireHistory();

        System.out.println("Removing a move");
        moveHistory.removeLastRecord();
        moveHistory.printEntireHistory();
        currentBoard = moveHistory.getLastRecord();

        System.out.println("Adding a move on 5,4");
        currentBoard.addPiece(new Rook(true, new Spot(5,4)));
        moveHistory.addRecord(currentBoard);

        moveHistory.printEntireHistory();

        System.out.println("Adding a move on 2,2");
        currentBoard.addPiece(new Rook(true, new Spot(2,2)));
        moveHistory.addRecord(currentBoard);

        moveHistory.printEntireHistory();

    }
}
