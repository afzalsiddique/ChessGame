import UserInterface.*;

// Just creates a window with the menu
public class MainClass {
    public static void main(String[] args) {
        DisplayWindow displayWindow = new DisplayWindow();
        displayWindow.addPanel(new MenuGui().getPanel());
    }
}
