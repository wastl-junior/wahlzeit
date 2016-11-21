package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Serialize;

@Serialize
public interface Coordinate {
    double EARTH_RADIUS = 6371;

    double getDistance(Coordinate other);

    CartesianCoordiante asCartesianCoordinate();

    SphericCoordinate asSphericCoordinate();
}
