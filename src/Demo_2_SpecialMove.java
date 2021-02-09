import BackEndLogic.*;
import UserInterface.BoardGUI;
import UserInterface.DisplayWindow;

public class Demo_2_SpecialMove {
    public static void main(String[] args) {
        Board board = new Board();
        Piece bRook1 = new Rook(false, new Spot(0,0));
        Piece wRook1 = new Rook(true, new Spot(7,7));
        Piece wPawn1 = new Pawn(true, new Spot(6,1));
        Piece bPawn1 = new Pawn(false, new Spot(1,2));
        Piece wKing = new King(true, new Spot(7,4));
        Piece bKing = new King(false, new Spot(0,4));

        board.addPiece(wRook1);
        board.addPiece(bRook1);
        board.addPiece(wPawn1);
        board.addPiece(bPawn1);
        board.addPiece(wKing);
        board.addPiece(bKing);


        Game actualGame = new Game();
        actualGame.setBackEndBoard(board);
        BoardGUI gui = new BoardGUI(actualGame);
        gui.updateGUI();

        DisplayWindow displayWindow = new DisplayWindow();
        displayWindow.addPanel(gui);
    }
}
