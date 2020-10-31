package BackEndLogic;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Piece {
    Spot spot;
    ImageIcon image;
    JButton ReferredButton;
    boolean isWhite;
    public ArrayList<Spot> availableMoves = new ArrayList<>();




    public boolean makeMove(Piece[][] positions) {
        return false;
    }

    public ArrayList<Spot> calculateAllPossibleMoves(Board board) {
        availableMoves.clear();
        availableMoves.add(new Spot(0,0));
        return  availableMoves;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public void setReferredButton(JButton referredButton) {
        ReferredButton = referredButton;
    }

    public JButton getReferredButton() {
        return ReferredButton;
    }

    public ImageIcon getImage(){
        return image;
    }

    public void castling(){
    
    }
}