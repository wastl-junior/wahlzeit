package org.wahlzeit.model;

import static org.wahlzeit.utils.AssertionUtil.assertNotNull;

public class Tractor {
    private TractorType type;

    // custom order features
    private boolean allWheelDrive;
    private boolean frontPTO;

    public Tractor(TractorType type, boolean allWheelDrive, boolean frontPTO){
        assertNotNull(type);
        this.type = type;
        this.allWheelDrive = allWheelDrive;
        this.frontPTO = frontPTO;
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
