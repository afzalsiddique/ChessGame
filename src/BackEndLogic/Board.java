package BackEndLogic;
import java.util.ArrayList;

public class Board {

    public Piece[][] positions = new Piece[8][8];

    public Board(){

    }

    ArrayList<Spot> emptySpots = new ArrayList<>();
    ArrayList<Spot> availableMoves = new ArrayList<>();

    MoveTransitionRecord moveTransitionRecord = new MoveTransitionRecord();
//    boardGUI UI;

    boolean isOccupied(Spot inputSpot){             // True if already occupied, false if not
        int col = inputSpot.col;
        int row = inputSpot.row;
        Piece positionToCheck = positions[row][col];
        if(positionToCheck == null)
            return false;
        else
            return true;
    }

    boolean getOccupiedColor(Spot inputSpot){
        int col = inputSpot.col;
        int row = inputSpot.row;
        Piece toCheck = positions[row][col];
        return toCheck.getColor();
    }

    boolean isOpponent(Piece piece1, Piece piece2){
        if(piece1 == null || piece2 == null) return false;
        if(piece1.getColor() == piece2.getColor())
            return false;
        return true;
    }

    public Piece getPiece (int row, int col){
        return positions[row][col];
    }

    public Piece getPiece (Spot spot){
        return getPiece(spot.row,spot.col);
    }

    void start() {
        positions[1][0] = new Pawn(true, new Spot(6,1));
    }

    public void getEmptySpots(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(this.positions[i][j]==null)
                    emptySpots.add(new Spot(i,j));
            }
        }
    }
    public void addPiece(Piece piece){
        piece.setBoard(this);
        positions[piece.getSpot().row][piece.getSpot().col] = piece;
    }


    boolean checkGameState(Piece[][] positions){
        return false;
    }

    boolean updateGameState(Piece[][] positions) {
        return false;
    }

//    Board(boardGUI UI){
//        this.UI = UI;
//        UI.setInternalBoard(this);
//        start();
//    }

    void calculateAvailableMoves(){
        availableMoves = moveTransitionRecord.getToMovePiece().calculateAllPossibleMoves();
    }

    ArrayList<Spot> getAvailableMoves(){
        return availableMoves;
    }

    void clearAvailableMoves(){
        availableMoves.clear();
    }

    boolean ifMoveIsValid(Spot inputSpot){
        return availableMoves.contains(inputSpot);
    }

    void selectPiece(Spot spot){
        if(!isOccupied(spot)) {
            System.out.println("Nothing There, Bitch");
            return;
        }
        moveTransitionRecord.setToMovePiece(getPiece(spot));
        calculateAvailableMoves();
    }

    void selectPiece(int row, int col){
        selectPiece(new Spot(row, col));
    }

    void makeMove(Spot spot){
        if(!ifMoveIsValid(spot)){
            System.out.println("Not a valid Move, Bitch");
            clearAvailableMoves();
            moveTransitionRecord.reset();
            return;
        }

        // Actual Move Code

    }

    void makeMove(int row, int col){
        makeMove(new Spot(row, col));
    }

//    void makeMove(Piece inputPiece){
//        if(isOccupied(inputPiece.getSpot()) && !moveTransitionRecord.checkIfSelected())
//            return;
//
//        if(moveTransitionRecord.checkIfSelected()){
//            if(inputPiece.equals(moveTransitionRecord.getToMovePiece()))
//                return;
//            if(ifMoveIsValid(inputPiece.getSpot())){
//                Spot thisSpot = inputPiece.getSpot();
//                positions[thisSpot.row][thisSpot.col] = inputPiece;
//                moveTransitionRecord.getToMovePiece().setSpot(inputPiece.getSpot());
//                moveTransitionRecord.reset();
//            }
//        }
//        else{
//            moveTransitionRecord.setToMovePiece(inputPiece);
//            displayAvailableMoves();
//        }
//    }
}
