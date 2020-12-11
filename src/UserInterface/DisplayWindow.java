package UserInterface;

import javax.swing.*;
import java.awt.*;

public class DisplayWindow {

    JFrame window = new JFrame("N-ROL's Chess");

    public DisplayWindow(){
        window.setSize(700,720);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout());
        window.setResizable(false);
        window.setVisible(true);
    }

    public JFrame getWindow(){
        return window;
    }

    public void addPanel(JPanel jPanel){
        window.add(jPanel);
    }

    public void removePanels(){
        window.removeAll();
        window.setVisible(true);
    }

    void setSize(Dimension dimension){
        window.setSize(dimension);
    }

    void setSize(int width, int height){
        setSize(new Dimension(width, height));
    }

}
