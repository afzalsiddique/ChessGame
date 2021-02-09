package BackEndLogic;

import java.util.ArrayList;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class AI_Agent {
    Board board;

    public AI_Agent(Board currentGameBoard) {
        this.board = currentGameBoard;
    }
    public int minimax(Board board, int depth, boolean maxPlayer){ // first call to this method should be with !maxPlayer
        Spot spotPieceSource;
        Spot spotPieceDest;
        Piece pieceSource;
        Piece pieceDest; // could be null
        int score = evaluate(board);
        if(depth==0)
            return score;
        // if someone wins
        if(score==10000 || score == -10000) // assuming winning score is greater than
            return score;

        // if someone hasn't won or max depth hasn't reached
        Piece[][] positions = board.positions;
        if(maxPlayer){
            int maxScore = -999999;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    pieceSource = positions[i][j];
                    if(pieceSource!=null){
                        spotPieceSource = pieceSource.getCurrentSpot();
                        ArrayList<Spot> availableMoves = pieceSource.calculateAllPossibleMoves();
                        for(int k=0;k<availableMoves.size();k++) {
                            spotPieceDest = availableMoves.get(k);
                            pieceDest = board.getPiece(spotPieceDest);
                            // make the move
                            // move pieceSource to spotPieceDest
                            movePieceToSpot(board, pieceSource, spotPieceDest);
                            // make spotPieceSource null
                            board.positions[spotPieceSource.row][spotPieceSource.col] = null;
                            // calculate score and take the maxScore
                            score = minimax(board, depth - 1, !maxPlayer);
                            maxScore = max(maxScore, score);
                            // undo the move
                            // move pieceSource to spotPieceSource
                            movePieceToSpot(board, pieceSource, spotPieceSource);
                            // move pieceDest to spotPieceDest
                            movePieceToSpot(board, pieceDest, spotPieceDest);
                        }
                    }
                }
            }
            return maxScore;
        }

        else{
            int minScore = 999999;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    pieceSource = positions[i][j];
                    if(pieceSource!=null){
                        spotPieceSource = pieceSource.getCurrentSpot();
                        ArrayList<Spot> availableMoves = pieceSource.calculateAllPossibleMoves();
                        for(int k=0;k<availableMoves.size();k++){
                            spotPieceDest = availableMoves.get(k);
                            pieceDest = board.getPiece(spotPieceDest);
                            // make the move
                            // move pieceSource to spotPieceDest
                            movePieceToSpot(board, pieceSource, spotPieceDest);
                            // make spotPieceSource null
                            board.positions[spotPieceSource.row][spotPieceSource.col] = null;
                            // calculate score and take the min Score
                            score = minimax(board, depth-1, !maxPlayer);
                            minScore = min(minScore, score);
                            // undo the move
                            // move pieceSource to spotPieceSource
                            movePieceToSpot(board, pieceSource, spotPieceSource);
                            // move pieceDest to spotPieceDest
                            movePieceToSpot(board, pieceDest, spotPieceDest);
                        }
                    }
                }
            }
            return minScore;
        }
    }

    public Spot[] findBestMove(Board board){
        Spot[] sourceAndDest = {new Spot(-1,-1), new Spot(-1,-1)};
        int DEPTH = 1;
        Spot spotPieceSource;
        Spot spotPieceDest;
        Piece pieceSource;
        Piece pieceDest; // could be null
        Piece[][] positions = board.positions;
        int bestVal = -999999;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                pieceSource = positions[i][j];
                if(pieceSource!=null && pieceSource.isWhite){ // We are finding best move for the White
                    spotPieceSource = pieceSource.getCurrentSpot();
                    ArrayList<Spot> availableMoves = pieceSource.calculateAllPossibleMoves();
                    for(int k=0;k<availableMoves.size();k++){
                        spotPieceDest = availableMoves.get(k);
                        pieceDest = board.getPiece(spotPieceDest);
                        // make the move
                        // move pieceSource to spotPieceDest
                        movePieceToSpot(board, pieceSource, spotPieceDest);
                        // make spotPieceSource null
                        board.positions[spotPieceSource.row][spotPieceSource.col] = null;
                        // calculate moveVal and take the bestVal
                        int moveVal = minimax(board, DEPTH, false);
                        if(moveVal > bestVal){
                            sourceAndDest[0].row = i;
                            sourceAndDest[0].col = j;
                            sourceAndDest[1] = new Spot(spotPieceDest.row, spotPieceDest.col);
                            bestVal = moveVal;
                        }
                        // undo the move
                        // move pieceSource to spotPieceSource
                        movePieceToSpot(board, pieceSource, spotPieceSource);
                        // move pieceDest to spotPieceDest
                        movePieceToSpot(board, pieceDest, spotPieceDest);
                    }
                }
            }
        }
        return sourceAndDest;
    }
    public void movePieceToSpot(Board board, Piece piece, Spot spot){
        int row = spot.row;
        int col = spot.col;
        board.positions[row][col] = piece;
    }


    public int evaluate(Board board){ // this can evaluate any board not just current game board
        // need to calculate checkmate score
        // if white wins score should be greater than 10000 or must be changed in minimax method
        // if white loses score should be less than -10000 or must be changed in minimax method
        if (board.getWinner().equals("white")){
            return 10000;
        }
        if (board.getWinner().equals("black")){
            return -10000;
        }
        int score = 0;
        Piece[][] positions = board.positions;
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                if(positions[i][j] != null)
                    score += positions[i][j].getValue();
        return score;
    }
}
