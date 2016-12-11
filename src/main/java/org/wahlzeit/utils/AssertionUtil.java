package org.wahlzeit.utils;

public class AssertionUtil {

    public static final void assertNotNull(Object obj){
        if(obj == null){
            throw new IllegalArgumentException("Given object must not be null");
        }
    }

    public static final void assertNonEmptyString(Object string){
        if(StringUtil.isNullOrEmptyString(string)){
            throw new IllegalArgumentException("Given string must not be null or empty.");
        }
    }
}
