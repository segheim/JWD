package com.epam.jwd.action;

import com.epam.jwd.additional.CalculatorDotsCrossedCoordinatePlane;
import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.Tetrahedron;

import java.util.ArrayList;
import java.util.List;

public class RatioVolumesShapesCrossedByCoordinatePlane {

    public static double calculateRatioVolumesShapesCrossedByCoordinatePlane(Tetrahedron tetrahedron){
        List<Dot> dots = tetrahedron.getVertexDots();
        double ratioVolumesShapesCrossedByCoordinatePlane = 0;
        if (dots.get(3).getX() > 0 & dots.get(0).getX() < 0) {
            ratioVolumesShapesCrossedByCoordinatePlane = calculateRatioVolumesCrossedByCoordinatePlaneX(tetrahedron);
        } if (dots.get(1).getY() > 0 & dots.get(0).getY() < 0){
            ratioVolumesShapesCrossedByCoordinatePlane = calculateRatioVolumesCrossedByCoordinatePlaneY(tetrahedron);
        } if (dots.get(2).getZ() > 0 & dots.get(0).getZ() < 0){
            ratioVolumesShapesCrossedByCoordinatePlane = calculateRatioVolumesCrossedByCoordinatePlaneZ(tetrahedron);
        }

        return ratioVolumesShapesCrossedByCoordinatePlane;
    }

    private static double calculateRatioVolumesCrossedByCoordinatePlaneX(Tetrahedron tetrahedron){
        double ratioVolumesShapesCrossedByCoordinatePlaneX = 0;
        List<Dot> dots = tetrahedron.getVertexDots();

            Dot dotABaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneX(dots.get(3), dots.get(0));
            Dot dotBBaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneX(dots.get(3), dots.get(1));
            Dot dotCBaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneX(dots.get(3), dots.get(2));
            List<Dot> dotsTopTetrahedron = new ArrayList<>();
            dotsTopTetrahedron.add(dotABaseTetrahedron);
            dotsTopTetrahedron.add(dotBBaseTetrahedron);
            dotsTopTetrahedron.add(dotCBaseTetrahedron);
            dotsTopTetrahedron.add(dots.get(3));
            Tetrahedron topTetrahedron = new Tetrahedron(dotsTopTetrahedron);
            double volumeTopTetrahedron = VolumeTetrahedron.calculateVolumeTetrahedron(topTetrahedron);
            double volumeShape = Math.abs(VolumeTetrahedron.calculateVolumeTetrahedron(tetrahedron) - volumeTopTetrahedron);
            ratioVolumesShapesCrossedByCoordinatePlaneX = volumeShape/volumeTopTetrahedron;

        return ratioVolumesShapesCrossedByCoordinatePlaneX;
    }

    private static double calculateRatioVolumesCrossedByCoordinatePlaneY(Tetrahedron tetrahedron){
        double ratioVolumesShapesCrossedByCoordinatePlaneY = 0;
        List<Dot> dots = tetrahedron.getVertexDots();
            Dot dotABaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneY(dots.get(1), dots.get(0));
            Dot dotCBaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneY(dots.get(1), dots.get(2));
            Dot dotDBaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneY(dots.get(1), dots.get(3));
            List<Dot> dotsTopTetrahedron = new ArrayList<>();
            dotsTopTetrahedron.add(dotABaseTetrahedron);
            dotsTopTetrahedron.add(dots.get(1));
            dotsTopTetrahedron.add(dotCBaseTetrahedron);
            dotsTopTetrahedron.add(dotDBaseTetrahedron);
            Tetrahedron topTetrahedron = new Tetrahedron(dotsTopTetrahedron);
            double volumeTopTetrahedron = VolumeTetrahedron.calculateVolumeTetrahedron(topTetrahedron);
            double volumeShape = Math.abs(VolumeTetrahedron.calculateVolumeTetrahedron(tetrahedron) - volumeTopTetrahedron);
            ratioVolumesShapesCrossedByCoordinatePlaneY = volumeShape/volumeTopTetrahedron;

        return ratioVolumesShapesCrossedByCoordinatePlaneY;
    }

    private static double calculateRatioVolumesCrossedByCoordinatePlaneZ(Tetrahedron tetrahedron){
        double ratioVolumesShapesCrossedByCoordinatePlaneZ = 0;
        List<Dot> dots = tetrahedron.getVertexDots();
            Dot dotABaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneZ(dots.get(2), dots.get(0));
            Dot dotBBaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneZ(dots.get(2), dots.get(1));
            Dot dotDBaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneZ(dots.get(2), dots.get(3));
            List<Dot> dotsTopTetrahedron = new ArrayList<>();
            dotsTopTetrahedron.add(dotABaseTetrahedron);
            dotsTopTetrahedron.add(dotBBaseTetrahedron);
            dotsTopTetrahedron.add(dots.get(2));
            dotsTopTetrahedron.add(dotDBaseTetrahedron);
            Tetrahedron topTetrahedron = new Tetrahedron(dotsTopTetrahedron);
            double volumeTopTetrahedron = VolumeTetrahedron.calculateVolumeTetrahedron(topTetrahedron);
            double volumeShape = Math.abs(VolumeTetrahedron.calculateVolumeTetrahedron(tetrahedron) - volumeTopTetrahedron);
            ratioVolumesShapesCrossedByCoordinatePlaneZ = volumeShape/volumeTopTetrahedron;

        return ratioVolumesShapesCrossedByCoordinatePlaneZ;
    }
}
