package BackEndLogic;

import java.util.ArrayList;

public class History {
    ArrayList<Piece[][]> records = new ArrayList<>();

//    public History(Board board){
//        addMove(board);
//    }

    public void addMove(Board board){
        Piece[][] positions = new Piece[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if (board.positions[i][j] != null){
                    Piece piece = board.getPiece(i,j);
                    Spot spot = new Spot(piece.currentSpot.row, piece.currentSpot.col);
                    if(piece instanceof Pawn)
                        positions[i][j] = new Pawn(piece.getColor(), spot);
                    else if(piece instanceof Rook)
                        positions[i][j] = new Rook(piece.getColor(), spot);
                    else if(piece instanceof Bishop)
                        positions[i][j] = new Bishop(piece.getColor(), spot);
                    else if(piece instanceof King)
                        positions[i][j] = new King(piece.getColor(), spot);
                    else if(piece instanceof Queen)
                        positions[i][j] = new Queen(piece.getColor(), spot);
                    else if(piece instanceof Knight)
                        positions[i][j] = new Knight(piece.getColor(), spot);
                }
            }
        }
        System.out.println("Added a Move");
        printBoard(positions);
        records.add(positions);
    }

    void printBoard(Piece[][] positions){
        System.out.println("Board from history:");
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

    public Piece[][] getLastRecord(){
        if(records.isEmpty())
            return null;
        records.remove(records.size()-1);
        System.out.println("Removing last Move, Size is now: " + records.size());
        Piece[][] positions= records.get(records.size()-1);
        printBoard(records.get(records.size()-1));
        return positions;
    }

    void printSize(){
        System.out.println("Total Moves Made=" + records.size());
    }
}
