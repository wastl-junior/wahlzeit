package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class TractorPhotoFactoryTest {

    // Google API is required to instantiate Photo
    @ClassRule
    public static TestRule chain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());

    @Test
    public void testUseRightFactory() throws ClassNotFoundException {
        // Needed so the class is initialized correctly (only needed in test environment)
        // In production Environment done by @link org.wahlzeit.main.ModelMain#startUp
        Class.forName("org.wahlzeit.model.TractorPhotoFactory");
        Assert.assertTrue(PhotoFactory.getInstance() instanceof TractorPhotoFactory);
        Assert.assertTrue(PhotoFactory.getInstance().createPhoto() instanceof TractorPhoto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateFail() throws ClassNotFoundException {
        Class.forName("org.wahlzeit.model.TractorPhotoFactory");
        PhotoFactory.getInstance().createPhoto(null);
    }
}
