import BackEndLogic.Game;
import UserInterface.*;


// This Class is a reference to how the actual main class will work
public class GodClass {
    Game actualGame;
    BoardGUI gui;

    void updateGUI(){
        gui.updateGUI();;
    }

    void StartGame(){
        actualGame = new Game();
        gui = new BoardGUI(actualGame);
        updateGUI();

        DisplayWindow displayWindow = new DisplayWindow();

        displayWindow.addPanel(gui);
    }

    public static void main(String[] args) {
        new GodClass().StartGame();
    }
}
