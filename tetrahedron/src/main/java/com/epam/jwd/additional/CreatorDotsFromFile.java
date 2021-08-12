package com.epam.jwd.additional;

import com.epam.jwd.exception.TetrahedronException;
import com.epam.jwd.entity.Dot;
import com.epam.jwd.validations.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CreatorDotsFromFile {

    private static final Logger LOG = LogManager.getLogger(CreatorDotsFromFile.class.getName());

    public List createDotsFromFile() throws IOException {

        List dotsTetrahedron = new ArrayList<>();
        ReaderFileWithDots readerFileWithDots = new ReaderFileWithDots();
        List<String> lines = readerFileWithDots.toReadFileWithDots();

        for (String line : lines) {
            List dotsForTetrahedron = new ArrayList<>();
            String[] dots = line.split(" ");
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
                LOG.error("In string is not enough information");

            }
            dotsTetrahedron = dotsForTetrahedron;
            LOG.info("Tetrahedron's dots: {}",dotsTetrahedron);
        }

        return dotsTetrahedron;
    }
}
