package com.epam.jwd.action;

import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.Tetrahedron;

import java.util.List;
import java.util.Map;

public class RatioVolumesCrossedByCoordinatePlane {

    public double calculateRatioVolumesCrossedByCoordinatePlane(Tetrahedron tetrahedron){

        LengthsSidesTetrahedron lengthsSidesTetrahedron = new LengthsSidesTetrahedron();
        Map<String, Double> sides = lengthsSidesTetrahedron.calculateLengthsSidesTetrahedron(tetrahedron);

        List<Dot> dots = tetrahedron.getVertexDots();
        if (dots.get(0).getX() < 0 & dots.get(1).getX() < 0 & dots.get(2).getX() < 0 & dots.get(3).getX() > 0){

        }

        return 0;
    }
}
