package org.wahlzeit.model;

import static org.wahlzeit.utils.AssertionUtil.assertNonEmptyString;

public class TractorType {
    private int horsepower;
    private String brand;
    private String modelName;

    public TractorType(int horsepower, String brand, String modelName) {
        assertNonEmptyString(brand);
        assertNonEmptyString(modelName);
        if(horsepower < 0){
            throw new IllegalArgumentException("Horsepower of a tractor must be a positive integer.");
        }
        this.horsepower = horsepower;
        this.brand = brand;
        this.modelName = modelName;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModelName() {
        return modelName;
    }
}
