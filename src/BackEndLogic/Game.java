package BackEndLogic;

public class Game {
    Board board = new Board();
    History moveHistory = new History();

    Player whitePlayer;
    Player blackPlayer;

    Piece bRook1 = new Rook(false, new Spot(0,0));

    Piece wRook2 = new Rook(true, new Spot(7,7));
    Piece wPawn1 = new Pawn(true, new Spot(6,0));

    Piece bPawn8 = new Pawn(false, new Spot(1,7));
    Piece wBishop1 = new Bishop(true, new Spot(7,2));

    public Game(){
        board.addPiece(bRook1);
        board.addPiece(wRook2);
        board.addPiece(bPawn8);
        board.addPiece(wBishop1);
        board.addPiece(wPawn1);
        board.addPiece(new King(true, new Spot(5,5)));
        board.addPiece(new King(false, new Spot(2,1)));

    }

    public Board getBoard(){
        return board;
    }

}
