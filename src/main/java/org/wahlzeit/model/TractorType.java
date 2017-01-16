package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Serialize;
import com.googlecode.objectify.annotation.Subclass;

import static org.wahlzeit.utils.AssertionUtil.assertNonEmptyString;

@Subclass
public class TractorType {
    private int horsepower;
    private String brand;
    private String modelName;

    @Serialize
    TractorType superType;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TractorType that = (TractorType) o;

        if (horsepower != that.horsepower) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (modelName != null ? !modelName.equals(that.modelName) : that.modelName != null) return false;
        return superType != null ? superType.equals(that.superType) : that.superType == null;
    }

    @Override
    public int hashCode() {
        int result = horsepower;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (modelName != null ? modelName.hashCode() : 0);
        result = 31 * result + (superType != null ? superType.hashCode() : 0);
        return result;
    }


    public TractorType getSuperType() {
        return superType;
    }

    public void setSuperType(TractorType superType) {
        this.superType = superType;
    }

    public boolean isSubtype(TractorType type){
        TractorType curr = superType;
        while(curr != null){
            if(curr == type){
                return true;
            }
            curr = curr.getSuperType();
        }
        return false;
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
