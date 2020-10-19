package Pieces;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class PawnWhite extends Pawn {
    public PawnWhite(){
        try {
            image = new ImageIcon(ImageIO.read(getClass().getResource("PawnWhite.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
