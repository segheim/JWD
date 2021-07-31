package com.epam.jwd.action;

import com.epam.jwd.entity.Tetrahedron;

import java.util.Map;

public class SurfaceAreaTetrahedron {

    public double calculateSurfaceAreaTetrahedron(Tetrahedron tetrahedron){
        LengthsSidesTetrahedron lengthsSidesTetrahedron = new LengthsSidesTetrahedron();
        Map<String, Double> lengthsSides = lengthsSidesTetrahedron.calculateLengthsSidesTetrahedron(tetrahedron);
        double halfPerimeterABC = (lengthsSides.get("a") + lengthsSides.get("b") + lengthsSides.get("c"))/2;
        double surfaceAreaABC = Math.sqrt(halfPerimeterABC * (halfPerimeterABC - lengthsSides.get("a")) *
                (halfPerimeterABC - lengthsSides.get("b")) * (halfPerimeterABC - lengthsSides.get("c")));
        double halfPerimeterCDE = (lengthsSides.get("c") + lengthsSides.get("d") + lengthsSides.get("e"))/2;
        double surfaceAreaCDE = Math.sqrt(halfPerimeterCDE * (halfPerimeterCDE - lengthsSides.get("c")) *
                (halfPerimeterCDE - lengthsSides.get("d")) * (halfPerimeterCDE - lengthsSides.get("e")));
        double halfPerimeterHBD = (lengthsSides.get("h") + lengthsSides.get("b") + lengthsSides.get("d"))/2;
        double surfaceAreaHBD = Math.sqrt(halfPerimeterHBD * (halfPerimeterHBD - lengthsSides.get("c")) *
                (halfPerimeterHBD - lengthsSides.get("d")) * (halfPerimeterHBD - lengthsSides.get("e")));
        double halfPerimeterHAE = (lengthsSides.get("h") + lengthsSides.get("a") + lengthsSides.get("e"))/2;
        double surfaceAreaHAE = Math.sqrt(halfPerimeterHAE * (halfPerimeterHAE - lengthsSides.get("c")) *
                (halfPerimeterHAE - lengthsSides.get("d")) * (halfPerimeterHAE - lengthsSides.get("e")));

        return surfaceAreaABC + surfaceAreaCDE + surfaceAreaHAE + surfaceAreaHBD;
    }

}
