import Pieces.Pawn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class boardGUI {
    public JPanel BackPanel;
    private JButton button1;

    private Pawn pawn1;

    public boardGUI() {
        pawn1 = new Pawn();
        button1.setIcon(pawn1.getWhiteImage());
        button1.setFocusPainted(false);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
