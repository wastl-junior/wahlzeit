package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * All test cases of the class {@link Location}.
 */
public class LocationTest {

    @Test
    public void testLocation(){
        Coordinate cord = new SphericCoordinate(0,0);
        Location lang = new Location(cord);
        assertEquals(lang.coordinate, cord);
    }
}
