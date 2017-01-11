package org.wahlzeit.model;
import org.junit.*;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class TractorPhotoTest {

    // Google API is required to instantiate Photo
    @ClassRule
    public static TestRule chain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());

    @Test
    public void testConstructor(){
        PhotoId id = new PhotoId(1);
        Tractor tractor = new Tractor(new TractorType(110, "Deutz", "Agroplus 110"), false, false);

        TractorPhoto tractorPhoto = new TractorPhoto(id, tractor);
        Assert.assertEquals(tractorPhoto.getTractor(), tractor);
        Assert.assertEquals(tractorPhoto.getId(), id);
    }
}
