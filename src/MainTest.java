import BackEndLogic.*;
import UserInterface.GUI;

public class MainTest {
    public static void main(String[] args) {
//        GUI gui = new GUI();
       Board board = new Board();
       Piece pawn1 = new Pawn(true, 6,0);

       board.addPiece(pawn1);

       GUI gui = new GUI(board);
       gui.updateGUI();
    }
}
