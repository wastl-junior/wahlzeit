package org.wahlzeit.model;

/**
 * Created by markus on 26.10.2016.
 */
public class Coordinate {

    public static final double EARTH_RADIUS = 6371;

    private final double latitude;
    private final double longitude;

    /**
     * Creating a new Coordinate from latitude and longitude
     * @param latitude: Latitude in degrees
     * @param longitude: Longitude in degrees
     */
    public Coordinate(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }


    /**
     * Calculating distance between Coordinates
     * @param other: Coordinate
     * @return distance between this coordinate and given other as double value
     */
    public double getDistance(Coordinate other){
        // Convert angles from degree measure to radian measure
        // because trigonomic methods use angles in radians, see http://docs.oracle.com/javase/8/docs/api/index.html
        double latitudeRadian = Math.toRadians(latitude);
        double longitudeRadian = Math.toRadians(longitude);

        double latitudeRadianOther = Math.toRadians(other.latitude);
        double longitudeRadianOther = Math.toRadians(other.longitude);

        // use formula from wikipedia to calculate distance on surface, see https://en.wikipedia.org/wiki/Great-circle_distance
        double deltaSigma = Math.acos(
                Math.sin(latitudeRadian) * Math.sin(latitudeRadianOther)
                + Math.cos(latitudeRadian) * Math.cos(latitudeRadianOther) * Math.cos(Math.abs(longitudeRadian - longitudeRadianOther))
        );

        return EARTH_RADIUS * deltaSigma;
    }
}
