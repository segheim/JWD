package com.epam.jwd.action;

import com.epam.jwd.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class SurfaceAreaTetrahedron {
    private static final Logger LOG = LogManager.getLogger(SurfaceAreaTetrahedron.class.getName());


    public static double calculateSurfaceAreaTetrahedron(Tetrahedron tetrahedron){
        LengthsSidesTetrahedron lengthsSidesTetrahedron = new LengthsSidesTetrahedron();
        Map<String, Double> lengthsSides = lengthsSidesTetrahedron.calculateLengthsSidesTetrahedron(tetrahedron);

        double halfPerimeterABC = calculateHalfPerimeter(lengthsSides.get("a"), lengthsSides.get("b"),
                lengthsSides.get("c"));
        double surfaceAreaABC = calculateSurface(halfPerimeterABC, lengthsSides.get("a"), lengthsSides.get("b"),
                lengthsSides.get("c"));

        double halfPerimeterCDE = calculateHalfPerimeter(lengthsSides.get("c"), lengthsSides.get("d"),
                lengthsSides.get("e"));
        double surfaceAreaCDE = calculateSurface(halfPerimeterCDE, lengthsSides.get("c"), lengthsSides.get("d"),
                lengthsSides.get("e"));

        double halfPerimeterHBD = calculateHalfPerimeter(lengthsSides.get("h"), lengthsSides.get("b"), lengthsSides.get("d"));
        double surfaceAreaHBD = calculateSurface(halfPerimeterHBD, lengthsSides.get("h"), lengthsSides.get("b"),
                lengthsSides.get("d"));

        double halfPerimeterHAE = calculateHalfPerimeter(lengthsSides.get("h"), lengthsSides.get("a"),
                lengthsSides.get("e"));
        double surfaceAreaHAE = calculateSurface(halfPerimeterHAE, lengthsSides.get("h"),lengthsSides.get("a"),
                lengthsSides.get("e"));
        double surfaceArea = surfaceAreaABC + surfaceAreaCDE + surfaceAreaHAE + surfaceAreaHBD;
        LOG.info("Surface area tetrahedron: {}", surfaceArea);

        return surfaceArea;
    }

    private static double calculateHalfPerimeter(double side1, double side2, double side3){
        return (side1 + side2 + side3) / 2;
    }

    private static double calculateSurface(double halfPerimeter, double side1, double side2, double side3){
        return Math.sqrt(halfPerimeter * (halfPerimeter - side1) * (halfPerimeter - side2) *
                (halfPerimeter - side3));
    }

}
