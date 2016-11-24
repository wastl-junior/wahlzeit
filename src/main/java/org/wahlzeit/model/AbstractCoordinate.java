package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate{

    /**
     * Calculating direct distance between Coordinates
     * @param other: Coordinate
     * @return distance between this coordinate and given other as double value (representing kilometer)
     */
    @Override
    public double getDistance(Coordinate other) {
        CartesianCoordinate otherAsCartesian = other.asCartesianCoordinate();
        CartesianCoordinate thisAsCartesian  = this.asCartesianCoordinate();

        double diffX = thisAsCartesian.getX() - otherAsCartesian.getX();
        double diffY = thisAsCartesian.getY() - otherAsCartesian.getY();
        double diffZ = thisAsCartesian.getZ() - otherAsCartesian.getZ();

        return Math.sqrt(diffX * diffX + diffY * diffY + diffZ * diffZ);
    }

}
