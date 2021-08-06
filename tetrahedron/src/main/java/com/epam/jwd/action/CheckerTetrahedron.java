package com.epam.jwd.action;

import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.Tetrahedron;

import java.math.BigDecimal;
import java.util.List;

public class CheckerTetrahedron {

    private boolean isBaseParallelPlaneY(List<Dot> vertexesTetrahedron) {

        return (vertexesTetrahedron.get(0).getX() == vertexesTetrahedron.get(1).getX()) &
                (vertexesTetrahedron.get(0).getX() == vertexesTetrahedron.get(2).getX());
    }

    private boolean isHeightParallelPlaneX(List<Dot> vertexesTetrahedron) {

        return vertexesTetrahedron.get(0).getY() == vertexesTetrahedron.get(3).getY();
    }

    private boolean isTetrahedronHaveHeight(List<Dot> vertexesTetrahedron) {

        return vertexesTetrahedron.get(3).getX() > vertexesTetrahedron.get(0).getX();
    }

    private boolean isBaseTriangle(List<Dot> vertexesTetrahedron) {

        BigDecimal x = new BigDecimal(vertexesTetrahedron.get(2).getX());
        BigDecimal x1 = new BigDecimal(vertexesTetrahedron.get(0).getX());
        BigDecimal x2 = new BigDecimal(vertexesTetrahedron.get(1).getX());
        BigDecimal y = new BigDecimal(vertexesTetrahedron.get(2).getY());
        BigDecimal y1 = new BigDecimal(vertexesTetrahedron.get(0).getY());
        BigDecimal y2 = new BigDecimal(vertexesTetrahedron.get(1).getY());
        BigDecimal z = new BigDecimal(vertexesTetrahedron.get(2).getZ());
        BigDecimal z1 = new BigDecimal(vertexesTetrahedron.get(0).getZ());
        BigDecimal z2 = new BigDecimal(vertexesTetrahedron.get(1).getZ());
        System.out.println(x + " " + x1 + " " + x2 + " " + y + " " + y1 + " " + y2 + " " + z + " " + z1 + " " + z2);

        try {
            boolean b = ((x.subtract(x1)).divide(x2.subtract(x1))).compareTo((z.subtract(z1)).divide(z2.subtract(z1))) != 0;
            boolean c = ((x.subtract(x1)).divide(x2.subtract(x1))).compareTo((y.subtract(y1)).divide(y2.subtract(y1))) != 0;

            if (c & b) {
                return true;
            }
        } catch (ArithmeticException e) {

        }
        return false;
    }

    public boolean isTetrahedron(Tetrahedron tetrahedron){
        List<Dot> dots = tetrahedron.getVertexDots();
        if (isBaseParallelPlaneY(dots) & isBaseTriangle(dots) & isHeightParallelPlaneX(dots)
                & isTetrahedronHaveHeight(dots)) {
            return true;
        }

        return false;
    }
}

