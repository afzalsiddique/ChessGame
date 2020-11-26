package BackEndLogic;

import java.util.ArrayList;

public class AI_Agent {
    Board board;

    public AI_Agent(Board board) {
        this.board = board;
    }
    public ArrayList<Spot> getAllAvailableMovesOfEveryPiece(){
        ArrayList<Spot> allMoves = new ArrayList<>();
        Piece[][] positions = board.positions;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if (positions[i][j] != null){
                    allMoves.addAll(positions[i][j].calculateAllPossibleMoves());
                }
            }
        }
        return allMoves;
    }
    public int evaluate(Piece[][] positions){ // if board.positions is passed, then it will evaluate current board
        int evaluation = 0;
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                if(positions[i][j] != null)
                    evaluation += positions[i][j].getValue();
        return evaluation;
    }
}
