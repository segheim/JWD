package com.epam.jwd.action;

import com.epam.jwd.additional.CalculatorDotsCrossedCoordinatePlane;
import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.Tetrahedron;

import java.util.List;

public class RatioVolumesShapesCrossedByCoordinatePlane {
    double ratioVolumesShapesCrossedByCoordinatePlane;

    public double calculateRatioVolumesCrossedByCoordinatePlane(Tetrahedron tetrahedron){

        List<Dot> dots = tetrahedron.getVertexDots();
        if (dots.get(3).getX() > 0 & dots.get(0).getX() < 0){
            Dot dotABaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneX(dots.get(3), dots.get(0));
            Dot dotBBaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneY(dots.get(3), dots.get(1));
            Dot dotCBaseTetrahedron = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneY(dots.get(3), dots.get(2));
            Tetrahedron topTetrahedron = new Tetrahedron(dotABaseTetrahedron, dotBBaseTetrahedron, dotCBaseTetrahedron, dots.get(3));
            double volumeTopTetrahedron = VolumeTetrahedron.calculateVolumeTetrahedron(topTetrahedron);
            double volumeShape = Math.abs(VolumeTetrahedron.calculateVolumeTetrahedron(tetrahedron) - volumeTopTetrahedron);
            ratioVolumesShapesCrossedByCoordinatePlane = volumeShape/volumeTopTetrahedron;
        }




        return ratioVolumesShapesCrossedByCoordinatePlane;
    }
}
