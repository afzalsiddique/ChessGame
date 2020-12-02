import BackEndLogic.Game;
import UserInterface.*;

public class DisplayMenu {

    public static void main(String[] args) {

        Game actualGame = new Game();

        MainMenu menu = new MainMenu();


        DisplayWindow displayWindow = new DisplayWindow();

        displayWindow.addPanel(menu);
    }
}
