import UserInterface.*;

import java.util.Random;

// Just creates a window with the menu
public class MainClass {
    public static void main(String[] args) {
        DisplayWindow displayWindow = new DisplayWindow();
        MenuGui menuGui = new MenuGui();
        menuGui.addWindow(displayWindow);
        displayWindow.addPanel(menuGui.getPanel());
        displayWindow.refresh();

        Random random = new Random();
        System.out.println(random.nextInt(7));
    }
}
