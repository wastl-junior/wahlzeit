package org.wahlzeit.model;
import static org.wahlzeit.utils.AssertionUtil.assertNotNull;
import static org.wahlzeit.utils.AssertionUtil.assertValidDouble;

public abstract class AbstractCoordinate implements Coordinate{

    public static final double EPSILON_FOR_SAME_POINT = 1e-10;

    @Override
    public double getDistance(Coordinate other) {
        assertNotNull(other);
        CartesianCoordinate otherAsCartesian = other.asCartesianCoordinate();
        CartesianCoordinate thisAsCartesian  = this.asCartesianCoordinate();

        double diffX = thisAsCartesian.getX() - otherAsCartesian.getX();
        double diffY = thisAsCartesian.getY() - otherAsCartesian.getY();
        double diffZ = thisAsCartesian.getZ() - otherAsCartesian.getZ();

        double result = Math.sqrt(diffX * diffX + diffY * diffY + diffZ * diffZ);
        assertValidDouble(result);
        return result;
    }

    @Override
    public boolean isEqual(Coordinate other){
        assertNotNull(other);
        return this.getDistance(other) < EPSILON_FOR_SAME_POINT;
    }

}
