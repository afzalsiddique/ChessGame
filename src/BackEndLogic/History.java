package BackEndLogic;

import java.util.ArrayList;
import java.util.Stack;

public class History {
    private Stack<Board> records = new Stack<>();
//    public History(Board board){
//        addMove(board);
//    }

    public Board createCopyOf(Board board){
        Piece[][] positions = new Piece[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if (board.positions[i][j] != null){
                    Piece piece = board.getPiece(i,j);
                    Spot spot = new Spot(piece.currentSpot.row, piece.currentSpot.col);
                    if(piece instanceof Pawn)
                        positions[i][j] = new Pawn(piece.getColor(), spot, ((Pawn) piece).isFirstMove());
                    else if(piece instanceof Rook)
                        positions[i][j] = new Rook(piece.getColor(), spot, ((Rook) piece).isFirstMove());
                    else if(piece instanceof Bishop)
                        positions[i][j] = new Bishop(piece.getColor(), spot);
                    else if(piece instanceof King)
                        positions[i][j] = new King(piece.getColor(), spot, ((King) piece).isFirstMove());
                    else if(piece instanceof Queen)
                        positions[i][j] = new Queen(piece.getColor(), spot);
                    else if(piece instanceof Knight)
                        positions[i][j] = new Knight(piece.getColor(), spot);
                    positions[i][j].setBoard(board);
                }
            }
        }
        return new Board(positions);
    }

    public void addRecord(Board board){
        records.push(createCopyOf(board));
//        System.out.println("Added a Move. "+"record size: "+records.size());
    }

    void printBoard(Board board){
        System.out.println(board);
    }

    public boolean isEmpty(){
        return records.isEmpty();
    }

    public int getSize(){
        return records.size();
    }

    public void printEntireHistory(){
        System.out.println("Printing Entire History:");
        for(int i=0; i<records.size(); i++){
            System.out.println("Move=" + i);
            printBoard(records.get(i));
        }
    }

    public void removeLastRecord(){
        if(records.isEmpty()){
            System.out.println("Records empty");
            return;
        }

        records.pop();
        System.out.println("Removed last Move, Size is now: " + records.size());


    }

    public Board getLastRecord(){
        if(isEmpty())
            return null;
        Board res = records.peek();
        return createCopyOf(res);
    }

    void printSize(){
        System.out.println("Total Moves Made=" + records.size());
    }
}
