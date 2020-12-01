import BackEndLogic.Game;
import UserInterface.*;

public class DisplayMenu {

    public static void main(String[] args) {

        Game actualGame = new Game();

        UserInterface.Game menu = new UserInterface.Game();


        DisplayWindow displayWindow = new DisplayWindow();

        displayWindow.addPanel(menu);
    }
}
