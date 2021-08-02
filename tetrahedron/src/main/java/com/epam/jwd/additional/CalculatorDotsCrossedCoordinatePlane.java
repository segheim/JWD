package com.epam.jwd.additional;

import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.Tetrahedron;

import java.util.List;

public class CalculatorDotsCrossedCoordinatePlane {



    public static Dot calculateDotsCrossedCoordinatePlaneX(Dot dot1, Dot dot2){

        double x1 = dot1.getX();
        double x2 = dot2.getX();
        double y1 = dot1.getY();
        double y2 = dot2.getY();
        double z1 = dot1.getZ();
        double z2 = dot2.getZ();

        double x = 0;
        double y = (- x1) * (y2 - y1) /(x2 - x1) + y1;
        double z = (- x1) * (z2 - z1) /(x2 - x1) + z1;
        return new Dot(x, y, z);
    }

    public static Dot calculateDotsCrossedCoordinatePlaneY(Dot dot1, Dot dot2){

        double x1 = dot1.getX();
        double x2 = dot2.getX();
        double y1 = dot1.getY();
        double y2 = dot2.getY();
        double z1 = dot1.getZ();
        double z2 = dot2.getZ();

        double x = (- y1) * (x2 - x1) /(y2 - y1) + x1;
        double y = 0;
        double z = (- y1) * (z2 - z1) /(y2 - y1) + z1;
        return new Dot(x, y, z);
    }

    public static Dot calculateDotsCrossedCoordinatePlaneZ(Dot dot1, Dot dot2){

        double x1 = dot1.getX();
        double x2 = dot2.getX();
        double y1 = dot1.getY();
        double y2 = dot2.getY();
        double z1 = dot1.getZ();
        double z2 = dot2.getZ();

        double x = (- z1) * (x2 - x1) /(z2 - z1) + x1;
        double y = (- z1) * (y2 - y1) /(z2 - z1) + y1;
        double z = 0;
        return new Dot(x, y, z);
    }



}
