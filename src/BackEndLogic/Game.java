package BackEndLogic;

import UserInterface.BoardGUI;

import java.util.ArrayList;

public class Game {
    Board backEndBoard = new Board();
    BoardGUI boardGUI;
    History moveHistory = new History();
    AI_Agent ai_agent = new AI_Agent(backEndBoard);
    static public int whiteWins;
    static public int blackWins;
    Player whitePlayer;
    Player blackPlayer;

    static boolean whiteTurn;

    public Game(){
        startNewGame();
    }

    History getHistory(){
        return moveHistory;
    }

    public void startNewGame(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                backEndBoard.positions[i][j] = null;
            }
        }

        System.out.println("start new game from game class");
        Game.whiteTurn = true;
        backEndBoard.addPiece(new Rook(true, new Spot(7,7)));
        backEndBoard.addPiece(new Rook(true, new Spot(7,0)));
        backEndBoard.addPiece(new Rook(false, new Spot(0,0)));
        backEndBoard.addPiece(new Rook(false, new Spot(0,7)));
        backEndBoard.addPiece(new King(true, new Spot(7,4)));
        backEndBoard.addPiece(new King(false, new Spot(0,4)));
        backEndBoard.addPiece(new Bishop(true, new Spot(7,2)));
        backEndBoard.addPiece(new Bishop(true, new Spot(7,5)));
        backEndBoard.addPiece(new Bishop(false, new Spot(0,2)));
        backEndBoard.addPiece(new Bishop(false, new Spot(0,5)));
        backEndBoard.addPiece(new Queen(true, new Spot(7,3)));
        backEndBoard.addPiece(new Queen(false, new Spot(0,3)));
        backEndBoard.addPiece(new Knight(true, new Spot(7,1)));
        backEndBoard.addPiece(new Knight(true, new Spot(7,6)));
        backEndBoard.addPiece(new Knight(false, new Spot(0,6)));
        backEndBoard.addPiece(new Knight(false, new Spot(0,1)));

        for(int i=0; i<8; i++){
            backEndBoard.addPiece(new Pawn(false, new Spot(1,i)));
        }

        for(int i=0; i<8; i++){
            backEndBoard.addPiece(new Pawn(true, new Spot(6,i)));
        }

        backEndBoard.setBoardOnAllPieces();
        backEndBoard.setGameInfo(this);
        moveHistory.addRecord(backEndBoard);
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
        if(moveHistory.getSize() <= 1)
            return;

        moveHistory.removeLastRecord();
        setBackEndBoard(moveHistory.getLastRecord());
        boardGUI.updateGUI();

        changeTurn();
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
        moveHistory.addRecord(backEndBoard);
//        Spot[] sourceAndDest = ai_agent.findBestMove(backEndBoard);
//        aiMakeMove(sourceAndDest);
        boardGUI.updateGUI();
        checkIfGameEndedAndUpdateWinCount();
    }

    public void makeMove(Spot spot){
        makeMove(spot.row, spot.col);
    }
    public void aiMakeMove(Spot[] sourceAndDest){
        Spot src = sourceAndDest[0];
        Spot dst = sourceAndDest[1];
        Piece piece = backEndBoard.getPiece(src);
        backEndBoard.positions[dst.row][dst.col] = piece;
        backEndBoard.positions[src.row][src.col] = null;
    }
}
