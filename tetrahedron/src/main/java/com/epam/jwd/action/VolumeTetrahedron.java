package com.epam.jwd.action;

import com.epam.jwd.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class VolumeTetrahedron {

    private static final Logger LOG = LogManager.getLogger(VolumeTetrahedron.class.getName());

    public static double calculateVolumeTetrahedron(Tetrahedron tetrahedron){
        LengthsSidesTetrahedron lengthsSidesTetrahedron = new LengthsSidesTetrahedron();
        Map<String, Double> lengthsSides = lengthsSidesTetrahedron.calculateLengthsSidesTetrahedron(tetrahedron);
        double volumeTetrahedron = (lengthsSides.get("a") * lengthsSides.get("b") * lengthsSides.get("h")) / 6;
        LOG.info("Volume tetrahedron: {}", volumeTetrahedron);

        return volumeTetrahedron;
    }
}
