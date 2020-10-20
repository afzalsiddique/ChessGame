import javax.swing.*;
import java.awt.*;

public class NewGUI extends JFrame {
    public NewJButton[][] buttons = new NewJButton[8][8];
    String move = "MOVE";
    public NewGUI(){
        createButtons();
        makeLayoutVisible();
    }

    public void createButtons(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                buttons[i][j] = new NewJButton(move);
                add(buttons[i][j]);
                if(i%2==0){
                    if(j%2==0)
                        buttons[i][j].setBackground(Color.BLACK);
                    else
                        buttons[i][j].setBackground(Color.WHITE);
                }
                else {
                    if (j % 2 != 0)
                        buttons[i][j].setBackground(Color.BLACK);
                    else
                        buttons[i][j].setBackground(Color.WHITE);
                }
            }
        }
    }

    private void makeLayoutVisible() {
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(700, 750);
    }
}
