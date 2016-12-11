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
    public void testDefaultConstructor(){
        // test whether default values are set properly
        TractorPhoto tractorPhoto = new TractorPhoto();
        Assert.assertFalse(tractorPhoto.isAllWheelDrive());
        Assert.assertEquals(tractorPhoto.getBrand(), null);
        Assert.assertEquals(tractorPhoto.getModelName(), null);
        Assert.assertEquals(tractorPhoto.getHorsepower(), 0);
    }

    @Test
    public void testConstructor(){
        // test whether default values are set properly
        PhotoId id = new PhotoId(1);
        String brand = "Deutz";
        String modelName = "Agroplus 110";
        int horsepower = 110;
        boolean allWheelDrive = true;

        TractorPhoto tractorPhoto = new TractorPhoto(id, horsepower, brand, modelName, allWheelDrive);

        Assert.assertEquals(tractorPhoto.getId(), id);
        Assert.assertEquals(tractorPhoto.getHorsepower(), horsepower);
        Assert.assertEquals(tractorPhoto.getBrand(), brand);
        Assert.assertEquals(tractorPhoto.getModelName(), modelName);
        Assert.assertEquals(tractorPhoto.isAllWheelDrive(), allWheelDrive);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFail(){
        // test whether default values are set properly
        TractorPhoto tractorPhoto = new TractorPhoto(null, 0, null, null, false);
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

    @Test(expected = IllegalArgumentException.class)
    public void testSetModelNameFail(){
        tractorPhoto.setModelName("");
    }

    @Test
    public void testSetBrand(){
        String newBrand = "Fendt";
        tractorPhoto.setBrand(newBrand);
        Assert.assertEquals(tractorPhoto.getBrand(), newBrand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetBrandFail(){
        tractorPhoto.setBrand(null);
    }

    @Test
    public void testSetAllWheelDrive(){
        boolean newAllWheelDrive = true;
        tractorPhoto.setAllWheelDrive(newAllWheelDrive);
        Assert.assertEquals(tractorPhoto.isAllWheelDrive(), newAllWheelDrive);
    }
}
