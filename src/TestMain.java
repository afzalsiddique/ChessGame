import javax.swing.*;

public class TestMain {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Game");
        jf.setSize(1200,1200);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        boardGUI b = new boardGUI();
        jf.add(b.BackPanel);

        jf.setVisible(true);

    }
}
