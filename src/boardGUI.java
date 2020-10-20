import Pieces.Pawn;
import Pieces.PawnWhite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class boardGUI {
     public JPanel BackPanel;

     boolean makingMove = false;
     JButton previousButton;
     ImageIcon toMove;

     Board internalBoard;

     JButton button1;
     JButton button2;
     JButton button3;
     JButton button4;
     JButton button5;
     JButton button6;
     JButton button7;
     JButton button8;
     JButton button9;
     JButton button10;
     JButton button11;
     JButton button12;
     JButton button13;
     JButton button14;
     JButton button15;
     JButton button16;
     JButton button17;
     JButton button18;
     JButton button19;
     JButton button20;
     JButton button21;
     JButton button22;
     JButton button23;
     JButton button24;
     JButton button25;
     JButton button26;
     JButton button27;
     JButton button28;
     JButton button29;
     JButton button30;
     JButton button31;
     JButton button32;
     JButton button33;
     JButton button34;
     JButton button35;
     JButton button36;
     JButton button37;
     JButton button38;
     JButton button39;
     JButton button40;
     JButton button41;
     JButton button42;
     JButton button43;
     JButton button44;
     JButton button45;
     JButton button46;
     JButton button47;
     JButton button48;
     JButton button49;
     JButton button50;
     JButton button51;
     JButton button52;
     JButton button53;
     JButton button54;
     JButton button55;
     JButton button56;
     JButton button57;
     JButton button58;
     JButton button59;
     JButton button60;
     JButton button61;
     JButton button62;
     JButton button63;
     JButton button64;

    private Pawn whitePawn1;

    void setInternalBoard(Board board){
        internalBoard = board;
    }

    void makeMove(int x, int y, JButton button){
        System.out.println(x + " " + y + "\nMakingMove=" + makingMove);
        if(makingMove){
            System.out.println("1in");
            if(!internalBoard.isOccupied(x,y) && internalBoard.checkIfValid(x,y)){
                System.out.println("11in");
                makingMove = false;
                button.setIcon(toMove);
                previousButton.setIcon(null);
                internalBoard.makeMove(x,y);
                System.out.println("Success1");
            }
        }
        else{
            System.out.println("2in " + "bool=" + internalBoard.isOccupied(x,y));
            if(internalBoard.isOccupied(x,y)){
                System.out.println("22in");
                makingMove = true;
                toMove = (ImageIcon) button.getIcon();
                previousButton = button;
                internalBoard.makeMove(x,y);
                System.out.println("Success2");
            }
        }
    }

    public boardGUI() {
        whitePawn1 = new PawnWhite();
        button12.setIcon(whitePawn1.getImage());
        button4.setFocusPainted(false);
        button12.setFocusPainted(false);
        button20.setFocusPainted(false);
        button28.setFocusPainted(false);
        button36.setFocusPainted(false);
        button44.setFocusPainted(false);
        button52.setFocusPainted(false);
        button60.setFocusPainted(false);

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               makeMove(0,3, button4);
            }
        });

         button12.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                   makeMove(1,3, button12);
              }
         });

         button20.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                   makeMove(2,3, button20);
              }
         });

         button28.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                   makeMove(3,3, button28);
              }
         });

         button36.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                   makeMove(4,3, button36);
              }
         });

         button44.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                   makeMove(5,3, button44);
              }
         });

         button52.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                   makeMove(6,3, button52);
              }
         });

        button60.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                makeMove(7,3, button60);
            }
        });
    }

}
