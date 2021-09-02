package com.epam.jwd.validations;

import com.epam.jwd.exception.TetrahedronException;
import com.epam.jwd.additional.CreatorDotsFromFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validation {
    private static final Logger LOG = LogManager.getLogger(CreatorDotsFromFile.class.getName());

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
                    LOG.error("In string invalid data!");
                    return false;
                }
            }
        }
        return true;
    }
}
