import BackEndLogic.*;
import UserInterface.BoardGUI;
import UserInterface.DisplayWindow;

public class MainTest {
    public static void main(String[] args) {
//        GUI gui = new GUI();
       Board board = new Board();

       board.addPiece(new Rook(true, new Spot(7,0)));
       board.addPiece(new Rook(true, new Spot(7,7)));
       board.addPiece(new Rook(false, new Spot(0,0)));
       board.addPiece(new Rook(false, new Spot(0,7)));
       board.addPiece(new Bishop(true, new Spot(7,2)));
       board.addPiece(new Bishop(true, new Spot(7,5)));
       board.addPiece(new Bishop(false, new Spot(0,2)));
       board.addPiece(new Bishop(false, new Spot(0,5)));
       board.addPiece(new Queen(true, new Spot(7,3)));
       board.addPiece(new Queen(false, new Spot(0,3)));
       board.addPiece(new King(true, new Spot(7,4)));
       board.addPiece(new King(false, new Spot(0,4)));
       board.addPiece(new Knight(true, new Spot(7,1)));
       board.addPiece(new Knight(true, new Spot(7,6)));
       board.addPiece(new Knight(false, new Spot(0,1)));
       board.addPiece(new Knight(false, new Spot(0,6)));

       for (int i = 0; i < 8;i++)
       {
          board.addPiece(new Pawn(true, new Spot(6,i)));
          board.addPiece(new Pawn(false, new Spot(1,i)));
       }

       Game actualGame = new Game();
       actualGame.setBackEndBoard(board);
       BoardGUI gui = new BoardGUI(actualGame);
       gui.updateGUI();

       DisplayWindow DisplayWindow = new DisplayWindow();

       DisplayWindow.addPanel(gui);
    }
}
