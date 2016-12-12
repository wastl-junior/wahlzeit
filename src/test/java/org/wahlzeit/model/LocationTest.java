package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * All test cases of the class {@link Location}.
 */
public class LocationTest {

    private SphericCoordinate coordinate;
    private Location location;

    @Before
    public void setUp(){
        coordinate = SphericCoordinate.createSphericCoordinate(0,0,0);
        location = new Location(coordinate);
    }

    @Test
    public void testConstructor(){
        Location location = new Location(coordinate);
        assertEquals(location.getCoordinate(), coordinate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFail(){
        new Location(null);
    }

    @Test
    public void testSetCoordinate(){
        SphericCoordinate other = SphericCoordinate.createSphericCoordinate(1,2,3);
        location.setCoordinate(other);
        assertEquals(location.getCoordinate(), other);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCoordinateFail(){
        location.setCoordinate(null);
    }
}
