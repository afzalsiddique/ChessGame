import javax.swing.*;

public class DisplayUI {
    boardGUI b;
    DisplayUI(){
        JFrame jf = new JFrame("Game");
        jf.setSize(1200,1200);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        b = new boardGUI();
        jf.add(b.BackPanel);

        jf.setVisible(true);
    }
}
