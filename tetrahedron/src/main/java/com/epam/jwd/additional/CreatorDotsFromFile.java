package com.epam.jwd.additional;

import com.epam.jwd.TetrahedronException;
import com.epam.jwd.entity.Dot;
import com.epam.jwd.validations.Validation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreatorDotsFromFile {

    public List createDotsFromFile() throws IOException {

        List dotsTetrahedron = new ArrayList<>();
        ReaderFileWithDots readerFileWithDots = new ReaderFileWithDots();
        List<String> lines = readerFileWithDots.toReadFileWithDots();

        for (String line : lines) {
            List dotsForTetrahedron = new ArrayList<>();
            String[] dots = line.split(" ");
            System.out.println(Arrays.toString(dots));
            try {
                if(Validation.validateData(dots)){
                    for (int i = 0; i < dots.length; i++) {
                        String[] dotCoordinates = dots[i].replaceAll("[,;()]", " ").trim().split(" ");
                        double x = Double.parseDouble(dotCoordinates[0]);
                        double y = Double.parseDouble(dotCoordinates[1]);
                        double z = Double.parseDouble(dotCoordinates[2]);
                        dotsForTetrahedron.add(new Dot(x, y, z));
                    }
                }
            } catch (TetrahedronException e) {
                System.err.println("In string is not enough information!");
            }
            dotsTetrahedron = dotsForTetrahedron;
            System.out.println(dotsTetrahedron);
        }

        return dotsTetrahedron;
    }
}
