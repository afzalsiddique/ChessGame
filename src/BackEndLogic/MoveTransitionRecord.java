package BackEndLogic;

public class MoveTransitionRecord {
    private Piece toMove;

    public boolean checkIfSelected(){
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
        return toMove.getCurrentSpot();
    }

    public Piece getToMovePiece(){
        if(!checkIfSelected()){
            System.out.println("Select First");
            return null;
        }
        return toMove;
    }

    MoveTransitionRecord(){
        reset();
    }

}
