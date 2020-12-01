package BackEndLogic;
import java.util.ArrayList;

public class Board {

    public Piece[][] positions = new Piece[8][8];

    History moveHistory = new History();

    public Board(){}
    public Board(Piece[][] positions){
        this.positions = positions;
    }

    ArrayList<Spot> emptySpots = new ArrayList<>();
    ArrayList<Spot> availableMoves = new ArrayList<>();

    MoveTransitionRecord moveTransitionRecord = new MoveTransitionRecord();
//    boardGUI UI;


    public void recordMove(){
        moveHistory.addRecord(this);
        moveHistory.printSize();
    }

    void printBoard(){
        System.out.println("Prev Board:");
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(positions[i][j] != null)
                    System.out.print(1);
                else
                    System.out.print(0);
            }
            System.out.print('\n');
        }
    }

    public void undoLastMove(){
        Piece[][] tempBoard = moveHistory.getLastRecord();
        if(tempBoard == null)
            return;
        this.positions = tempBoard;
        printBoard();
    }

    public boolean isOccupied(Spot inputSpot){             // True if already occupied, false if not
        int col = inputSpot.col;
        int row = inputSpot.row;
        Piece positionToCheck = positions[row][col];
        if(positionToCheck == null)
            return false;
        else
            return true;
    }

    public boolean isOccupied(int x, int y){
        return isOccupied(new Spot(x, y));
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

    void removePiece(int row, int col){
        positions[row][col] = null;
    }

    void removePiece(Spot spot){
        removePiece(spot.row, spot.col);
    }

    void putPieceAtLocation(int row, int col, Piece inputPiece){
        positions[row][col] = inputPiece;

        if(getPiece(row, col) != null)
            getPiece(row, col).setCurrentSpot(new Spot(row, col));
    }

    void putPieceAtLocation(Spot inputSpot, Piece inputPiece){
        putPieceAtLocation(inputSpot.row, inputSpot.col, inputPiece);
    }

    private King getKing(boolean isWhite){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(getPiece(i,j) == null)
                    continue;
                if(getPiece(i,j) instanceof King && getPiece(i,j).getColor() == isWhite) {
                    return (King) getPiece(i, j);
                }
            }
        }
        return null;
    }

    ArrayList<Spot> getThisPieceMovesWithoutModifying(Piece inputPiece){
        return inputPiece.calculateAllPossibleMovesWithoutModifying();
    }

    ArrayList<Spot> getThisPieceMovesKing(King inputPiece){
        return inputPiece.calculateAllPossibleMovesWithoutModifying();
    }

    // True if checked, false otherwise
    private boolean checkIfKingIsChecked(boolean isWhite){
        King currentKing = getKing(isWhite);

        for(int i=0; i<8; i++) {
            for (int j = 0; j < 8; j++) {
                if (isOpponent(currentKing, getPiece(i, j))) {
                    ArrayList<Spot> somePieceMoves = new ArrayList<>();

                    if(getPiece(i,j) instanceof King)
                        somePieceMoves = getThisPieceMovesKing((King) getPiece(i,j));
                    else
                        somePieceMoves = getThisPieceMovesWithoutModifying(getPiece(i, j));

                    if (somePieceMoves.contains(currentKing.getCurrentSpot())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkIfMoveCreatesCheck(Spot newSpot, Spot oldSpot, boolean isWhite){
        Piece tempPiece = getPiece(newSpot);

        putPieceAtLocation(newSpot, getPiece(oldSpot));

        removePiece(oldSpot);

        Boolean isCheck = checkIfKingIsChecked(isWhite);

        putPieceAtLocation(oldSpot, getPiece(newSpot));

        putPieceAtLocation(newSpot, tempPiece);

        return isCheck;
    }

    protected ArrayList<Spot> modifyAvailableMoves(ArrayList<Spot> Moves, Spot currentSpot, boolean isWhite){        // Remove the Moves that cause check
        ArrayList<Spot> finalMoves = new ArrayList<>();
        for(int i=0; i<Moves.size(); i++){
            if(!checkIfMoveCreatesCheck(Moves.get(i), currentSpot, isWhite))
                finalMoves.add(Moves.get(i));
        }

        return finalMoves;
    }

    boolean checkGameState(Piece[][] positions){
        return false;
    }

    boolean updateGameState(Piece[][] positions) {
        return false;
    }

    private void calculateAvailableMoves(){
        availableMoves = moveTransitionRecord.getToMovePiece().calculateAllPossibleMoves();
    }

    public ArrayList<Spot> getAvailableMoves(){
        return availableMoves;
    }

    public void clearAvailableMoves(){
        availableMoves.clear();
    }

    boolean ifMoveIsValid(Spot inputSpot){
        return availableMoves.contains(inputSpot);
    }

    public void selectPiece(Spot spot){
        if(!isOccupied(spot)) {
            System.out.println("Nothing There");
            return;
        }
        moveTransitionRecord.setToMovePiece(getPiece(spot));
        calculateAvailableMoves();
    }

    public void selectPiece(int row, int col){
        selectPiece(new Spot(row, col));
    }

    public void makeMove(Spot spot){
        if(!ifMoveIsValid(spot)){
            System.out.println("Not a valid Move");
            clearAvailableMoves();
            moveTransitionRecord.reset();
            return;
        }

        // Actual Move Code
        clearAvailableMoves();
        removeSelectedPiece();
        moveSelectedPiece(spot);
        checkIfKingIsChecked(true);

        recordMove();
    }

    public void addPiece(Piece piece){
        piece.setBoard(this);
        positions[piece.getCurrentSpot().row][piece.getCurrentSpot().col] = piece;
    }

    void moveSelectedPiece(Spot inputSpot){
        moveTransitionRecord.getToMovePiece().setCurrentSpot(inputSpot);
        addPiece(moveTransitionRecord.getToMovePiece());

        if(moveTransitionRecord.getToMovePiece() instanceof Pawn)
            ((Pawn) moveTransitionRecord.getToMovePiece()).setFirstMove(false);
    }

    void removeSelectedPiece(){
        Spot prevPos = moveTransitionRecord.getToMovePiece().getCurrentSpot();
        positions[prevPos.row][prevPos.col] = null;
    }

    public void makeMove(int row, int col){
        makeMove(new Spot(row, col));
    }

    @Override
    public String toString() {
        String temp = "";
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                Piece piece = positions[i][j];
                if(piece!=null)
                    temp = temp + piece.toString();
                else
                    temp = temp + "..";
            }
            temp = temp + "\n";
        }
        return temp;
    }
}
