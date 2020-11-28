package BackEndLogic;

import java.util.ArrayList;

public class History {
    ArrayList<Board> records = new ArrayList<Board>();
    Board board;

    public History(Board board){
        this.board = board;
    }

    public void addMove(){
        Piece[][] positions = new Piece[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if (board.positions[i][j] != null){
                    Piece piece = board.positions[i][j];
                    Spot spot = new Spot(piece.currentSpot.row, piece.currentSpot.col);
                    if(piece.getClass().isInstance(Pawn.class))
                        positions[i][j] = new Pawn(piece.getColor(), spot);
                    else if(piece.getClass().isInstance(Rook.class))
                        positions[i][j] = new Rook(piece.getColor(), spot);
                    else if(piece.getClass().isInstance(Bishop.class))
                        positions[i][j] = new Bishop(piece.getColor(), spot);
                    else if(piece.getClass().isInstance(King.class))
                        positions[i][j] = new King(piece.getColor(), spot);
                    else if(piece.getClass().isInstance(Queen.class))
                        positions[i][j] = new Queen(piece.getColor(), spot);
                    else if(piece.getClass().isInstance(Knight.class))
                        positions[i][j] = new Knight(piece.getColor(), spot);
                }
            }
        }
        records.add(new Board(positions));
    }
    public Board getLastRecord(){
        Board board = records.get(records.size()-1);
        records.remove(records.size()-1);
        return board;
    }

}
