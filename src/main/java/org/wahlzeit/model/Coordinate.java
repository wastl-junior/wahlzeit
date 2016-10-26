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
        this.latitude = Math.toRadians(latitude);
        this.longitude = Math.toRadians(longitude);
    }

    public double getDistance(Coordinate other){
        double deltaSigma = Math.acos(
                Math.sin(this.latitude) * Math.sin(other.latitude)
                + Math.cos(this.latitude) * Math.cos(other.latitude) * Math.cos(Math.abs(this.longitude - other.longitude))
        );

        return EARTH_RADIUS * deltaSigma;
    }
}
