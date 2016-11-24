package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {

    private final double latitude;
    private final double longitude;
    private final double radius;

    /**
     * Creating a new SphericCoordinate from latitude and longitude
     * @param latitude : Latitude in degrees
     * @param longitude : Longitude in degrees
     * @param radius: Radius in kilometer
     */
    public SphericCoordinate(double latitude, double longitude, double radius){
        if(radius < 0){
            throw new IllegalArgumentException("No negative radius allowed for SphericCoordinate.");
        }
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }


    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        double latitudeRadian = Math.toRadians(getLatitude());
        double longitudeRadian = Math.toRadians(getLongitude());

        double x = radius * Math.cos(latitudeRadian) * Math.cos(longitudeRadian);
        double y = radius * Math.cos(latitudeRadian) * Math.sin(longitudeRadian);
        double z = radius * Math.sin(latitudeRadian);

        return new CartesianCoordinate(x, y, z);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getRadius(){
        return radius;
    }
}
