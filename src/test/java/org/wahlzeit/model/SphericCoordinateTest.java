package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

public class SphericCoordinateTest extends CoordinateTest {

    @Before
    public void setupCoordinates (){
        northPole = new SphericCoordinate(90, 0);
        southPole = new SphericCoordinate(-90, 0);

        equatorPoint1 = new SphericCoordinate(0, 0);
        equatorPoint2 = new SphericCoordinate(0, 90);
        equatorPoint3 =  new SphericCoordinate(0, 180);
        equatorPoint4 =  new SphericCoordinate(0, 270);
    }

    @Test
    public void testConvertToSpheric(){

        class ConversionAssumption {
            CartesianCoordiante cartesianCoordiante;
            SphericCoordinate sphericCoordinate;

            public ConversionAssumption(CartesianCoordiante cartesianCoordiante, SphericCoordinate sphericCoordinate){
                this.cartesianCoordiante = cartesianCoordiante;
                this.sphericCoordinate = sphericCoordinate;
            }
        }

        // Enter aassumptions here what cartesian coordinate should match spheric coordinate
        ConversionAssumption[] conversionAssumptions = new ConversionAssumption[]{
                new ConversionAssumption(
                        new CartesianCoordiante(0, 0, Coordinate.EARTH_RADIUS),
                        new SphericCoordinate(90,0)
                ),
                new ConversionAssumption(
                        new CartesianCoordiante(0, 0, -Coordinate.EARTH_RADIUS),
                        new SphericCoordinate(-90,0)
                ),
                new ConversionAssumption(
                        new CartesianCoordiante(0, Coordinate.EARTH_RADIUS, 0),
                        new SphericCoordinate(0,90)
                ),
                new ConversionAssumption(
                        new CartesianCoordiante(0, -Coordinate.EARTH_RADIUS, 0),
                        new SphericCoordinate(0,-90)
                ),
                new ConversionAssumption(
                        new CartesianCoordiante(Coordinate.EARTH_RADIUS, 0, 0),
                        new SphericCoordinate(0,0)
                ),
                new ConversionAssumption(
                        new CartesianCoordiante(-Coordinate.EARTH_RADIUS, 0, 0),
                        new SphericCoordinate(0,180)
                )
        };

        // Test aassumptions: Distance between coordinates must be zero
        for( ConversionAssumption conversionAssumption : conversionAssumptions){
            assertEqualsBothOrders(0, SphericCoordinate.convertToSpheric(conversionAssumption.cartesianCoordiante), conversionAssumption.sphericCoordinate);
        }
    }
}
