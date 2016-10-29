package org.wahlzeit.model;

public class Location {
    public Coordinate coordinate;

    /**
     * Create Location with given Coordinate
     * @param cord: Coordinate where location is
     */
    public Location(Coordinate cord) {
        this.coordinate = cord;
    }
}
