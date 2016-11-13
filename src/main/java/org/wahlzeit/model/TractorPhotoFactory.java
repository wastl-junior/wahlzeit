package org.wahlzeit.model;

public class TractorPhotoFactory extends PhotoFactory {

    static {
        instance = new TractorPhotoFactory();
    }

    /**
     * @methodtype factory
     */
    public Photo createPhoto() {
        return new TractorPhoto();
    }

    /**
     * Creates a new photo with the specified id
     */
    public Photo createPhoto(PhotoId id) {
        return new TractorPhoto(id);
    }
}
