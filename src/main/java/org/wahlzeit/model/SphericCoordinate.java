package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate {

    private final double latitude;
    private final double longitude;

    /**
     * Creating a new SphericCoordinate from latitude and longitude
     * @param latitude: Latitude in degrees
     * @param longitude: Longitude in degrees
     */
    public SphericCoordinate(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public static SphericCoordinate convertToSpheric(Coordinate cord){
        if(cord instanceof SphericCoordinate){
            return (SphericCoordinate) cord;
        }
        else if (cord instanceof CartesianCoordiante){
            CartesianCoordiante cartesianCoordiante = (CartesianCoordiante) cord;
            double x = cartesianCoordiante.getX();
            double y = cartesianCoordiante.getY();
            double z = cartesianCoordiante.getZ();

            // Calculate latitude and longitude according to https://en.wikipedia.org/wiki/Spherical_coordinate_system#Cartesian_coordinates
            double latitude = Math.toDegrees(Math.atan2(z, Math.sqrt(x*x + y*y)));
            double longitude = Math.toDegrees(Math.atan2(y, x));

            return new SphericCoordinate(latitude, longitude);
        }

        throw new IllegalArgumentException("Given Coordinate implementation is not known and cannot be converted to SphericCoordinate.");
    }

    /**
     * Calculating distance between Coordinates
     * @param other: SphericCoordinate
     * @return distance between this coordinate and given other as double value
     */
    @Override
    public double getDistance(Coordinate other){
        SphericCoordinate sphericOther = convertToSpheric(other);

        // Convert angles from degree measure to radian measure
        // because trigonomic methods use angles in radians, see http://docs.oracle.com/javase/8/docs/api/index.html
        double latitudeRadian = Math.toRadians(getLatitude());
        double longitudeRadian = Math.toRadians(getLongitude());

        double latitudeRadianOther = Math.toRadians(sphericOther.getLatitude());
        double longitudeRadianOther = Math.toRadians(sphericOther.getLongitude());

        // use formula from wikipedia to calculate distance on surface, see https://en.wikipedia.org/wiki/Great-circle_distance
        double deltaSigma = Math.acos(
                Math.sin(latitudeRadian) * Math.sin(latitudeRadianOther)
                + Math.cos(latitudeRadian) * Math.cos(latitudeRadianOther) * Math.cos(Math.abs(longitudeRadian - longitudeRadianOther))
        );

        return EARTH_RADIUS * deltaSigma;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
