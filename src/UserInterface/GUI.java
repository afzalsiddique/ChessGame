package UserInterface;

import BackEndLogic.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    public buttons[][] buttons = new buttons[8][8];
    ActionListener actionListener;
    String move = "";

    Board backEndBoard;

    boolean isSelectedState = false;

    public GUI(Board board){
        this.backEndBoard = board;
        createButtons();
        makeLayoutVisible();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void updateGUI(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(backEndBoard.isOccupied(i,j)){
                    System.out.println("Found a piece at " + i + " " + j);
                    buttons[i][j].setIcon(backEndBoard.getPiece(i,j).getImage());
                }
            }
        }
    }

    void selectPiece(int x, int y){
        backEndBoard.selectPiece(x, y);
    }

    void moveSelectedPiece(int x, int y){
        backEndBoard.makeMove(x, y);
    }

    void createActionListener(int x, int y){
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Make moves etc.

                if(isSelectedState){
                    moveSelectedPiece(x, y);
                    isSelectedState = false;
                }
                else{
                    selectPiece(x, y);
                    isSelectedState = true;
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
