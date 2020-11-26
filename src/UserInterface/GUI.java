package UserInterface;

import BackEndLogic.Board;
import BackEndLogic.Spot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame {
    private buttons[][] buttons = new buttons[8][8];
    String move = "";

    private Board backEndBoard;

    private boolean isSelectedState = false;

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
                    buttons[i][j].setIcon(backEndBoard.getPiece(i,j).getImage());
                }
                else{
                    buttons[i][j].setIcon(null);
                }
            }
        }
    }

    private void highlightSpot(Spot inputSpot){
        buttons[inputSpot.row][inputSpot.col].setBackground(Color.GREEN.darker().darker().darker().darker());
    }

    private void highlightCapture(Spot inputSpot){
        buttons[inputSpot.row][inputSpot.col].setBackground(Color.RED.darker().darker());
    }

    private void highlightAvailableMoves(ArrayList<Spot> availableMoves){
        for(int i=0; i<availableMoves.size(); i++){

            //Empty Spot
            if(!backEndBoard.isOccupied(availableMoves.get(i)))
                highlightSpot(availableMoves.get(i));

            //Opponent Piece's Spot
            else
                highlightCapture(availableMoves.get(i));
        }

    }

    private void refreshBackGrounds(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
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

    private void selectPiece(int x, int y){
        backEndBoard.selectPiece(x, y);
        highlightAvailableMoves(backEndBoard.getAvailableMoves());
    }

    private void moveSelectedPiece(int x, int y){
        backEndBoard.makeMove(x, y);
        updateGUI();
        backEndBoard.clearAvailableMoves();
        refreshBackGrounds();
    }

    private ActionListener createActionListener(int x, int y){
        return new ActionListener() {
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

    private void createButtons(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                buttons[i][j] = new buttons("");
                add(buttons[i][j]);
                buttons[i][j].addActionListener(createActionListener(i,j));

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
        setSize(700, 750);
        setResizable(false);
        setTitle("Chess, Bitch");
        setVisible(true);
    }
}
