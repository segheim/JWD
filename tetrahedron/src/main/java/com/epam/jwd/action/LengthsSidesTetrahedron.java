package com.epam.jwd.action;

import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.Tetrahedron;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LengthsSidesTetrahedron {

    public Map calculateLengthsSidesTetrahedron(Tetrahedron tetrahedron){

        List<Dot> dots = tetrahedron.getVertexDots();
        double sideA = Math.abs(Math.sqrt(Math.pow(dots.get(1).getX() - dots.get(0).getX(), 2) +
                Math.pow(dots.get(1).getY() - dots.get(0).getY(), 2) +
                Math.pow(dots.get(1).getZ() - dots.get(0).getZ(), 2)));
        double sideB = Math.abs(Math.sqrt(Math.pow(dots.get(2).getX() - dots.get(0).getX(), 2) +
                Math.pow(dots.get(2).getY() - dots.get(0).getY(), 2) +
                Math.pow(dots.get(2).getZ() - dots.get(0).getZ(), 2)));
        double sideC = Math.abs(Math.sqrt(Math.pow(dots.get(2).getX() - dots.get(1).getX(), 2) +
                Math.pow(dots.get(2).getY() - dots.get(1).getY(), 2) +
                Math.pow(dots.get(2).getZ() - dots.get(1).getZ(), 2)));
        double sideD = Math.abs(Math.sqrt(Math.pow(dots.get(3).getX() - dots.get(2).getX(), 2) +
                Math.pow(dots.get(3).getY() - dots.get(2).getY(), 2) +
                Math.pow(dots.get(3).getZ() - dots.get(2).getZ(), 2)));
        double sideE = Math.abs(Math.sqrt(Math.pow(dots.get(3).getX() - dots.get(1).getX(), 2) +
                Math.pow(dots.get(3).getY() - dots.get(1).getY(), 2) +
                Math.pow(dots.get(3).getZ() - dots.get(1).getZ(), 2)));
        double sideH = dots.get(3).getX() - dots.get(0).getX();

        Map<String, Double> lengthSides = new HashMap<>();
        lengthSides.put("a", sideA);
        lengthSides.put("b", sideB);
        lengthSides.put("c", sideC);
        lengthSides.put("h",sideH);
        lengthSides.put("d", sideD);
        lengthSides.put("e", sideE);

        return lengthSides;
    }
}
