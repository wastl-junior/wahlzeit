package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

import static org.wahlzeit.utils.AssertionUtil.assertNotNull;

@Subclass
public class Tractor {
    private TractorType type;

    // custom order features
    private boolean allWheelDrive;
    private boolean frontPTO;

    // Constructor is leaf in creation of Tractor-Objects
    public Tractor(TractorType type, boolean allWheelDrive, boolean frontPTO){
        assertNotNull(type);
        this.type = type;
        this.allWheelDrive = allWheelDrive;
        this.frontPTO = frontPTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tractor tractor = (Tractor) o;

        if (allWheelDrive != tractor.allWheelDrive) return false;
        if (frontPTO != tractor.frontPTO) return false;
        return type != null ? type.equals(tractor.type) : tractor.type == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (allWheelDrive ? 1 : 0);
        result = 31 * result + (frontPTO ? 1 : 0);
        return result;
    }

    public TractorType getType() {
        return type;
    }

    public boolean hasAllWheelDrive() {
        return allWheelDrive;
    }

    public boolean hasFrontPTO() {
        return frontPTO;
    }
}
