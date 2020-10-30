import Pieces.*;

public class MoveTransitionRecord {
    private Piece toMove;

    boolean checkIfSelected(){
        if(toMove == null)
            return false;
        return true;
    }

    public void reset(){
        toMove = null;
    }

    public void setToMovePiece(Piece piece){
        toMove = piece;
    }

    public Spot getPrevSpot(){
        return toMove.getSpot();
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
