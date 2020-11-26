import BackEndLogic.Spot;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

class TestSpotSort{
        @Test
        public void test1(){
            ArrayList<Spot> actual = new ArrayList<>(){
                {
                    add(new Spot(5,1));
                    add(new Spot(5,0));
                }
            };
            Collections.sort(actual);
            ArrayList<Spot> expected = new ArrayList<>(){
                {
                    add(new Spot(5,0));
                    add(new Spot(5,1));
                }
            };
            Assert.assertArrayEquals(expected.toArray(), actual.toArray());
        }

    @Test
    public void test2(){
        Spot spot = new Spot(1,5);
        String actual = spot.toString();
        String expected = "row: 1 col: 5";
        Assert.assertEquals(expected, actual);
    }
}