package com.epam.jwd.validations;

import com.epam.jwd.TetrahedronException;

public class ValidationСompletenessData {

    public static boolean isCompletenessDataForDotsTetrahedron(String[] dotsData) throws TetrahedronException {
        if (dotsData.length != 4) {
            throw new TetrahedronException();
        }
        return true;
    }

    public static boolean isCompletenessDataForCoordinatesDot(String[] dotsData) throws TetrahedronException {
        for (int i = 0; i < dotsData.length; i++) {
            String[] dotCoordinates = dotsData[i].replaceAll("[,;()]", " ").trim().split(" ");
            if (dotCoordinates.length != 3) {
                throw new TetrahedronException();
            }
        }
        return true;
    }
}
