package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

public class TractorTest {

    @Test
    public void testConstructor(){
        TractorType tractorType = new TractorType(110, "Deutz", "Agroplus 110");
        boolean allWheelDrive = true;
        boolean frontPTO = true;

        Tractor tractor = new Tractor(tractorType, allWheelDrive, frontPTO);

        Assert.assertEquals(tractor.getType(), tractorType);
        Assert.assertEquals(tractor.hasAllWheelDrive(), allWheelDrive);
        Assert.assertEquals(tractor.hasFrontPTO(), frontPTO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFail(){
        new Tractor(null, false, false);
    }
}
