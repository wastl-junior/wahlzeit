package org.wahlzeit.model;

public class CartesianCoordiante implements Coordinate{

    // Distances form earth center in kilometer
    private final double x;
    private final double y;
    private final double z;

    /**
     * Create new CartesianCoordiante
     * Origin of the cartesian coordinate system is the center of the earth.
     * The x-axis goes through the Greenwich-Meridian
     * the y-axis goes from west to east
     * The z-axis goes from south to north pole
     * The given Position must be on earth surface, otherwise this Class would not be exchangeable by {@link SphericCoordinate}
     * @param x: Distance form earth center on x-axis in kilometer
     * @param y: Distance form earth center on y-axis in kilometer
     * @param z: Distance form earth center on z-axis in kilometer
     */
    public CartesianCoordiante(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;

        // check whether given point lays on earth surface
        double radius = Math.sqrt(x*x + y*y + z*z);

        if(Math.abs(radius - Coordinate.EARTH_RADIUS) > 1e-9){
            throw new IllegalArgumentException("Given CartesianCoordiante is not on earth surface.");
        }
    }

    @Override
    public double getDistance(Coordinate other) {
        return SphericCoordinate.convertToSpheric(this).getDistance(other);
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
