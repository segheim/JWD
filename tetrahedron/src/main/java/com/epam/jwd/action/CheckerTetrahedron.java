package com.epam.jwd.action;

import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.Tetrahedron;

import java.util.List;
import java.util.Map;

public class CheckerTetrahedron {

    private List<Dot> dots;
    private Tetrahedron tetrahedron;

    public CheckerTetrahedron(Tetrahedron tetrahedron){
        this.dots = tetrahedron.getVertexDots();
        this.tetrahedron = tetrahedron;
    }

    public boolean isTetrahedron(){
        if (isBaseParallelPlaneY() & isBaseTriangle() & isHeightParallelPlaneX()
                & isTetrahedronHaveHeight()) {
            return true;
        }

        return false;
    }

    public boolean isBaseTetrahedronOnCoordinatePlane(){

        return ((dots.get(0).getX() == 0) && (dots.get(1).getX() == 0) && (dots.get(2).getX() == 0));
    }

    private boolean isBaseParallelPlaneY() {

        return (dots.get(0).getX() == dots.get(1).getX()) &
                (dots.get(0).getX() == dots.get(2).getX());
    }

    private boolean isHeightParallelPlaneX() {

        return dots.get(0).getY() == dots.get(3).getY();
    }

    private boolean isTetrahedronHaveHeight() {

        return dots.get(3).getX() > dots.get(0).getX();
    }

    private boolean isBaseTriangle() {

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

