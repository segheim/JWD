package com.epam.jwd.action;

import com.epam.jwd.additional.CalculatorDotsCrossedCoordinatePlane;
import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.Tetrahedron;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class RatioVolumesShapesCrossedByCoordinatePlane {

    private static final Logger LOG = LogManager.getLogger(RatioVolumesShapesCrossedByCoordinatePlane.class.getName());

    public double calculateRatioVolumesShapesCrossedByCoordinatePlane(Tetrahedron tetrahedron) {
        List<Dot> dots = tetrahedron.getVertexDots();
        double ratioVolumesShapesCrossedByCoordinatePlane = 0;
        if (dots.get(3).getX() > 0 & dots.get(0).getX() < 0) {
            ratioVolumesShapesCrossedByCoordinatePlane = crossedPlaneX(tetrahedron);
        }
        if (dots.get(1).getY() > 0 & dots.get(0).getY() < 0) {
            ratioVolumesShapesCrossedByCoordinatePlane = crossedPlaneY(tetrahedron);
        }
        if (dots.get(2).getZ() > 0 & dots.get(0).getZ() < 0) {
            ratioVolumesShapesCrossedByCoordinatePlane = crossedPlaneZ(tetrahedron);
        }
        LOG.info("Ratio volumes shapes, when crossed coordinate plane: {}", ratioVolumesShapesCrossedByCoordinatePlane);

        return ratioVolumesShapesCrossedByCoordinatePlane;
    }

    private double crossedPlaneX(Tetrahedron tetrahedron) {
        List<Dot> dots = tetrahedron.getVertexDots();

        Dot dotABaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneX(dots.get(3), dots.get(0));
        Dot dotBBaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneX(dots.get(3), dots.get(1));
        Dot dotCBaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneX(dots.get(3), dots.get(2));

        List<Dot> dotsTopTetrahedron = new ArrayList<>();

        dotsTopTetrahedron.add(dotABaseTetrahedron);
        dotsTopTetrahedron.add(dotBBaseTetrahedron);
        dotsTopTetrahedron.add(dotCBaseTetrahedron);
        dotsTopTetrahedron.add(dots.get(3));

        double ratioVolumesShapesCrossedByCoordinatePlaneX = ratioVolume(dotsTopTetrahedron, tetrahedron);

        return ratioVolumesShapesCrossedByCoordinatePlaneX;
    }

    private double ratioVolume(List<Dot> dots, Tetrahedron tetrahedron) {
        Tetrahedron topTetrahedron = new Tetrahedron(dots);
        VolumeTetrahedron volumeTetrahedron = new VolumeTetrahedron();
        double volumeTopTetrahedron = volumeTetrahedron.calculateVolumeTetrahedron(topTetrahedron);
        double volumeShape = Math.abs(volumeTetrahedron.calculateVolumeTetrahedron(tetrahedron) - volumeTopTetrahedron);
        double ratioVolume = volumeShape / volumeTopTetrahedron;

        return ratioVolume;
    }

    private double crossedPlaneY(Tetrahedron tetrahedron) {

        List<Dot> dots = tetrahedron.getVertexDots();

        Dot dotABaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneY(dots.get(1), dots.get(0));
        Dot dotCBaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneY(dots.get(1), dots.get(2));
        Dot dotDBaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneY(dots.get(1), dots.get(3));

        List<Dot> dotsTopTetrahedron = new ArrayList<>();

        dotsTopTetrahedron.add(dotABaseTetrahedron);
        dotsTopTetrahedron.add(dots.get(1));
        dotsTopTetrahedron.add(dotCBaseTetrahedron);
        dotsTopTetrahedron.add(dotDBaseTetrahedron);

        double ratioVolumesShapesCrossedByCoordinatePlaneY = ratioVolume(dotsTopTetrahedron, tetrahedron);

        return ratioVolumesShapesCrossedByCoordinatePlaneY;
    }

    private double crossedPlaneZ(Tetrahedron tetrahedron) {

        List<Dot> dots = tetrahedron.getVertexDots();

        Dot dotABaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneZ(dots.get(2), dots.get(0));
        Dot dotBBaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneZ(dots.get(2), dots.get(1));
        Dot dotDBaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneZ(dots.get(2), dots.get(3));

        List<Dot> dotsTopTetrahedron = new ArrayList<>();

        dotsTopTetrahedron.add(dotABaseTetrahedron);
        dotsTopTetrahedron.add(dotBBaseTetrahedron);
        dotsTopTetrahedron.add(dots.get(2));
        dotsTopTetrahedron.add(dotDBaseTetrahedron);

        double ratioVolumesShapesCrossedByCoordinatePlaneZ = ratioVolume(dotsTopTetrahedron, tetrahedron);

        return ratioVolumesShapesCrossedByCoordinatePlaneZ;
    }
}
