import BackEndLogic.*;
import UserInterface.*;

public class TestGUI1 {

    public static void main(String[] args) {
        Board board = new Board();
        GUI gui = new GUI(board);

        board.addPiece(new Pawn(true, new Spot(6,0)));
        board.addPiece(new Rook(true, new Spot(5,0)));
        board.addPiece(new Rook(false, new Spot(4,6)));
        board.addPiece(new King(true, new Spot(6,6)));

        gui.updateGUI();
    }
}
