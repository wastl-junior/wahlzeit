package org.wahlzeit.model;
import static org.wahlzeit.utils.AssertionUtil.assertNotNull;

public class Location {
    private Coordinate coordinate;

    /**
     * Create Location with given Coordinate
     * @param cord: Coordinate where location is
     */
    public Location(Coordinate cord) {
        assertNotNull(cord);
        this.coordinate = cord;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        assertNotNull(coordinate);
        this.coordinate = coordinate;
    }
}
