import BackEndLogic.*;
import UserInterface.GUI;

public class MainTest {
    public static void main(String[] args) {
//        GUI gui = new GUI();
       Board board = new Board();
       Piece pawn1 = new Pawn(true, 6,0);
       Piece pawn2 = new Pawn(false, 1,1);
       Piece rook1 = new Rook(true, new Spot(7,0));
       Piece rook2 = new Rook(false, new Spot(4,4));
       Piece bishop1 = new Bishop(true, new Spot(0,0));
       Piece bishop2 = new Bishop(false, new Spot(0,7));

       board.addPiece(pawn1);
       board.addPiece(pawn2);
       board.addPiece(rook1);
       board.addPiece(rook2);
       board.addPiece(bishop1);
       board.addPiece(bishop2);

       board.addPiece(new King(true, new Spot(3,5)));

       GUI gui = new GUI(board);
       gui.updateGUI();
    }
}
