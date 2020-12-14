package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuButton extends JButton{
    Dimension dim = new Dimension(500, 80);
    MenuButton(String text){
        super(text);
        setPreferredSize(dim);
        setEnabled(true);
    }
}
