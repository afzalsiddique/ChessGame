import Pieces.*;

public class MoveTransitionRecord {
    private Piece toMove;
    private Spot prevSpot;

    boolean checkIfSelected(){
        if(toMove == null)
            return false;
        return true;
    }

    public void reset(){
        prevSpot = null;
        toMove = null;
    }

    public void setToMovePiece(Piece piece){
        toMove = piece;
    }

    public void setPrevSpot(Spot spot){
        prevSpot = spot;
    }

    public Piece getToMovePiece(){
        if(!checkIfSelected()){
            System.out.println("Select First");
            return null;
        }
        return toMove;
    }

    public MoveTransitionRecord(){
        reset();
    }

}
