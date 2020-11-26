package BackEndLogic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class King extends Piece {

    public King(boolean isWhite, Spot inputSpot){
        this.isWhite = isWhite;
        this.spot = inputSpot;
        importImage();
        setValue();
    }

    private void importImage(){
        try {
            if(isWhite){
                setImage(new ImageIcon(ImageIO.read(getClass().getResource("KingWhite.png"))));
            }
            else {
                setImage(new ImageIcon(ImageIO.read(getClass().getResource("KingBlack.png"))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void setValue() {
        value = 15;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public ArrayList<Spot> calculateAllPossibleMoves() {
        availableMoves.clear();
        availableMoves.add(new Spot(0,0));
        return  availableMoves;
    }

    public void castling(){

    }
}
