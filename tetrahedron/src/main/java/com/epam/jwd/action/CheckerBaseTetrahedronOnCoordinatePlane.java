package com.epam.jwd.action;

import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.Tetrahedron;

import java.util.List;

public class CheckerBaseTetrahedronOnCoordinatePlane {

    public boolean isBaseTetrahedronOnCoordinatePlane(Tetrahedron tetrahedron){

        List<Dot> dots = tetrahedron.getVertexDots();

        return (((dots.get(0).getX() == 0) & (dots.get(1).getX() == 0) & (dots.get(2).getX() == 0))
                || ((dots.get(0).getY() == 0) & (dots.get(1).getY() == 0) & (dots.get(2).getY() == 0))
                || ((dots.get(0).getZ() == 0) & (dots.get(1).getZ() == 0) & (dots.get(2).getZ() == 0)));
    }
}
