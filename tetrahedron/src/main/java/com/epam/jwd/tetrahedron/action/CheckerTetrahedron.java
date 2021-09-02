package com.epam.jwd.tetrahedron.action;

import com.epam.jwd.tetrahedron.entity.Dot;
import com.epam.jwd.tetrahedron.entity.Tetrahedron;

import java.util.List;

public class CheckerTetrahedron {
    public boolean isTetrahedron(Tetrahedron tetrahedron){
        List<Dot> dots = tetrahedron.getVertexDots();

      return !(((dots.get(0).getX() == dots.get(1).getX()) & (dots.get(0).getX() == dots.get(2).getX())
              & (dots.get(0).getY() == dots.get(1).getY()) & (dots.get(0).getY() == dots.get(2).getY()))
              || ((dots.get(0).getX() == dots.get(1).getX()) & (dots.get(0).getX() == dots.get(2).getX())
              & (dots.get(0).getZ() == dots.get(1).getZ()) & (dots.get(0).getZ() == dots.get(2).getZ()))
              || ((dots.get(0).getY() == dots.get(1).getY()) & (dots.get(0).getY() == dots.get(2).getY())
              & (dots.get(0).getZ() == dots.get(1).getZ()) & (dots.get(0).getZ() == dots.get(2).getZ())));
    }
}
