package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    public buttons[][] buttons = new buttons[8][8];
    ActionListener actionListener;
    String move = "";

    boolean isSelectedState = false;

    public GUI(){
        createButtons();
        makeLayoutVisible();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void selectPiece(int x, int y){

    }

    void moveSelectedPiece(int x, int y){

    }

    void createActionListener(int x, int y){
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Make moves etc.

                if(isSelectedState){
                    moveSelectedPiece(x, y);
                }
                else{
                    selectPiece(x, y);
                }

            }
        };

    }

    public void createButtons(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                buttons[i][j] = new buttons("");
                add(buttons[i][j]);
                createActionListener(i,j);
                buttons[i][j].addActionListener(actionListener);

                // Set the color
                if(i%2==0){
                    if(j%2==0)
                        buttons[i][j].setBackground(Color.WHITE);
                    else
                        buttons[i][j].setBackground(Color.BLACK);
                }
                else {
                    if (j%2!=0)
                        buttons[i][j].setBackground(Color.WHITE);
                    else
                        buttons[i][j].setBackground(Color.BLACK);
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
