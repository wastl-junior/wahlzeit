package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Subclass;

@Subclass
@Entity
public class TractorPhoto extends Photo {

    private int horsepower;

    private String brand;

    private String modelName;

    private boolean allWheelDrive;

    public TractorPhoto(){
        this(PhotoId.getNextId());
    }

    public TractorPhoto(PhotoId id){
        this(id, 0, "", "", false);
    }

    public TractorPhoto(PhotoId id, int horsepower, String brand, String modelName, boolean allWheelDrive){
        super(id);
        this.horsepower = horsepower;
        this.brand = brand;
        this.modelName = modelName;
        this.allWheelDrive = allWheelDrive;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        if(horsepower < 0){
            throw new IllegalArgumentException("Horsepower of a tractor must be a positive integer.");
        }
        this.horsepower = horsepower;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public boolean isAllWheelDrive() {
        return allWheelDrive;
    }

    public void setAllWheelDrive(boolean allWheelDrive) {
        this.allWheelDrive = allWheelDrive;
    }
}
