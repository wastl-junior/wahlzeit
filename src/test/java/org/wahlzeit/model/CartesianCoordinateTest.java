package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CartesianCoordinateTest extends CoordinateTest {

    @Before
    public void setupCoordinates (){
        northPole = new CartesianCoordiante(0, 0, Coordinate.EARTH_RADIUS);
        southPole = new CartesianCoordiante(0, 0, -Coordinate.EARTH_RADIUS);

        equatorPoint1 = new CartesianCoordiante(Coordinate.EARTH_RADIUS, 0, 0);
        equatorPoint2 = new CartesianCoordiante(0, Coordinate.EARTH_RADIUS, 0);
        equatorPoint3 =  new CartesianCoordiante(-Coordinate.EARTH_RADIUS, 0, 0);
        equatorPoint4 =  new CartesianCoordiante(0, -Coordinate.EARTH_RADIUS, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFail(){
        new CartesianCoordiante(Coordinate.EARTH_RADIUS, Coordinate.EARTH_RADIUS, Coordinate.EARTH_RADIUS);
    }

    @Test
    public void testConstructor(){
        // Point at latitude 45°
        double x = 0;
        double y, z;
        y = z = Coordinate.EARTH_RADIUS * Math.sqrt(2) / 2;

        CartesianCoordiante cartesianCoordiante = new CartesianCoordiante(x, y, z);

        assertEquals(x, cartesianCoordiante.getX(), delta);
        assertEquals(y, cartesianCoordiante.getY(), delta);
        assertEquals(z, cartesianCoordiante.getZ(), delta);
    }
}
