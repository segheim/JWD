package com.epam.jwd.tetrahedron.action;

import com.epam.jwd.tetrahedron.entity.Tetrahedron;

import java.util.Map;

public class VolumeTetrahedron {

    public double calculateVolumeTetrahedron(Tetrahedron tetrahedron){
        LengthsSidesTetrahedron lengthsSidesTetrahedron = new LengthsSidesTetrahedron();
        Map<String, Double> lengthsSides = lengthsSidesTetrahedron.calculateLengthsSidesTetrahedron(tetrahedron);

        return (lengthsSides.get("a") * lengthsSides.get("b") * lengthsSides.get("h")) / 6;
    }
}
