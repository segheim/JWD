package com.epam.jwd.entity;

import java.util.List;
import java.util.Objects;

public class Tetrahedron {

    private List<Dot> vertexDots;

    private Dot dotA;
    private Dot dotB;
    private Dot dotC;
    private Dot dotD;

    public Tetrahedron(Dot dotA, Dot dotB, Dot dotC, Dot dotD){
        this.dotA = dotA;
        this.dotB = dotB;
        this.dotC = dotC;
        this.dotD = dotD;
    }
    public Tetrahedron(List<Dot> vertexDots){
        this.vertexDots = vertexDots;
    }

    public List<Dot> getVertexDots() {
        return vertexDots;
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
