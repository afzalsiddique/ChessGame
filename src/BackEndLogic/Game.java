package BackEndLogic;

import UserInterface.BoardGUI;

import java.util.ArrayList;

public class Game {
    Board backEndBoard = new Board();
    BoardGUI boardGUI;
    History moveHistory = new History();
    public int whiteWins;
    public int blackWins;
    Player whitePlayer;
    Player blackPlayer;

    boolean whiteTurn = true;

    Piece bRook1 = new Rook(false, new Spot(0,0));

    Piece wRook2 = new Rook(true, new Spot(7,7));
    Piece wRook1 = new Rook(true, new Spot(6,7));
    Piece wPawn1 = new Pawn(true, new Spot(6,0));

    Piece bPawn8 = new Pawn(false, new Spot(1,7));
    Piece wBishop1 = new Bishop(true, new Spot(7,2));

    public Game(){
        backEndBoard.addPiece(bRook1);
        backEndBoard.addPiece(wRook2);
        backEndBoard.addPiece(wRook1);
        backEndBoard.addPiece(bPawn8);
        backEndBoard.addPiece(wBishop1);
        backEndBoard.addPiece(wPawn1);
        backEndBoard.addPiece(new King(true, new Spot(5,5)));
        backEndBoard.addPiece(new King(false, new Spot(2,1)));
    }

    public void setFrontEndBoard(BoardGUI boardGUI){
        this.boardGUI = boardGUI;
    }

    public void setBackEndBoard(Board backEndBoard){
        this.backEndBoard = backEndBoard;
    }
    public void checkIfGameEndedAndUpdateWinCount(){
        String winner = backEndBoard.getWinner();
        if(winner.equals("black"))
            blackWins++;
        else if(winner.equals("white"))
            whiteWins++;
        else if(winner.equals("draw"))
            return;
        else if(winner.equals("none"))
            return;
    }

    public Board getBackEndBoard(){
        return backEndBoard;
    }

    public void UndoLastMove(){
        if(moveHistory.isEmpty())
            return;

        moveHistory.removeLastRecord();;
        setBackEndBoard(moveHistory.getLastRecord());
    }

    void changeTurn(){
        whiteTurn = !whiteTurn;
    }

    public ArrayList<Spot> getAvailableMoves(){
        return backEndBoard.getAvailableMoves();
    }

    public void selectPiece(int row, int col){
        if(!backEndBoard.isOccupied(row, col)) {
            System.out.println("Nothing There");
            return;
        }

        if(backEndBoard.getOccupiedColor(row, col) != whiteTurn){
            System.out.println("Not Your Turn");
            return;
        }

        backEndBoard.selectPiece(row, col);
        boardGUI.highlightAvailableMoves(getAvailableMoves());
        boardGUI.changeSelectedState();
    }

    public void selectPiece(Spot spot){
        selectPiece(spot.row, spot.col);
    }

    public void makeMove(int row, int col){
        if(!backEndBoard.isMoveValid(new Spot(row, col))){
            System.out.println("Not a valid Move");
            backEndBoard.clearAvailableMoves();
            backEndBoard.moveTransitionRecord.reset();
            boardGUI.changeSelectedState();
            return;
        }
        backEndBoard.makeMove(row, col);
        boardGUI.changeSelectedState();
        changeTurn();
        checkIfGameEndedAndUpdateWinCount();
    }

    public void makeMove(Spot spot){
        makeMove(spot.row, spot.col);
    }

}
