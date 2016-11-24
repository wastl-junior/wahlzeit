package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate{

    // Distances form earth center in kilometer
    private final double x;
    private final double y;
    private final double z;

    /**
     * Creating a new CartesianCoordinate from x, y and z
     * @param x: Distance on x-axis in kilometer
     * @param y: Distance on y-axis in kilometer
     * @param z: Distance on z-axis in kilometer
     */
    public CartesianCoordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        // Calculate latitude and longitude according to https://en.wikipedia.org/wiki/Spherical_coordinate_system#Cartesian_coordinates
        double radius = Math.sqrt(x*x + y*y + z*z);
        double latitude = Math.toDegrees(Math.atan2(z, Math.sqrt(x*x + y*y)));
        double longitude = Math.toDegrees(Math.atan2(y, x));

        return new SphericCoordinate(latitude, longitude, radius);
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
