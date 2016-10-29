package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * All test cases of the class {@link Coordinate}.
 */
public class CoordinateTest {

    private static final double delta = 1e-10;

    private Coordinate northPole;
    private Coordinate southPole;
    private Coordinate equatorPoint1;
    private Coordinate equatorPoint2;
    private Coordinate equatorPoint3;
    private Coordinate equatorPoint4;

    /**
     * Help Method for checking getDistance in both orders to test whether getDistance is commutative
     * @param expectedDistance
     * @param cord1
     * @param cord2
     */
    private void assertEqualsBothOrders(double expectedDistance, Coordinate cord1, Coordinate cord2){
        assertEquals(expectedDistance, cord1.getDistance(cord2), delta);
        assertEquals(expectedDistance, cord2.getDistance(cord1), delta);
    }

    @Before
    public void setupSomeCoordinates (){
        northPole = new Coordinate(90, 0);
        southPole = new Coordinate(-90, 0);

        equatorPoint1 = new Coordinate(0, 0);
        equatorPoint2 = new Coordinate(0, 90);
        equatorPoint3 =  new Coordinate(0, 180);
        equatorPoint4 =  new Coordinate(0, 270);
    }

    @Test
    public void testGetDistanceSamePoint(){
        assertEqualsBothOrders(0, northPole, new Coordinate(-270, 100));
        assertEqualsBothOrders(0, southPole, new Coordinate(-450, 132));
        assertEqualsBothOrders(0, equatorPoint1, new Coordinate(360, -360));
    }

    @Test
    public void testGetDistance180Degree(){
        double halfEarthCircumference = Math.PI * Coordinate.EARTH_RADIUS;
        assertEqualsBothOrders(halfEarthCircumference, northPole, southPole);
        assertEqualsBothOrders(halfEarthCircumference, equatorPoint1, equatorPoint3);
        assertEqualsBothOrders(halfEarthCircumference, equatorPoint2, equatorPoint4);
    }

    @Test
    public void testGetDistance90Degree(){
        double quarterEarthCircumference = Math.PI * Coordinate.EARTH_RADIUS / 2;

        Coordinate[] equatorPoints = {equatorPoint1, equatorPoint2, equatorPoint3, equatorPoint4};

        // Test from poles to equator
        for(Coordinate ep : equatorPoints){
            assertEqualsBothOrders(quarterEarthCircumference, northPole, ep);
            assertEqualsBothOrders(quarterEarthCircumference, southPole, ep);
        }

        // Test neighboured equator points
        for(int current = 0; current < equatorPoints.length; current++){
            int previous = current - 1 ;
            if(previous < 0){
                previous = equatorPoints.length - 1;
            }

            int next = (current + 1) % equatorPoints.length;

            assertEqualsBothOrders(quarterEarthCircumference, equatorPoints[current], equatorPoints[next]);
            assertEqualsBothOrders(quarterEarthCircumference, equatorPoints[current], equatorPoints[previous]);
        }
    }
}
