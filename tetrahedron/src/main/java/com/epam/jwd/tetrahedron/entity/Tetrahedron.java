package com.epam.jwd.entity;

import com.epam.jwd.entity.generator.TetrahedronIdGenerator;

import java.util.List;
import java.util.Objects;

public class Tetrahedron implements ShapeTetrahedron {

    private int tetrahedronId;
    private List<Dot> vertexDots;

    public Tetrahedron(List<Dot> vertexDots) {
        tetrahedronId = TetrahedronIdGenerator.generateId();
        this.vertexDots = vertexDots;
    }

    public List<Dot> getVertexDots() {
        return vertexDots;
    }

    public void setVertexDots(List<Dot> vertexDots) {
        this.vertexDots = vertexDots;
    }

    public int getTetrahedronId() {
        return tetrahedronId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tetrahedron that = (Tetrahedron) o;
        return tetrahedronId == that.tetrahedronId && Objects.equals(vertexDots, that.vertexDots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tetrahedronId, vertexDots);
    }

    @Override
    public String toString() {
        return "Tetrahedron{" +
                "tetrahedronId=" + tetrahedronId +
                ", vertexDots=" + vertexDots +
                '}';
    }
}
