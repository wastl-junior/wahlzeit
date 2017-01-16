package org.wahlzeit.model;
import static org.wahlzeit.utils.AssertionUtil.assertNotNull;

/*
@PatternInstance(
    patternName = "Abstract Factory"
    participants = {
        "AbstractFactory", "ConcreteFactory", "AbstractProduct", "ConcreteProduct"
    }
)
*/
public class TractorPhotoFactory extends PhotoFactory {

    static {
        instance = new TractorPhotoFactory();
    }

    /**
     * @methodtype factory
     */
    // creating a TractorPhoto using the constructor
    public Photo createPhoto() {
        return new TractorPhoto();
    }

    /**
     * Creates a new photo with the specified id
     */
    // creating a TractorPhoto using the constructor
    public Photo createPhoto(PhotoId id) {
        assertNotNull(id);
        return new TractorPhoto(id);
    }
}
