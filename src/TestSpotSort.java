import Pieces.Spot;

import java.util.ArrayList;
import java.util.Collections;

public class TestSpotSort {
    public static void main(String[] args) {
        ArrayList<Spot> spotList1 = new ArrayList<>(){
            {
                add(new Spot(5,1));
                add(new Spot(5,0));
            }
        };
        ArrayList<Spot> spotList2 = new ArrayList<>(){
            {
                add(new Spot(5,0));
                add(new Spot(5,1));
            }
        };
        Collections.sort(spotList1);
        Collections.sort(spotList2);
        for(Spot spot:spotList1)
            System.out.println(spot.row+" "+spot.col);
        System.out.println("\n");
        for(Spot spot:spotList2)
            System.out.println(spot.row+" "+spot.col);

    }
}
