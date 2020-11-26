package BackEndLogic;

import java.util.ArrayList;

public class AI_Agent {
    Board board;

    public AI_Agent(Board board) {
        this.board = board;
    }
    public ArrayList<Spot> getAllAvailableMoves(){
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
}
