package com.epam.jwd.validations;

public class ValidationNumberIsDouble {

    public static void isDoubleDotData(String[] dotData) {

        for (int i = 0; i < dotData.length; i++) {
            String[] dotCoordinates = dotData[i].replaceAll("[,;()]", " ").trim().split(" ");
            for (String dotCoordinate : dotCoordinates) {
                double checkDoubleDot = Double.parseDouble(dotCoordinate);
            }
        }
    }
}
