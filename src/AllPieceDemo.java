import BackEndLogic.*;
import UserInterface.GUI;

public class AllPieceDemo {
    public static void main(String[] args) {
        Board board = new Board();
        Piece bRook1 = new Rook(false, new Spot(0,0));
//        Piece bRook2 = new Rook(false, new Spot(0,7));
//        Piece wRook1 = new Rook(true, new Spot(7,0));
        Piece wRook2 = new Rook(true, new Spot(7,7));
//        Piece wPawn1 = new Pawn(true, new Spot(6,0));
        Piece wPawn2 = new Pawn(true, new Spot(6,1));
//        Piece wPawn3 = new Pawn(true, new Spot(6,2));
//        Piece wPawn4 = new Pawn(true, new Spot(6,3));
//        Piece wPawn5 = new Pawn(true, new Spot(6,4));
//        Piece wPawn6 = new Pawn(true, new Spot(6,5));
//        Piece wPawn7 = new Pawn(true, new Spot(6,6));
//        Piece wPawn8 = new Pawn(true, new Spot(6,7));
        Piece bPawn1 = new Pawn(false, new Spot(1,0));
        Piece bPawn2 = new Pawn(false, new Spot(1,1));
        Piece bPawn3 = new Pawn(false, new Spot(1,2));
//        Piece bPawn4 = new Pawn(false, new Spot(1,3));
//        Piece bPawn5 = new Pawn(false, new Spot(1,4));
//        Piece bPawn6 = new Pawn(false, new Spot(1,5));
//        Piece bPawn7 = new Pawn(false, new Spot(1,6));
        Piece bPawn8 = new Pawn(false, new Spot(1,7));
        Piece wBishop1 = new Bishop(true, new Spot(7,2));
//        Piece wBishop2 = new Bishop(true, new Spot(7,5));
//        Piece bBishop1 = new Bishop(false, new Spot(0,2));
        Piece bBishop2 = new Bishop(false, new Spot(0,5));
        Piece wQueen = new Queen(true, new Spot(7,3));
        Piece bQueen = new Queen(false, new Spot(0,3));
        Piece wKing = new King(true, new Spot(7,4));
        Piece bKing = new King(false, new Spot(0,4));
        Piece wKnight1 = new Knight(true, new Spot(7,1));
//        Piece wKnight2 = new Knight(true, new Spot(7,6));
//        Piece bKnight1 = new Knight(false, new Spot(0,1));
        Piece bKnight2 = new Knight(false, new Spot(0,6));

//        board.addPiece(wRook1);
        board.addPiece(wRook2);
        board.addPiece(bRook1);
//        board.addPiece(bRook2);
//        board.addPiece(wPawn1);
        board.addPiece(wPawn2);
//        board.addPiece(wPawn3);
//        board.addPiece(wPawn4);
//        board.addPiece(wPawn5);
//        board.addPiece(wPawn6);
//        board.addPiece(wPawn7);
//        board.addPiece(wPawn8);
        board.addPiece(bPawn1);
        board.addPiece(bPawn2);
        board.addPiece(bPawn3);
//        board.addPiece(bPawn4);
//        board.addPiece(bPawn5);
//        board.addPiece(bPawn6);
//        board.addPiece(bPawn7);
        board.addPiece(bPawn8);
        board.addPiece(wBishop1);
//        board.addPiece(wBishop2);
//        board.addPiece(bBishop1);
        board.addPiece(bBishop2);
        board.addPiece(wQueen);
        board.addPiece(bQueen);
        board.addPiece(wKing);
        board.addPiece(bKing);
        board.addPiece(wKnight1);
//        board.addPiece(wKnight2);
//        board.addPiece(bKnight1);
        board.addPiece(bKnight2);

        GUI gui = new GUI(board);
        gui.updateGUI();
    }
}
