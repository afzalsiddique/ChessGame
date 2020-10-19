import Pieces.Pawn;
import Pieces.PawnWhite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class boardGUI {
     public JPanel BackPanel;
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

    public boardGUI() {
        whitePawn1 = new PawnWhite();
        button9.setIcon(whitePawn1.getImage());
        button9.setFocusPainted(false);


        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
