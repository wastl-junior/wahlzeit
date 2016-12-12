package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartesianCoordinateTest extends CoordinateTest {

    @Before
    public void setupCoordinates (){
        northPole = CartesianCoordinate.createCartesianCoordinate(0, 0, EARTH_RADIUS);
        southPole = CartesianCoordinate.createCartesianCoordinate(0, 0, -EARTH_RADIUS);

        equatorPoint1 = CartesianCoordinate.createCartesianCoordinate(EARTH_RADIUS, 0, 0);
        equatorPoint2 = CartesianCoordinate.createCartesianCoordinate(0, EARTH_RADIUS, 0);
        equatorPoint3 = CartesianCoordinate.createCartesianCoordinate(-EARTH_RADIUS, 0, 0);
        equatorPoint4 = CartesianCoordinate.createCartesianCoordinate(0, -EARTH_RADIUS, 0);
    }

    @Test
    public void testConstructor(){

        for(int i = 0; i < 5; i++) {
            double x = Math.random();
            double y = Math.random();
            double z = Math.random();

            CartesianCoordinate cartesianCoordinate = CartesianCoordinate.createCartesianCoordinate(x, y, z);

            assertEquals(x, cartesianCoordinate.getX(), delta);
            assertEquals(y, cartesianCoordinate.getY(), delta);
            assertEquals(z, cartesianCoordinate.getZ(), delta);
        }
    }


    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFailNegInf(){
        CartesianCoordinate.createCartesianCoordinate(Double.NEGATIVE_INFINITY,0,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFailPosInf(){
        CartesianCoordinate.createCartesianCoordinate(0,Double.POSITIVE_INFINITY,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFailNegNan(){
        CartesianCoordinate.createCartesianCoordinate(0,0,Double.NaN);
    }

    @Test
    public void testSharing(){
        CartesianCoordinate cord1 = CartesianCoordinate.createCartesianCoordinate(0,0,0);
        CartesianCoordinate cord2 = CartesianCoordinate.createCartesianCoordinate(0,0,0);

        // NOTE not using AssertEquals because the reference must be checked here
        // and not wether the objects are equal
        assertTrue(cord1 == cord2);
    }
}
