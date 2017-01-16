package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class TractorManagerTest {

    @ClassRule
    public static TestRule chain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());

    @Test
    public void testSingleton(){
        Assert.assertTrue(TractorManager.getInstance() == TractorManager.getInstance());
    }

    @Test
    public void testTractorTypeSharing(){
        TractorManager tm = TractorManager.getInstance();
        int hp = 110;
        String brand = "Fendt";
        String modelName = "Vario 310";

        TractorType type1 = tm.createTractorType(hp, brand, modelName);
        TractorType type2 = tm.createTractorType(hp, brand, modelName);

        Assert.assertTrue(type1 == type2);
    }

    @Test
    public void testTractorSharing(){
        TractorManager tm = TractorManager.getInstance();
        int hp = 110;
        String brand = "Fendt";
        String modelName = "Vario 310";
        TractorType type = tm.createTractorType(hp, brand, modelName);

        boolean frontPTO = false;
        boolean allWheelDrive = false;
        Tractor tractor1 = TractorManager.getInstance().createTractor(type, allWheelDrive, frontPTO);
        Tractor tractor2 = TractorManager.getInstance().createTractor(type, allWheelDrive, frontPTO);

        Assert.assertTrue(tractor1 == tractor2);
    }
}
