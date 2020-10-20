import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewJButton extends JButton implements ActionListener {
    Dimension dim = new Dimension(80, 80);
    NewJButton(String text){
       super(text);
       setPreferredSize(dim);
       addActionListener(this);
       setEnabled(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
