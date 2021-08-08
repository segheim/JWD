package com.epam.jwd.action;

import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.Tetrahedron;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class CheckerTetrahedron {

    private List<Dot> dots;
    private Tetrahedron tetrahedron;

    public CheckerTetrahedron(Tetrahedron tetrahedron){
        this.dots = tetrahedron.getVertexDots();
        this.tetrahedron = tetrahedron;
    }

    public boolean isTetrahedron() {
        if (isBaseParallelPlaneY() & isBaseTriangle() & isHeightParallelPlaneX()
                & isTetrahedronHaveHeight()) {
            return true;
        }
        return false;
    }

    public boolean isBaseTetrahedronOnCoordinatePlane() {
        BigDecimal dot1 = new BigDecimal(dots.get(0).getX());
        BigDecimal dot2 = new BigDecimal(dots.get(1).getX());
        BigDecimal dot3 = new BigDecimal(dots.get(2).getX());
        BigDecimal dot0 = new BigDecimal(0);

        return (dot1.compareTo(dot0) == 0) && (dot2.compareTo(dot0) == 0) && (dot3.compareTo(dot0) == 0);
    }

    public boolean isBaseParallelPlaneY() {

        return (dots.get(0).getX() == dots.get(1).getX()) &&
                (dots.get(0).getX() == dots.get(2).getX());
    }

    public boolean isHeightParallelPlaneX() {

        return dots.get(0).getY() == dots.get(3).getY();
    }

    public boolean isTetrahedronHaveHeight() {

        return dots.get(3).getX() > dots.get(0).getX();
    }

    public boolean isBaseTriangle() {

        LengthsSidesTetrahedron lengthsSidesTetrahedron = new LengthsSidesTetrahedron();
        Map<String, Double> lengthSides = lengthsSidesTetrahedron.calculateLengthsSidesTetrahedron(tetrahedron);
        if ((lengthSides.get("a") + lengthSides.get("b") > lengthSides.get("c")) ||
                (lengthSides.get("a") + lengthSides.get("c") > lengthSides.get("b")) ||
                        (lengthSides.get("b") + lengthSides.get("c") > lengthSides.get("a"))){
                    return true;
        }
        return false;
    }
}

