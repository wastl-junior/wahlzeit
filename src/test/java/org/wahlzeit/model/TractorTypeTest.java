package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

public class TractorTypeTest {

    @Test
    public void testConstructor(){
        String brand = "Deutz";
        String modelName = "Agroplus 110";
        int horsepower = 110;
        boolean allWheelDrive = true;

        TractorType tractorType = new TractorType(horsepower, brand, modelName);

        Assert.assertEquals(tractorType.getHorsepower(), horsepower);
        Assert.assertEquals(tractorType.getBrand(), brand);
        Assert.assertEquals(tractorType.getModelName(), modelName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFail(){
        new TractorType(0, null, null);
    }
}
