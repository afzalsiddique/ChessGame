import Pieces.Pawn;
import Pieces.Piece;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class boardGUI {
    public JPanel BackPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    private Pawn pawn1;

    public boardGUI() {
        pawn1 = new Pawn();
        button1.setIcon(pawn1.getWhiteImage());
        button1.setFocusPainted(false);
        button2.setIcon(pawn1.getWhiteImage());
        button2.setFocusPainted(false);

        button3.setIcon(pawn1.getBlackImage());
        button3.setFocusPainted(false);

        button4.setIcon(pawn1.getBlackImage());
        button4.setFocusPainted(false);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
