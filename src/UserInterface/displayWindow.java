package UserInterface;

import javax.swing.*;
import java.awt.*;

public class displayWindow{

    JFrame window = new JFrame("Chess");

    public displayWindow(){
        window.setSize(700,720);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout());
        window.setResizable(false);
        window.setVisible(true);
    }

    public void addPanel(JPanel jPanel){
        window.add(jPanel);
    }

    public void removePanels(){
        window.removeAll();
    }



}
