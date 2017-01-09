package org.wahlzeit.model;

/*
@PatternInstance(
    patternName = "Singleton"
    participants = {
        "Singleton"
    }
)
*/
public class TractorPhotoManager extends PhotoManager {
    static  {
        instance = new TractorPhotoManager();
    }
}
