package org.wahlzeit.model;

import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonTypeInfo;
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

    @Test
    public void testIsSubType(){
        TractorType tractorType = new TractorType(2, "a", "b");
        TractorType tractorSuperType = new TractorType(3, "c", "d");
        TractorType tractorSuperType2 = new TractorType(3, "c", "d");

        Assert.assertEquals(tractorType.isSubtype(tractorSuperType), false);
        tractorType.setSuperType(tractorSuperType);
        Assert.assertEquals(tractorType.isSubtype(tractorSuperType), true);
        Assert.assertEquals(tractorType.isSubtype(tractorSuperType2), false);
        tractorSuperType.setSuperType(tractorSuperType2);
        Assert.assertEquals(tractorType.isSubtype(tractorSuperType2), true);
    }
}
