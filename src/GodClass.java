import BackEndLogic.Game;
import UserInterface.*;

public class GodClass {

    public static void main(String[] args) {

        Game actualGame = new Game();

        BoardGUI gui = new BoardGUI(actualGame.getBoard());

        gui.updateGUI();

        DisplayWindow displayWindow = new DisplayWindow();

        displayWindow.addPanel(gui);
    }
}
