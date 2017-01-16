package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Subclass;

/*
@PatternInstance(
    patternName = "Abstract Factory"
    participants = {
        "AbstractFactory", "ConcreteFactory", "AbstractProduct", "ConcreteProduct"
    }
)
*/
@Subclass
@Entity
public class TractorPhoto extends Photo {

    private Tractor tractor;

    // Constructor is leaf in creation of TractorPhoto-Objects
    public TractorPhoto(){
        this(PhotoId.getNextId());
    }

    // Constructor is leaf in creation of TractorPhoto-Objects
    public TractorPhoto(PhotoId id){
        super(id);
    }

    // Constructor is leaf in creation of TractorPhoto-Objects
    public TractorPhoto(PhotoId id, Tractor tractor){
        super(id);
        this.tractor = tractor;
    }

    public Tractor getTractor(){
        return tractor;
    }
}
