package Pieces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpotSorter {
    public static void main(String[] args) {
        List<Spot> myList = new ArrayList<>();
        myList.add(new Spot(2, 1));
        myList.add(new Spot(1, 2));
        myList.add(new Spot(0, 0));
        myList.add(new Spot(3, 3));
        myList.add(new Spot(3, 1));
        myList.add(new Spot(3, 2));
        Collections.sort(myList);
        for (Spot spot:myList) {
            System.out.println(spot.row+" "+spot.col);
        }
    }
}