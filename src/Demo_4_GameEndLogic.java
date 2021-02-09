import BackEndLogic.*;
import UserInterface.BoardGUI;
import UserInterface.DisplayWindow;

public class Demo_4_GameEndLogic {
    public static void main(String[] args) {
        Board board = new Board();
        board.addPiece(new Rook(false, new Spot(6,7)));
        board.addPiece(new Rook(false, new Spot(0,0)));
        board.addPiece(new King(true, new Spot(7,4)));
        board.addPiece(new King(false, new Spot(0,4)));


        Game actualGame = new Game();
        actualGame.setBackEndBoard(board);
        BoardGUI gui = new BoardGUI(actualGame);
        gui.updateGUI();

        DisplayWindow displayWindow = new DisplayWindow();
        displayWindow.addPanel(gui);
    }
}
