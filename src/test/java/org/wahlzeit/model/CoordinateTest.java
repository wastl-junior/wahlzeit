package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * All test cases of the class {@link Coordinate}.
 */
public abstract class CoordinateTest {


    protected static final double EARTH_RADIUS = 6371;

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
        assertEqualsBothOrders(0, northPole, new SphericCoordinate(-270, 100, EARTH_RADIUS));
        assertEqualsBothOrders(0, southPole, new SphericCoordinate(-450, 132, EARTH_RADIUS));
        assertEqualsBothOrders(0, equatorPoint1, new SphericCoordinate(360, -360, EARTH_RADIUS));
    }

    @Test
    public void testIsEqual(){
        // Test exact same points
        assertTrue(northPole.isEqual(northPole));
        assertTrue(equatorPoint1.isEqual(equatorPoint1));

        // Test same points in different format / different Object
        assertTrue(equatorPoint1.isEqual(new SphericCoordinate(0, 0, EARTH_RADIUS)));
        assertTrue(equatorPoint1.isEqual(new CartesianCoordinate(EARTH_RADIUS, 0, 0)));

        // Test different points
        assertFalse(northPole.isEqual(southPole));
        assertFalse(northPole.isEqual(equatorPoint1));
    }

    @Test
    public void testGetDistance180Degree(){
        // Distance is now direct, through the earth
        double expectedDistance = 2 * EARTH_RADIUS;

        assertEqualsBothOrders(expectedDistance, northPole, southPole);
        assertEqualsBothOrders(expectedDistance, equatorPoint1, equatorPoint3);
        assertEqualsBothOrders(expectedDistance, equatorPoint2, equatorPoint4);
    }

    @Test
    public void testGetDistance90Degree(){
        // Distance is now direct, through the earth
        double expectedDistance = Math.sqrt(2 * EARTH_RADIUS * EARTH_RADIUS);

        Coordinate[] equatorPoints = {equatorPoint1, equatorPoint2, equatorPoint3, equatorPoint4};

        // Test from poles to equator
        for(Coordinate ep : equatorPoints){
            assertEqualsBothOrders(expectedDistance, northPole, ep);
            assertEqualsBothOrders(expectedDistance, southPole, ep);
        }

        // Test neighboured equator points
        for(int current = 0; current < equatorPoints.length; current++){
            int previous = current - 1 ;
            if(previous < 0){
                previous = equatorPoints.length - 1;
            }

            int next = (current + 1) % equatorPoints.length;

            assertEqualsBothOrders(expectedDistance, equatorPoints[current], equatorPoints[next]);
            assertEqualsBothOrders(expectedDistance, equatorPoints[current], equatorPoints[previous]);
        }
    }


    @Test
    public void testConverters(){

        class ConversionAssumption {
            private CartesianCoordinate cartesianCoordinate;
            private SphericCoordinate sphericCoordinate;

            public ConversionAssumption(CartesianCoordinate cartesianCoordinate, SphericCoordinate sphericCoordinate){
                this.cartesianCoordinate = cartesianCoordinate;
                this.sphericCoordinate = sphericCoordinate;
            }
        }

        // Enter aassumptions here what cartesian coordinate should match spheric coordinate
        ConversionAssumption[] conversionAssumptions = new ConversionAssumption[]{
                new ConversionAssumption(
                        new CartesianCoordinate(0, 0, EARTH_RADIUS),
                        new SphericCoordinate(90,0, EARTH_RADIUS)
                ),
                new ConversionAssumption(
                        new CartesianCoordinate(0, 0, -EARTH_RADIUS),
                        new SphericCoordinate(-90,0, EARTH_RADIUS)
                ),
                new ConversionAssumption(
                        new CartesianCoordinate(0, EARTH_RADIUS, 0),
                        new SphericCoordinate(0,90, EARTH_RADIUS)
                ),
                new ConversionAssumption(
                        new CartesianCoordinate(0, -EARTH_RADIUS, 0),
                        new SphericCoordinate(0,-90, EARTH_RADIUS)
                ),
                new ConversionAssumption(
                        new CartesianCoordinate(EARTH_RADIUS, 0, 0),
                        new SphericCoordinate(0,0, EARTH_RADIUS)
                ),
                new ConversionAssumption(
                        new CartesianCoordinate(-EARTH_RADIUS, 0, 0),
                        new SphericCoordinate(0,180, EARTH_RADIUS)
                )
        };

        // Test aassumptions: Distance between coordinates must be zero
        for( ConversionAssumption conversionAssumption : conversionAssumptions){
            // Test if exact same point
            assertEqualsBothOrders(0, conversionAssumption.cartesianCoordinate, conversionAssumption.cartesianCoordinate);
            assertEqualsBothOrders(0, conversionAssumption.sphericCoordinate, conversionAssumption.sphericCoordinate);

            // Test same point in other format
            assertEqualsBothOrders(0, conversionAssumption.cartesianCoordinate, conversionAssumption.sphericCoordinate);

            // Test same points with use of converters
            assertEqualsBothOrders(0, conversionAssumption.cartesianCoordinate.asSphericCoordinate(), conversionAssumption.sphericCoordinate.asSphericCoordinate());
            assertEqualsBothOrders(0, conversionAssumption.cartesianCoordinate.asCartesianCoordinate(), conversionAssumption.sphericCoordinate.asCartesianCoordinate());
        }
    }
}
