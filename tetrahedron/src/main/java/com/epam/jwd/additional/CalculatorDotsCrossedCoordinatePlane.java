package com.epam.jwd.additional;

import com.epam.jwd.entity.Dot;

public class CalculatorDotsCrossedCoordinatePlane {

    public static Dot calculateDotsCrossedCoordinatePlaneX(Dot dot1, Dot dot2){

        double x = 0;
        double y = (- dot1.getX()) * (dot2.getY() - dot1.getY()) / (dot2.getX() - dot1.getX()) + dot1.getY();
        double z = (- dot1.getX()) * (dot2.getZ() - dot1.getZ()) / (dot2.getX() - dot1.getX()) + dot1.getZ();
        return new Dot(x, y, z);
    }

    public static Dot calculateDotsCrossedCoordinatePlaneY(Dot dot1, Dot dot2){

        double x = (- dot1.getY()) * (dot2.getX() - dot1.getX()) / (dot2.getY() - dot1.getY()) + dot1.getX();
        double y = 0;
        double z = (- dot1.getY()) * (dot2.getZ() - dot1.getZ()) / (dot2.getY() - dot1.getY()) + dot1.getZ();
        return new Dot(x, y, z);
    }

    public static Dot calculateDotsCrossedCoordinatePlaneZ(Dot dot1, Dot dot2){

        double x = (- dot1.getZ()) * (dot2.getX() - dot1.getX()) / (dot2.getZ() - dot1.getZ()) + dot1.getX();
        double y = (- dot1.getZ()) * (dot2.getY() - dot1.getY()) / (dot2.getZ() - dot1.getZ()) + dot1.getY();
        double z = 0;
        return new Dot(x, y, z);
    }
}
