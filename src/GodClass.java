import BackEndLogic.Board;
import UserInterface.*;

public class GodClass {

    public static void main(String[] args) {

        Board board = new Board();

        GUI gui = new GUI(board);

        DisplayWindow displayWindow = new DisplayWindow();

        displayWindow.addPanel(gui);
    }
}