package com.epam.jwd.additional;

import com.epam.jwd.TetrahedronException;
import com.epam.jwd.entity.Dot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreatorDotsFromFile {

    List dotsTetrahedron = new ArrayList<>();

    public List createDotsFromFile() throws IOException {

        ReaderFileWithDots readerFileWithDots = new ReaderFileWithDots();
        List<String> lines = readerFileWithDots.toReadFileWithDots();
        System.out.println(lines);
        for (String line : lines) {
            String[] dots = line.split(" ");
            System.out.println(Arrays.toString(dots));


                for (int i = 0; i < dots.length; i++) {
                    String[] dotCoordinates = dots[i].replace("(", " ").replace(",", " ").
                            replace(")", " ").replace(";", " ").trim().split(" ");
                    double x = Double.parseDouble(dotCoordinates[0]);
                    double y = Double.parseDouble(dotCoordinates[1]);
                    double z = Double.parseDouble(dotCoordinates[2]);
                    dotsTetrahedron.add(new Dot(x, y, z));
                    System.out.println(dots[i]);
                }



            System.out.println(dotsTetrahedron.toString());
        }

        return dotsTetrahedron;
    }
}
