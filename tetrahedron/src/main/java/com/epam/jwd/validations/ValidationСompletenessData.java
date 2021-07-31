package com.epam.jwd.validations;

import com.epam.jwd.TetrahedronException;
import com.epam.jwd.entity.Tetrahedron;

public class ValidationСompletenessData {

    public static boolean isCompletenessData(String[] dotsData) throws TetrahedronException {
        if (dotsData.length < 3 & dotsData.length > 3){
            throw new TetrahedronException();
        }
        return true;
    }
}
