package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuButton extends JButton implements ActionListener {
    Dimension dim = new Dimension(500, 80);
    MenuButton(String text){
        super(text);
        setPreferredSize(dim);
        addActionListener(this);
        setEnabled(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
