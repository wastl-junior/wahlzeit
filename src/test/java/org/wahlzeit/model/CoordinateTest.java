package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * All test cases of the class {@link Coordinate}.
 */
public class CoordinateTest {

    private static final double delta = 0.00000001;

    @Test
    public void testGetDistanceSamePoint(){
        Coordinate cord1 = new Coordinate(0,0);
        Coordinate cord2 = new Coordinate(0,-720);

        assertEquals(0, cord1.getDistance(cord2), delta);
    }

    @Test
    public void testGetDistance180Degree(){
        Coordinate cord1 = new Coordinate(0,0);
        Coordinate cord2 = new Coordinate(0,180);

        assertEquals(Math.PI * Coordinate.EARTH_RADIUS, cord1.getDistance(cord2), delta);
    }
}
