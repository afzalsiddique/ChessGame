import BackEndLogic.*;
import UserInterface.BoardGUI;
import UserInterface.DisplayWindow;

public class Demo_4_AI {
    public static void main(String[] args) {
        Board board = new Board();


        board.addPiece(new Rook(true, new Spot(6,1)));
        board.addPiece(new Rook(true, new Spot(6,2)));
        board.addPiece(new Rook(true, new Spot(6,3)));
        board.addPiece(new Rook(true, new Spot(6,4)));
        board.addPiece(new Rook(true, new Spot(6,5)));


        board.addPiece(new Rook(false, new Spot(1,1)));
        board.addPiece(new Knight(false, new Spot(1,2)));
        board.addPiece(new Bishop(false, new Spot(1,3)));
        board.addPiece(new Queen(false, new Spot(1,4)));
        board.addPiece(new Pawn(false, new Spot(1,5)));



        Game actualGame = new Game();
        actualGame.setIsWhite(false);
        actualGame.setAiMode(true);
        actualGame.simAI.setIsWhite(true);
        actualGame.setBackEndBoard(board);
        BoardGUI gui = new BoardGUI(actualGame);
        gui.updateGUI();

        DisplayWindow displayWindow = new DisplayWindow();
        displayWindow.addPanel(gui);
    }
}
