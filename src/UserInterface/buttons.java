package UserInterface;

import javax.swing.*;
import java.awt.*;

public class buttons extends JButton {
    Dimension dim = new Dimension(80, 80);
    buttons(){
       setPreferredSize(dim);
       setEnabled(true);
    }
}
