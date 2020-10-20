import javax.swing.*;

public class DisplayUI {
    boardGUI DisplayBoard;
    DisplayUI(){
        JFrame jf = new JFrame("Game");
        jf.setSize(1200,1200);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        DisplayBoard = new boardGUI();
        jf.add(DisplayBoard.BackPanel);

        jf.setVisible(true);
    }
}
