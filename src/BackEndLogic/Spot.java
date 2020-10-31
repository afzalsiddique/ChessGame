package BackEndLogic;

import java.util.Objects;

public class Spot implements Comparable<Spot> {
    public int row, col;

    public Spot(){};

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
        else{
            if(this.col>spot.col)
                return 1;
            if(this.col<spot.col)
                return -1;
        return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spot spot = (Spot) o;
        return row == spot.row &&
                col == spot.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
