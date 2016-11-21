package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CartesianCoordinateTest extends CoordinateTest {

    @Before
    public void setupCoordinates (){
        northPole = new CartesianCoordinate(0, 0, EARTH_RADIUS);
        southPole = new CartesianCoordinate(0, 0, -EARTH_RADIUS);

        equatorPoint1 = new CartesianCoordinate(EARTH_RADIUS, 0, 0);
        equatorPoint2 = new CartesianCoordinate(0, EARTH_RADIUS, 0);
        equatorPoint3 =  new CartesianCoordinate(-EARTH_RADIUS, 0, 0);
        equatorPoint4 =  new CartesianCoordinate(0, -EARTH_RADIUS, 0);
    }

    @Test
    public void testConstructor(){

        for(int i = 0; i < 5; i++) {
            double x = Math.random();
            double y = Math.random();
            double z = Math.random();

            CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(x, y, z);

            assertEquals(x, cartesianCoordinate.getX(), delta);
            assertEquals(y, cartesianCoordinate.getY(), delta);
            assertEquals(z, cartesianCoordinate.getZ(), delta);
        }
    }
}
