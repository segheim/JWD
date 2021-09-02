package com.epam.jwd.action;

import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.Tetrahedron;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LengthsSidesTetrahedron {

    public Map calculateLengthsSidesTetrahedron(Tetrahedron tetrahedron){

        List<Dot> dots = tetrahedron.getVertexDots();
        double sideA = calculateSide(dots.get(0), dots.get(1));
        double sideB = calculateSide(dots.get(0), dots.get(2));
        double sideC = calculateSide(dots.get(1), dots.get(2));
        double sideD = calculateSide(dots.get(2), dots.get(3));
        double sideE = calculateSide(dots.get(1), dots.get(3));;
        double sideH = calculateSide(dots.get(0), dots.get(3));

        Map<String, Double> lengthSides = new HashMap<>();
        lengthSides.put("a", sideA);
        lengthSides.put("b", sideB);
        lengthSides.put("c", sideC);
        lengthSides.put("h",sideH);
        lengthSides.put("d", sideD);
        lengthSides.put("e", sideE);

        return lengthSides;
    }

    private double calculateSide(Dot dot1, Dot dot2){
        double side = Math.abs(Math.sqrt(Math.pow(dot2.getX() - dot1.getX(), 2) +
                Math.pow(dot2.getY() - dot1.getY(), 2) +
                Math.pow(dot2.getZ() - dot1.getZ(), 2)));

        return side;
    }
}
