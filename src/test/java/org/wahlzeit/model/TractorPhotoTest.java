package org.wahlzeit.model;
import org.junit.*;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class TractorPhotoTest {

    // Google API is required to instantiate Photo
    @ClassRule
    public static TestRule chain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());

    private TractorPhoto tractorPhoto;

    @Before
    public void setUp(){
        tractorPhoto = new TractorPhoto();
    }

    @Test
    public void testConstructor(){
        // test whether default values are set properly
        TractorPhoto tractorPhoto = new TractorPhoto();
        Assert.assertFalse(tractorPhoto.isAllWheelDrive());
        Assert.assertEquals(tractorPhoto.getBrand(), "");
        Assert.assertEquals(tractorPhoto.getModelName(), "");
        Assert.assertEquals(tractorPhoto.getHorsepower(), 0);
    }

    @Test
    public void testSetHorsePower(){
        int newHorsePower = 250;
        tractorPhoto.setHorsepower(newHorsePower);
        Assert.assertEquals(tractorPhoto.getHorsepower(), newHorsePower);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHorsePowerException(){
        tractorPhoto.setHorsepower(-1);
    }

    @Test
    public void testSetModelName(){
        String newModelName = "Fendt";
        tractorPhoto.setModelName(newModelName);
        Assert.assertEquals(tractorPhoto.getModelName(), newModelName);
    }

    @Test
    public void testSetBrand(){
        String newBrand = "Fendt";
        tractorPhoto.setBrand(newBrand);
        Assert.assertEquals(tractorPhoto.getBrand(), newBrand);
    }

    @Test
    public void testSetAllWheelDrive(){
        boolean newAllWheelDrive = true;
        tractorPhoto.setAllWheelDrive(newAllWheelDrive);
        Assert.assertEquals(tractorPhoto.isAllWheelDrive(), newAllWheelDrive);
    }
}
