package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Serialize;

@Serialize
public interface Coordinate {

    /**
     * Calculating direct distance between Coordinates
     * @param other: Coordinate
     * @return distance between this coordinate and given other as double value (representing kilometer)
     */
    double getDistance(Coordinate other);

    /**
     * Check wether this Coordinate is Equal to other:
     * means they represent the same point
     * @param other
     * @return
     */
    boolean isEqual(Coordinate other);

    /**
     * Converts generic Coordinate to cartesian one
     * @return cartesian representation of this coordinate
     */
    CartesianCoordinate asCartesianCoordinate();

    /**
     * Converts generic Coordinate to spheric one
     * @return spheric representation of this coordinate
     */
    SphericCoordinate asSphericCoordinate();
}
