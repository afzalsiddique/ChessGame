package BackEndLogic;

import java.util.ArrayList;

public class SimAI {
    Board bestBoard;
    Spot srcFinal, destFinal;
    boolean isWhite;

    public void setIsWhite(boolean isWhite){
        this.isWhite = isWhite;
    }

    public void getBestBoard(Board board){
        int bestScore;

        if(isWhite)
            bestScore = Integer.MIN_VALUE;
        else
            bestScore = Integer.MAX_VALUE;

        Piece [][] positions = board.positions;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                Piece srcPiece = positions[i][j];
                if(srcPiece!=null && srcPiece.isWhite == isWhite){
                    ArrayList<Spot> availableMoves = srcPiece.calculateAllPossibleMoves();
                    System.out.println("source Piece: "+srcPiece+ " at "+srcPiece.currentSpot);
                    for(int k=0;k<availableMoves.size();k++){
                        System.out.println("Spot " + k + ": " + availableMoves.get(k));
                        System.out.println(board + "1");
                        // move the srcPiece
                        Spot dest = availableMoves.get(k);
                        Piece destPiece = board.getPiece(dest);
//                        positions[dest.row][dest.col] = srcPiece;
//                        positions[i][j] = null;
//                        srcPiece.setCurrentSpot(dest);

                        board.putPieceAtLocation(dest, srcPiece);

                        board.removePiece(i,j);

                        // calculate score
                        int currentScore = evaluate(board);
                        System.out.println("Moving to: "+dest+" Score: "+currentScore);
                        if (isWhite && currentScore>bestScore){
                            System.out.println("replaced: "+currentScore);
                            bestScore = currentScore;
                            srcFinal = new Spot(i,j);
                            destFinal = dest;
                        }

                        else if(!isWhite && currentScore<bestScore){
                            System.out.println("replaced: "+currentScore);
                            bestScore = currentScore;
                            srcFinal = new Spot(i,j);
                            destFinal = dest;
                        }

                        System.out.println(board + "2");
                        // undo the move
//                        positions[i][j] = srcPiece;
//                        srcPiece.setCurrentSpot(new Spot(i,j));
//                        positions[dest.row][dest.col] = destPiece;
//                        if (destPiece != null)
//                            destPiece.setCurrentSpot(new Spot(dest.row,dest.col));
                        board.putPieceAtLocation(i,j,srcPiece);
                        board.removePiece(dest);
                        board.putPieceAtLocation(dest, destPiece);
                        board.moveTransitionRecord.reset();


                    }
                        availableMoves.clear();
                }
            }
        }
        System.out.println("best");
    }

    public int evaluate(Board board){ // this can evaluate any board not just current game board
        // need to calculate checkmate score
        // if white wins score should be greater than 10000 or must be changed in minimax method
        // if white loses score should be less than -10000 or must be changed in minimax method
//        if (board.getWinner().equals("white")){
//            return 100000;
//        }
//        if (board.getWinner().equals("black")){
//            return -100000;
//        }
        int score = 0;
        Piece[][] positions = board.positions;
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                if(positions[i][j] != null) {
                    System.out.println(i + " " + j);
                    Piece temp = positions[i][j];
                    int value = temp.getValue();
                    System.out.println(value);
                    score += positions[i][j].getValue();
                }
        return score;
    }
    public Board createCopyOf(Board board) {
        Piece[][] positions = new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.positions[i][j] != null) {
                    Piece piece = board.getPiece(i, j);
                    Spot spot = new Spot(piece.currentSpot.row, piece.currentSpot.col);
                    if (piece instanceof Pawn)
                        positions[i][j] = new Pawn(piece.getColor(), spot, ((Pawn) piece).isFirstMove());
                    else if (piece instanceof Rook)
                        positions[i][j] = new Rook(piece.getColor(), spot, ((Rook) piece).isFirstMove());
                    else if (piece instanceof Bishop)
                        positions[i][j] = new Bishop(piece.getColor(), spot);
                    else if (piece instanceof King)
                        positions[i][j] = new King(piece.getColor(), spot, ((King) piece).isFirstMove());
                    else if (piece instanceof Queen)
                        positions[i][j] = new Queen(piece.getColor(), spot);
                    else if (piece instanceof Knight)
                        positions[i][j] = new Knight(piece.getColor(), spot);
                    positions[i][j].setBoard(board);
                }
            }
        }
        return new Board(positions);
    }
}
