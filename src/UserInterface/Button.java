package UserInterface;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    Dimension dim = new Dimension(80, 80);
    Button(){
       setPreferredSize(dim);
       setEnabled(true);
    }
}
