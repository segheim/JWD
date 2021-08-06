package com.epam.jwd.validations;

import com.epam.jwd.TetrahedronException;

public class Validation {
    public static boolean validateData(String[] dotsData) throws TetrahedronException {

        if(isCoordinatesDot(dotsData) && isDotsTetrahedron(dotsData) && isDoubleDotData(dotsData)){
            return true;
        }
        return false;
    }

    private static boolean isDotsTetrahedron(String[] dotsData) throws TetrahedronException {
        if (dotsData.length != 4) {
            throw new TetrahedronException();
        }
        return true;
    }

    private static boolean isCoordinatesDot(String[] dotsData) throws TetrahedronException {
        for (int i = 0; i < dotsData.length; i++) {
            String[] dotCoordinates = dotsData[i].replaceAll("[,;()]", " ").trim().split(" ");
            if (dotCoordinates.length != 3) {
                throw new TetrahedronException();
            }
        }
        return true;
    }

    private static boolean isDoubleDotData(String[] dotData) {

        for (int i = 0; i < dotData.length; i++) {
            String[] dotCoordinates = dotData[i].replaceAll("[,;()]", " ").trim().split(" ");
            for (String dotCoordinate : dotCoordinates) {
                try {
                    Double.parseDouble(dotCoordinate);
                }catch (NumberFormatException e){
                    System.err.println("In string invalid data!");
                    return false;
                }
            }
        }
        return true;
    }
}
