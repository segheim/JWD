package com.epam.jwd.action;

import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.Tetrahedron;

import java.util.List;

public class CheckerTetrahedron {

    private boolean isBaseOfTetrahedronParallelPlaneY(List<Dot> vertexesTetrahedron) {

        return (vertexesTetrahedron.get(0).getX() == vertexesTetrahedron.get(1).getX()) &
                (vertexesTetrahedron.get(0).getX() == vertexesTetrahedron.get(2).getX());
    }

    private boolean isHeightOfTetrahedronParallelPlaneX(List<Dot> vertexesTetrahedron) {

        return vertexesTetrahedron.get(0).getY() == vertexesTetrahedron.get(3).getY();
    }

    private boolean isTetrahedronHaveHeight(List<Dot> vertexesTetrahedron) {

        return vertexesTetrahedron.get(3).getX() > vertexesTetrahedron.get(0).getX();
    }

    private boolean isBaseOfTetrahedronRepresentsTriangle(List<Dot> vertexesTetrahedron) {

        return (((vertexesTetrahedron.get(2).getX() - vertexesTetrahedron.get(0).getX()) /
                (vertexesTetrahedron.get(1).getX() - vertexesTetrahedron.get(0).getX())) !=
                ((vertexesTetrahedron.get(2).getY() - vertexesTetrahedron.get(0).getY()) /
                        (vertexesTetrahedron.get(1).getY() - vertexesTetrahedron.get(0).getY()))) &
                (((vertexesTetrahedron.get(2).getX() - vertexesTetrahedron.get(0).getX()) /
                        (vertexesTetrahedron.get(1).getX() - vertexesTetrahedron.get(0).getX())) !=
                        ((vertexesTetrahedron.get(2).getZ() - vertexesTetrahedron.get(0).getZ()) /
                                (vertexesTetrahedron.get(1).getZ() - vertexesTetrahedron.get(0).getZ())));
    }

    public boolean isTetrahedron(Tetrahedron tetrahedron){
        List<Dot> dots = tetrahedron.getVertexDots();
        if (isBaseOfTetrahedronParallelPlaneY(dots) & isBaseOfTetrahedronRepresentsTriangle(dots) &
        isHeightOfTetrahedronParallelPlaneX(dots) & isTetrahedronHaveHeight(dots)) {
            return true;
        }

        return false;
    }
}

