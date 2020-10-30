package Pieces;

import java.util.Comparator;

public class Spot implements Comparable<Spot> {
    public int row, col;
    public Spot(int row, int col){
        this.row = row;
        this.col = col;
    }

//    use collections.sort(spotList) for testing availableMoves
    @Override
    public int compareTo(Spot spot) {
        if(this.row>spot.row)
            return 1;
        if(this.row<spot.row)
            return -1;
        return 0;
    }



//    delete this
//    @Override
//    public int compare(Spot spot1, Spot spot2) {
//        if(spot1.row<spot2.row)
//            return 1;
//        else if(spot1.row>spot2.row)
//            return -1;
//        return 0;
//    }
}
