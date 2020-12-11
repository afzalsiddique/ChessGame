import UserInterface.*;

// Just creates a window with the menu
public class MainClass {
    public static void main(String[] args) {
        DisplayWindow displayWindow = new DisplayWindow();

        MenuGui menuGui = new MenuGui();
        menuGui.addJFrame(displayWindow);

        displayWindow.addPanel(menuGui.getPanel());


    }
}
