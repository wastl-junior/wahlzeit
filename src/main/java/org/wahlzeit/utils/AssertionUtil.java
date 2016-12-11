package org.wahlzeit.utils;

import javax.xml.crypto.dom.DOMCryptoContext;

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

    public static final void assertValidDouble(double val){
        if(Double.isNaN(val)){
            throw new IllegalArgumentException("Given double is NaN");
        }
        if(Double.isInfinite(val)){
            throw new IllegalArgumentException("Given double is not finite");
        }
    }
}
