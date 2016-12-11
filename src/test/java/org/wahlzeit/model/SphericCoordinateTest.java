package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SphericCoordinateTest extends CoordinateTest {

    @Before
    public void setupCoordinates (){
        northPole = new SphericCoordinate(90, 0, EARTH_RADIUS);
        southPole = new SphericCoordinate(-90, 0, EARTH_RADIUS);

        equatorPoint1 = new SphericCoordinate(0, 0, EARTH_RADIUS);
        equatorPoint2 = new SphericCoordinate(0, 90, EARTH_RADIUS);
        equatorPoint3 =  new SphericCoordinate(0, 180, EARTH_RADIUS);
        equatorPoint4 =  new SphericCoordinate(0, -90, EARTH_RADIUS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFailRadius(){
        new SphericCoordinate(0,0,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFailLatitude(){
        new SphericCoordinate(91,0,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFailLongitude(){
        new SphericCoordinate(0,-181,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFailNegInf(){
        new SphericCoordinate(Double.NEGATIVE_INFINITY,0,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFailPosInf(){
        new SphericCoordinate(0,Double.POSITIVE_INFINITY,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFailNegNan(){
        new SphericCoordinate(0,0,Double.NaN);
    }

    @Test
    public void testConstructor(){
        for(int i = 0; i < 5; i++){
            double longitude = Math.random();
            double latitude = Math.random();
            double radius = Math.random();

            SphericCoordinate sphericCoordinate = new SphericCoordinate(latitude, longitude, radius);

            assertEquals(latitude, sphericCoordinate.getLatitude(), delta);
            assertEquals(longitude, sphericCoordinate.getLongitude(), delta);
            assertEquals(radius, sphericCoordinate.getRadius(), delta);
        }
    }
}
