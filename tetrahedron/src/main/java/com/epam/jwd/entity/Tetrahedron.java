package com.epam.jwd.entity;

import java.util.List;
import java.util.Objects;

public class Tetrahedron implements ShapeTetrahedron {

    private List<Dot> vertexDots;

    public Tetrahedron(List<Dot> vertexDots) {
        this.vertexDots = vertexDots;
    }

    public List<Dot> getVertexDots() {
        return vertexDots;
    }

    public void setVertexDots(List<Dot> vertexDots) {
        this.vertexDots = vertexDots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tetrahedron that = (Tetrahedron) o;
        return Objects.equals(vertexDots, that.vertexDots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexDots);
    }

    @Override
    public String toString() {
        return "Tetrahedron{" +
                "vertexDots=" + vertexDots +
                '}';
    }
}
