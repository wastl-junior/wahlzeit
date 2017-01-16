package org.wahlzeit.model;

import org.wahlzeit.services.ObjectManager;

import java.util.HashMap;

public class TractorManager extends ObjectManager {
    private static TractorManager instance = new TractorManager();

    private HashMap<Tractor, Tractor> tractorCache = new HashMap<>();
    private HashMap<TractorType, TractorType> tractorTypeCache = new HashMap<>();

    private TractorManager(){

    }

    public static TractorManager getInstance(){
        return instance;
    }

    public boolean hasTractor(Tractor tractor) {
        return tractorCache.containsKey(tractor);
    }

    public Tractor getTractor(Tractor tractor) {
        return tractorCache.get(tractor);
    }

    // creates Tractors and manages instances
    public synchronized Tractor createTractor(TractorType type, boolean allWheelDrive, boolean frontPTO){
        Tractor tractor = new Tractor(type, allWheelDrive, frontPTO);

        if(hasTractor(tractor)){
            return getTractor(tractor);
        }

        tractorCache.put(tractor, tractor);
        return tractor;
    }

    public boolean hasTractorType(TractorType tractorType) {
        return tractorTypeCache.containsKey(tractorType);
    }

    public TractorType getTractorType(TractorType tractorType) {
        return tractorTypeCache.get(tractorType);
    }

    public synchronized TractorType createTractorType(int horsepower, String brand, String modelName){
        TractorType tractorType = new TractorType(horsepower, brand, modelName);

        if(hasTractorType(tractorType)){
            return getTractorType(tractorType);
        }

        tractorTypeCache.put(tractorType, tractorType);
        return tractorType;
    }
}
