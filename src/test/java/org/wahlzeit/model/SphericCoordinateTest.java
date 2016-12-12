package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SphericCoordinateTest extends CoordinateTest {

    @Before
    public void setupCoordinates (){
        northPole = SphericCoordinate.createSphericCoordinate(90, 0, EARTH_RADIUS);
        southPole = SphericCoordinate.createSphericCoordinate(-90, 0, EARTH_RADIUS);

        equatorPoint1 = SphericCoordinate.createSphericCoordinate(0, 0, EARTH_RADIUS);
        equatorPoint2 = SphericCoordinate.createSphericCoordinate(0, 90, EARTH_RADIUS);
        equatorPoint3 =  SphericCoordinate.createSphericCoordinate(0, 180, EARTH_RADIUS);
        equatorPoint4 =  SphericCoordinate.createSphericCoordinate(0, -90, EARTH_RADIUS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFailRadius(){
        SphericCoordinate.createSphericCoordinate(0,0,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFailLatitude(){
        SphericCoordinate.createSphericCoordinate(91,0,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFailLongitude(){
        SphericCoordinate.createSphericCoordinate(0,-181,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFailNegInf(){
        SphericCoordinate.createSphericCoordinate(Double.NEGATIVE_INFINITY,0,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFailPosInf(){
        SphericCoordinate.createSphericCoordinate(0,Double.POSITIVE_INFINITY,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFailNegNan(){
        SphericCoordinate.createSphericCoordinate(0,0,Double.NaN);
    }

    @Test
    public void testSharing(){
        SphericCoordinate cord1 = SphericCoordinate.createSphericCoordinate(0,0,0);
        SphericCoordinate cord2 = SphericCoordinate.createSphericCoordinate(0,0,0);

        // NOTE not using AssertEquals because the reference must be checked here
        // and not wether the objects are equal
        assertTrue(cord1 == cord2);
    }

    @Test
    public void testConstructor(){
        for(int i = 0; i < 5; i++){
            double longitude = Math.random();
            double latitude = Math.random();
            double radius = Math.random();

            SphericCoordinate sphericCoordinate = SphericCoordinate.createSphericCoordinate(latitude, longitude, radius);

            assertEquals(latitude, sphericCoordinate.getLatitude(), delta);
            assertEquals(longitude, sphericCoordinate.getLongitude(), delta);
            assertEquals(radius, sphericCoordinate.getRadius(), delta);
        }
    }
}
