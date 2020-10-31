package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class buttons extends JButton implements ActionListener {
    Dimension dim = new Dimension(80, 80);
    buttons(String text){
       super(text);
       setPreferredSize(dim);
       addActionListener(this);
       setEnabled(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
