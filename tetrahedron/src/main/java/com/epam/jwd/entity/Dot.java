package com.epam.jwd.entity;

import java.util.Objects;

public class Dot {
    private double x;
    private double y;
    private double z;

    public Dot(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot dot = (Dot) o;
        return Double.compare(dot.x, x) == 0 && Double.compare(dot.y, y) == 0 && Double.compare(dot.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "Dot{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
