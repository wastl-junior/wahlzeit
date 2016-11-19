package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * All test cases of the class {@link Coordinate}.
 */
public abstract class CoordinateTest {

    protected static final double delta = 1e-10;

    protected Coordinate northPole;
    protected Coordinate southPole;
    protected Coordinate equatorPoint1;
    protected Coordinate equatorPoint2;
    protected Coordinate equatorPoint3;
    protected Coordinate equatorPoint4;

    @Before
    public abstract void setupCoordinates ();

    /**
     * Help Method for checking getDistance in both orders to test whether getDistance is commutative
     * @param expectedDistance
     * @param cord1
     * @param cord2
     */
    protected void assertEqualsBothOrders(double expectedDistance, Coordinate cord1, Coordinate cord2){
        assertEquals(expectedDistance, cord1.getDistance(cord2), delta);
        assertEquals(expectedDistance, cord2.getDistance(cord1), delta);
    }

    @Test
    public void testGetDistanceSamePoint(){
        assertEqualsBothOrders(0, northPole, new SphericCoordinate(-270, 100));
        assertEqualsBothOrders(0, southPole, new SphericCoordinate(-450, 132));
        assertEqualsBothOrders(0, equatorPoint1, new SphericCoordinate(360, -360));
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
